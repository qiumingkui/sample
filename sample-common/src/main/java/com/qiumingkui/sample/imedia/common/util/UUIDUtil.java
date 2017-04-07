package com.qiumingkui.sample.imedia.common.util;

import java.util.UUID;

public class UUIDUtil {

	public static String gen() {
		return UUID.randomUUID().toString().toUpperCase();
	}
}
