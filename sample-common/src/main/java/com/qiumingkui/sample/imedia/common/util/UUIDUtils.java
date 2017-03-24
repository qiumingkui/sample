package com.qiumingkui.sample.imedia.common.util;

import java.util.UUID;

public class UUIDUtils {

	public static String gen() {
		return UUID.randomUUID().toString().toUpperCase();
	}
}
