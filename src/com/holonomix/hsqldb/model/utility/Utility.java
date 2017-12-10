package com.holonomix.hsqldb.model.utility;

import java.lang.reflect.Method;

import com.holonomix.hsqldb.model.Item;

public class Utility {

	public static synchronized String toString(Item item) {

		Method[] methods = item.getClass().getDeclaredMethods();
		Object paramsObj[] = {};
		StringBuffer concatValues = new StringBuffer();
		for (Method method : methods) {
			// concat all attributes there are in object "item"
			if (method.getName().startsWith("get")
					&& method.getName().indexOf("List") == -1) {
				Object obj = null;
				try {
					obj = method.invoke(item, paramsObj);
				} catch (Exception e) {
				}

				if (obj != null && !obj.toString().equalsIgnoreCase("")) {
					concatValues.append(method.getName().substring(3) + "=" + obj.toString()
							+ " ,");
				}

			}
		}

		methods = item.getClass().getSuperclass().getDeclaredMethods();
		for (Method method : methods) {
			// concat all attributes there are in object "item"
			if (method.getName().startsWith("get")
					&& method.getName().indexOf("List") == -1
					&& !method.getName().equalsIgnoreCase("getId")
					&& !method.getName().equalsIgnoreCase("getDateCreated")
					&& !method.getName().equalsIgnoreCase("getLastUpdated")
					&& !method.getName().equalsIgnoreCase("getVersion")
					&& !method.getName().equalsIgnoreCase("getFlagStatus")) {
				Object obj = null;
				try {
					obj = method.invoke(item, paramsObj);
				} catch (Exception e) {
				}
				if (obj != null) {
					if (obj != null && !obj.toString().equalsIgnoreCase("")) {
						concatValues.append(method.getName().substring(3) + "="
								+ obj.toString() + " ,");
					}
				}

			}
		}
		return concatValues.toString();

	}

	

}
