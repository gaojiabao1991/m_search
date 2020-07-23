package cn.sheeva;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.apache.commons.text.StringSubstitutor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by sheeva on 2020/7/21.
 */
public class MUtil {
    public static String template(String template, Map<String, String> var) {
        StringSubstitutor sub = new StringSubstitutor(var);
        return sub.replace(template);
    }

    public static String readSourceFileAsString(String path) {
        URL url = Resources.getResource(path);
        try {
            return Resources.toString(url, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readSourceFileAsList(String path, Predicate<String> filter) {
        InputStream is = MUtil.class.getClassLoader().getResourceAsStream(path);
        try {
            return IOUtils.readLines(is, StandardCharsets.UTF_8).stream().filter(filter).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readSourceFileAsList(String path) {
        return readSourceFileAsList(path, s -> true);
    }

    public static String toPrettyFormat(String json) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(jsonObject);
    }

    public static String getAbsPath(String... projectPaths) {

        return Paths.get("").toAbsolutePath().toString() + "\\" + String.join("\\", projectPaths);
    }
}
