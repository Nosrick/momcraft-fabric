package io.github.nosrick.util;

import java.util.Random;

public class HexCodeGenerator {

    private static final Random RANDOM = new Random();

    public static int generate() {
        return RANDOM.nextInt(0xffffff + 1);
    }
}
