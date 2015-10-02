package qvdev.utils.simplypojo;

import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.SourceType;

public class JsonConfig extends DefaultGenerationConfig {
    @Override
    public SourceType getSourceType() {
        return SourceType.JSON;
    }
}