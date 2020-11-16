package com.kuang.utils;

import java.util.UUID;

/**
 * @Author: Z.HAN
 * @Date: 2020/11/15 22:21
 */
public class IdUtils {
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
