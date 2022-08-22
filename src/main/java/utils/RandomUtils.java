package utils;

import java.util.Random;

public class RandomUtils {

    public static String generateString(int size) {
        String text = "ABCDEFGHIJKLMNOPQRSTUVWXZ0123456789";
        StringBuilder sb = new StringBuilder(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int index = random.nextInt(text.length());
            char randomChar = text.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}