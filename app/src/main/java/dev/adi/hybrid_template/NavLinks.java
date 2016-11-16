package dev.adi.hybrid_template;

import java.util.HashMap;
import java.util.Map;

public class NavLinks {
    public static Map<String, String> links;

    static {
        links = new HashMap<String, String>();
        links.put("About", "about");
        links.put("Contact", "contact");
        links.put("Products", "products");
    }
}
