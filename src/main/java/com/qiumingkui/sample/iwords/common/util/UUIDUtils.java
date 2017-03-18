package com.qiumingkui.sample.iwords.common.util;

import java.util.UUID;

public class UUIDUtils {

	public static String gen() {
		return UUID.randomUUID().toString().toUpperCase();
	}
}
