package io.github.nosrick.common.util;

import io.github.nosrick.MoMCraftMod;
import net.minecraft.util.Identifier;

import java.util.Arrays;

public enum SchoolIcon {
    LIFE(0, "life"),
    DEATH(1, "death"),
    CHAOS(2, "chaos"),
    NATURE(3, "nature"),
    SORCERY(4, "sorcery"),
    ARCANE(5, "arcane");

    private SchoolIcon(int code, String name) {
        this.code = code;
        this.name = name;
        this.identifier = MoMCraftMod.identifier(path + "icon_" + name);
    }

    public static SchoolIcon valueOf(int code) {
        return Arrays.stream(SchoolIcon.values())
                .filter(icon -> icon.code == code)
                .findFirst()
                .get();
    }

    public final int code;
    public final String name;
    public final Identifier identifier;

    private static final String path = "textures/gui/";
}
