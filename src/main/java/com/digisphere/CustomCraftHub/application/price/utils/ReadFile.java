package com.digisphere.CustomCraftHub.application.price.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReadFile {

    public static List<Double> read(String fileName, Map<String, String> materials) {
        List<Double> result = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(fileName));

            for (Map.Entry<String, String> entry : materials.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                JsonNode targetNode = findNodeByKeyValue(rootNode, key, value);

                if (targetNode != null && targetNode.isNumber()) {
                    double price = targetNode.asDouble();
                    result.add(price);
                }
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return result;
    }

    private static JsonNode findNodeByKeyValue(JsonNode node, String key, String value) {
        if (node.isObject()) {
            for (Iterator<Map.Entry<String, JsonNode>> it = node.fields(); it.hasNext(); ) {
                Map.Entry<String, JsonNode> field = it.next();
                if (field.getKey().equalsIgnoreCase(key)) {
                    JsonNode subNode = field.getValue();
                    if (subNode.has(value)) {
                        return subNode.get(value);
                    }
                }
                JsonNode found = findNodeByKeyValue(field.getValue(), key, value);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }
}
