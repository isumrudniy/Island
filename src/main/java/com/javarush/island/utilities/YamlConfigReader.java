package com.javarush.island.utilities;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;

public class YamlConfigReader {
    private HashMap<String, Object> configMap = new HashMap<>();

    public YamlConfigReader(Class<?> clazz) {
        Config Config = clazz.getAnnotation(Config.class);
        if (Config == null) {
            throw new IllegalArgumentException("Class must be annotated with @Config");
        }

        String yamlFilePath = Config.fileName();
        Yaml yaml = new Yaml();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(yamlFilePath)) {
            configMap = yaml.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public Object getConfigValue(String key) {
        return configMap.get(key);
    }

    public HashMap<String, Object> getConfigMap() {
        return configMap;
    }
}
