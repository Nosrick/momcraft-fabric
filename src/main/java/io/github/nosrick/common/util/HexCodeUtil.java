package io.github.nosrick.common.util;

import java.util.Random;
import java.util.UUID;

public class HexCodeUtil {

    private static final Random RANDOM = new Random();

    public static int generate(UUID uuid) {
        long mostSignificant = uuid.getMostSignificantBits();

        return (int)(mostSignificant & 0xFFFFFF);
    }
}
