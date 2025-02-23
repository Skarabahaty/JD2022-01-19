package by.it.yushkevich.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {

    INSTANCE;
    public static final String BASE_NAME = "by.it.yushkevich.jd02_05.resources.language";

    private ResourceBundle resourceBundle;

    ResourceManager(){
        Locale.setDefault(Locale.ENGLISH);
        set(Locale.ENGLISH);
    }

    public void set(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }

    public String get(String key) {
            return resourceBundle.getString(key);
    }
}
