package com.mahajana.functions;

import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;


public final class PageFileParser {
    private static final String PAGE_LOCATION = new EnvironmentContext().getProperty("pageObjectFile");
    private static Iterable<Object> pageObject = null;
    private static Map<String, Object> pageSelector = null;

    public PageFileParser() {
        initialize();
    }

    private void initialize() {
        InputStream input;
        input = PageFileParser.class.getClassLoader().getResourceAsStream(PAGE_LOCATION);
        if (input != null) {
            pageObject = new Yaml().loadAll(input);
            System.out.println("Leaving Initialize");
        }
        else System.out.println("Could not find pageObject file.");
    }

    public Map<String, Object> loadPage(String pageName) {
        for (Object data : pageObject) {
            pageSelector = (Map<String, Object>) data;
            if (pageSelector.get("name").toString().equals(pageName)) {
                System.out.println("Loading page selector for: " + pageSelector.get("name").toString());
                return pageSelector;
            }
        }
        System.out.println("could not find the page: " + pageName);
        return null;
    }

    public String getElementSelector(String elementName) {
        try {
            return  pageSelector.get(elementName).toString();
        }catch (NullPointerException e) {
            throw new IllegalStateException("can't find selector value for: " + elementName);
        }
    }
}
