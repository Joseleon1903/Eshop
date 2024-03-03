package com.ecommerce.react.api.util;

import com.google.gson.annotations.SerializedName;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class ConstantUtil {

    public static final String IMAGE_SIZE_TYPE = "MB";

    public static String humanReadableByteCountSI(long bytes) {
        if (-1000 < bytes && bytes < 1000) {
            return bytes + " B";
        }
        CharacterIterator ci = new StringCharacterIterator("kMGTPE");
        while (bytes <= -999_950 || bytes >= 999_950) {
            bytes /= 1000;
            ci.next();
        }
        return String.format("%.1f %cB", bytes / 1000.0, ci.current());
    }

    public static JSONObject quickParse(Object obj) throws IllegalArgumentException, IllegalAccessException, JSONException {
        JSONObject object = new JSONObject();

        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
        for(Field field : fields) {
            field.setAccessible(true);
            Annotation[] annotations = field.getDeclaredAnnotations();
            for(Annotation annotation : annotations){
                if(annotation instanceof SerializedName){
                    SerializedName myAnnotation = (SerializedName) annotation;
                    String name = myAnnotation.value();
                    Object value = field.get(obj);

                    if(value == null)
                        value = new String("");

                    object.put(name, value);
                }
            }
        }

        return object;
    }

}
