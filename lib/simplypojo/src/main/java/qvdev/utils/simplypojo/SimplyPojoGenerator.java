package qvdev.utils.simplypojo;

import com.sun.codemodel.JCodeModel;

import org.jsonschema2pojo.GsonAnnotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class SimplyPojoGenerator {

    private final String mDestinationFolder;
    private String mDestinationPackageName;

    public SimplyPojoGenerator(String destinationFolder, String destinationPackageName) {
        if (!destinationPackageName.endsWith(".")) {
            destinationPackageName = destinationPackageName + ".";
        }

        mDestinationFolder = destinationFolder;
        mDestinationPackageName = destinationPackageName;
    }

    /**
     * Generate pojos from urls passed.
     *
     * @param urlMap {@link java.util.HashMap}
     *               {@link String} class name
     *               {@link String} url
     */
    public void simplyGeneratePojos(Map<String, String> urlMap) {
        Iterator it = urlMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            generateModels(pair.getKey().toString(), pair.getValue().toString());
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    private void generateModels(String className, String url) {
        String packageName = mDestinationPackageName + className.toLowerCase();
        URL source = null;

        try {
            source = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        JCodeModel codeModel = new JCodeModel();
        JsonConfig generationConfig = new JsonConfig();
        RuleFactory ruleFactory = new RuleFactory(generationConfig, new GsonAnnotator(), new SchemaStore());
        SchemaGenerator generator = new SchemaGenerator();

        SchemaMapper mapper = new SchemaMapper(ruleFactory, generator);
        try {
            mapper.generate(codeModel, className, packageName, source);
            codeModel.build(new File(mDestinationFolder));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
