package com.zty.util;

import java.util.Random;

public class RandomSaltUtil {
    public static String generetRandomSaltCode() {

        char[] str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456".toCharArray();

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {

            int randomIndex = random.nextInt(str.length);

            sb.append(str[randomIndex]);
        }
        return sb.toString();
    }
}
