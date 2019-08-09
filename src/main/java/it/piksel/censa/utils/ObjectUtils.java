package it.piksel.censa.utils;

import java.lang.reflect.Field;

import org.springframework.stereotype.Component;

@Component
public class ObjectUtils {
	
	//il merge non funzina bene, i campi che erano null rimangono null
	public <T> T merge(T actual, T patch) throws IllegalAccessException, InstantiationException {
		Class<?> clazz = actual.getClass();
		Object merged = clazz.newInstance();
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			Object localValue = field.get(actual);
			Object remoteValue = field.get(patch);
			if (localValue != null) {
				switch (localValue.getClass().getSimpleName()) {
				case "Default":
				case "Detail":
					field.set(merged, merge(localValue, remoteValue));
					break;
				default:
					field.set(merged, (remoteValue != null) ? remoteValue : localValue);
				}
			}
		}
		return (T) merged;
	}
}
