package com.javacourse.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {
    public static String getProperty(String key) {
        Locale locale = new Locale("ukr","UA");//TODO: en and/or rus locale
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", locale);
        return resourceBundle.getString(key);
    }
}
