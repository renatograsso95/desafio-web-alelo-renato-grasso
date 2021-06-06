package br.com.alelo.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyReader {

    private static Properties prop = new Properties();
    private static InputStream input = null;
    private static String pathProperties = Paths.get("").toAbsolutePath().toString()
            + "\\src\\test\\resources\\config\\config.properties";

    private static void loadProperty() {
        try {
            input = new FileInputStream(pathProperties);
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if (prop.size() <= 0)
            loadProperty();
        if (!prop.containsKey(key)) {
            throw new RuntimeException("Não existe a chave [ " + key + " ] no arquivo properties: " + pathProperties);
        }
        return prop.getProperty(key);
    }

}