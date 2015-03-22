package com.zy.wechat.util;

import java.lang.reflect.Field;

public class CommonUtils {

	//TODO
	public static String reflectToString(Class<?> clazz) {
		Field[] fields = clazz.getClass().getFields();
		StringBuilder sb = new StringBuilder();
		sb.append(clazz.getName());
		sb.append("@(");
		for(Field f : fields){
			try {
				sb.append(f.getName() + ":" + f.get(f.getName()) + ",");
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(")");
		return null;
	}
}
