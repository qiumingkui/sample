package com.qiumingkui.ddd.sample.common.util;

import java.util.UUID;

public class UUIDUtils {

	public static String gen(){
		return UUID.randomUUID().toString().toUpperCase();
	}
}
