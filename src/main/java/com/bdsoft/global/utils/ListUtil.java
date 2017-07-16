package com.bdsoft.global.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtil {

	// 把对象数组转换成java.util.List
	public static List oTOl(Object[] obj) {
		if (obj != null && obj.length > 0) {
			List list = Arrays.asList(obj);
			return new ArrayList(list);
		} else {
			return new ArrayList();
		}
	}
}