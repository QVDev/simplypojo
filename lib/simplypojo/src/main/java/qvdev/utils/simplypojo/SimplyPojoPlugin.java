package qvdev.utils.simplypojo;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class SimplyPojoPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getExtensions().create("simplyConfiguration", SimplyPojoPluginExtension.class);
        project.getTasks().create("simplyGenerate", SimplyPojoTask.class);
    }
}