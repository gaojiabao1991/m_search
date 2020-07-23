import cn.sheeva.MUtil;

import java.io.FileNotFoundException;
import java.nio.file.Paths;

/**
 * Created by sheeva on 2020/7/21.
 */
public class Test {
    @org.junit.Test
    public void test() throws FileNotFoundException {
//        Map<String, String> m = new HashMap<String, String>();
//        m.put("animal", "quick brown fox");
//        m.put("target", "lazy dog");
//        String templateString = "The ${animal} jumped over the ${target}.";
//
//        System.out.println(MUtil.template(templateString, m));
        System.out.println(Paths.get("").toAbsolutePath().toString());
        System.out.println(MUtil.getAbsPath("scripts","es_mapping.json"));
    }
}
