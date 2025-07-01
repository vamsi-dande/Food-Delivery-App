package com.tap.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class TemplateUtil {

    public static String loadTemplate(String templatePath, Map<String, String> replacements) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(templatePath)));

        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            content = content.replace("${" + entry.getKey() + "}", entry.getValue());
        }
        return content;
    }
}

