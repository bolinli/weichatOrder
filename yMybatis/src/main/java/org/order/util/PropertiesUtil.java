/*
 *Copyright © 2018 CIDI
 *长沙智能驾驶研究院有限公司
 *http://cidi.ai
 *All rights reserved.
 */
package org.order.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;

/**
 * 解析配置文件，配置Spring使用
 * 
 * @author LiuYa
 * @version 2016年7月30日 下午11:41:53
 */
//public final class PropertiesUtil extends PropertyPlaceholderConfigurer {
public class PropertiesUtil extends PropertyPlaceholderConfigurer {
    private List<String> decryptProperties;
    private static Map<String, String> ctxPropertiesMap = new HashMap<String, String>();

    public static Map<String, String> getProperties() {
        return ctxPropertiesMap;
    }

    /**
     * Get a value based on key , if key does not exist , null is returned
     * 
     * @param key
     * @return
     */
    public static String getString(String key) {
        try {
            return ctxPropertiesMap.get(key);
        } catch (MissingResourceException e) {
            return null;
        }
    }

    /**
     * Get a value based on key , if key does not exist , null is returned
     * 
     * @param key
     * @return
     */
    public static String getString(String key, String defaultValue) {
        try {
            String value = ctxPropertiesMap.get(key);
            if (StringUtils.isEmpty(value)) {
                return defaultValue;
            }
            return value;
        } catch (MissingResourceException e) {
            return defaultValue;
        }
    }

    /**
     * 根据key获取值
     * 
     * @param key
     * @return
     */
    public static int getInt(String key) {
        return Integer.parseInt(ctxPropertiesMap.get(key));
    }

    /**
     * 根据key获取值
     * 
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getInt(String key, int defaultValue) {
        String value = ctxPropertiesMap.get(key);
        if (StringUtils.isBlank(value)) {
            return defaultValue;
        }
        return Integer.parseInt(value);
    }

    /**
     * 从配置文件中取得 long 值，若无（或解析异常）则返回默认值
     * @param keyName 属性名
     * @param defaultValue 默认值
     * @return 属性值
     */
    public static long getLong(String keyName, long defaultValue) {
        String value = getString(keyName);
        if (value != null && value.length() > 0) {
            try {
                long parseValue = Long.parseLong(value.trim());
                return parseValue;
            } catch (Exception e) {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    /**
     * 根据key获取值
     * 
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBoolean(String key, boolean defaultValue) {
        String value = ctxPropertiesMap.get(key);
        if (StringUtils.isBlank(value)) {
            return defaultValue;
        }
        return new Boolean(value.trim());
    }

    public void setDecryptProperties(List<String> decryptProperties) {
        this.decryptProperties = decryptProperties;
    }

    public List<String> getDecryptProperties() {
        return decryptProperties;
    }
}
