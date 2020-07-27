package io.github.nosrick.util;

import java.awt.*;
import java.util.Random;

public class HexCodeUtil {

    private static final Random RANDOM = new Random();

    public static int generate() {
        return RANDOM.nextInt(0xffffff + 1);
    }

    public static Color getCodeAsColor(int code) {
        return new Color(code);
    }
}
