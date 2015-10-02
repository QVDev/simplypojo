package qvdev.utils.simplypojo;

import java.util.HashMap;
import java.util.Map;

public class DemoMain {

    private static final String GENERATED_POJO_SRC_DESTINATION = "simplypojo/src/main/java/";
    private static final String GENERATED_POJO_SRC_PACKAGE = "qvdev.utils.simplypojo.generated";

    public static void main(String args[]) {

        //Add Classname and json url to fetch
        Map<String, String> urls = new HashMap<>();
        urls.put("Example", "https://ajax.googleapis.com/ajax/services/feed/find?v=1.0&q=Official%20Google%20Blogs");

        //Initiate the generator with the destination folder
        SimplyPojoGenerator simplyPojoGenerator = new SimplyPojoGenerator(GENERATED_POJO_SRC_DESTINATION, GENERATED_POJO_SRC_PACKAGE);
        simplyPojoGenerator.simplyGeneratePojos(urls);
    }

}
