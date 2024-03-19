package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import constatnts.FrameworkConstants;
import enums.ConfigProp;

public class PropUtil {

	private PropUtil() {
	}

	private static Map<String, String> CONFIGMAP = new HashMap<>();
	private static Properties property = new Properties();

	static {
		try {
			FileInputStream file = new FileInputStream(FrameworkConstants.getConfigPropPath());
			property.load(file);

			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(ConfigProp Key) {
		return CONFIGMAP.get(Key.name().toLowerCase());
	}
}
