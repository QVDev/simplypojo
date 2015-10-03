package qvdev.utils.simplypojo;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.util.Map;

public class SimplyPojoTask extends DefaultTask {

    @TaskAction
    public void simplyGenerate() {
        SimplyPojoPluginExtension extension = getProject().getExtensions().findByType(SimplyPojoPluginExtension.class);
        if (extension == null) {
            extension = new SimplyPojoPluginExtension();
        }

        Map<String, String> urls = extension.getUrls();
        String destination = extension.getDestination();
        String packageName = extension.getPackageName();

        System.out.println(urls.toString() + " " + destination + " " + packageName);
        generate(urls, destination, packageName);
    }

    private void generate(Map<String, String> urls, String destination, String packageName) {
        //Initiate the generator with the destination folder
        SimplyPojoGenerator simplyPojoGenerator = new SimplyPojoGenerator(destination, packageName);
        simplyPojoGenerator.simplyGeneratePojos(urls);
    }

}