package cn.sheeva;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.util.Pair;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sheeva on 2020/7/21.
 */
public class ESMappingGenerator {

    public static void main(String[] args) throws IOException {
        List<String> fieldJsons = new ArrayList<>(50);
        for (String line : MUtil.readSourceFileAsList(Files.STRUCT, s -> s.length() > 0 && !s.startsWith("#"))) {
            boolean valid = StringUtils.countMatches(line, " - ") == 1 && StringUtils.countMatches(line, "//") == 2;
            if (!valid) throw new RuntimeException(line);
            String[] name$desc = line.split(" - ", 2);
            String name = name$desc[0].trim();
            String desc = name$desc[1].trim();
            String[] type$use$attrs = desc.split("//", 3);
            String type = type$use$attrs[0];
            String attrs = type$use$attrs[2];
            String fieldJson = generateFieldJson(name, type, parseAttrs(attrs));
            fieldJsons.add(fieldJson);
        }
        String mappingJson = MUtil.template(MUtil.readSourceFileAsString(Files.TEMPLATE), ImmutableMap.of("fields", String.join(",\n", fieldJsons)));
        mappingJson = MUtil.toPrettyFormat(mappingJson);
        FileUtils.writeStringToFile(new File(MUtil.getAbsPath("scripts","es_mapping.json")), mappingJson, StandardCharsets.UTF_8);
    }

    private static List<Pair<String, String>> parseAttrs(String attrs) {
        if (attrs.trim().length() == 0) return Collections.emptyList();
        List<Pair<String, String>> r = new ArrayList<>(4);
        String[] attrArr = attrs.split(",");
        for (String attr : attrArr) {
            String[] k$v = attr.split("=");
            r.add(new Pair<>(k$v[0].trim(), k$v[1].trim()));
        }
        return r;
    }

    private static String generateFieldJson(String name, String type, List<Pair<String, String>> attrs) {
        StringBuilder attrsJson = new StringBuilder();
        if (attrs.size() > 0) {
            attrsJson.append(",\n");
            attrsJson.append(attrs.stream().map(e -> String.format("\"%s\": \"%s\"", e.getFirst(), e.getSecond())).collect(Collectors.joining(",\n")));
        }
        ImmutableMap<String, String> m = ImmutableMap.of("name", name, "type", type, "attrs", attrsJson.toString());
        return MUtil.template(MUtil.readSourceFileAsString(Files.FIELD_TEMPLATE), m);


    }

}
