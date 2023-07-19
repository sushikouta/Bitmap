public class SColorMK2 {
    public int R = 0;
    public int G = 0;
    public int B = 0;
    public double A = 1;

    public SColorMK2(int RGB) {
        R = RGB >> 16 & 0xFF;
        G = RGB >> 8 & 0xFF;
        B = RGB & 0xFF;
    }
    public SColorMK2(int R, int G, int B) {
        this.R = R;
        this.G = G;
        this.B = B;
    }
    public SColorMK2(int R, int G, int B, int A) {
        this(R, G, B);
        this.A = A;
    }
    public SColorMK2(int RGB, double A) {
        this(RGB);
        this.A = A;
    }
    public SColorMK2(SColorMK2 color, double A) {
        R = color.R;
        G = color.G;
        B = color.B;
        this.A = A;
    }
    public SColorMK2(String hex) {
        this(Integer.decode(hex.charAt(0) == '#' ? hex.substring(1) : hex));
    }

    public String toString() {
        return "R: " + R + ", G:" + G + ", B: " + B + ", A: " + A;
    }
    public SColorMK2 mix(SColorMK2 color) {
        // System.out.println("R: " + R + ", A: " + color.A + ", M: " + color.R + ", R: " + (int) (R * (1 - color.A) + color.R * color.A));
        return new SColorMK2(
            (int) (R * (1 - color.A) + color.R * color.A), 
            (int) (G * (1 - color.A) + color.G * color.A), 
            (int) (B * (1 - color.A) + color.B * color.A)
        );
    }
    public int toNoAlpha() {
        return R << 16 | G << 8 | B;
    }

    public static final SColorMK2 INDIAN_RED = new SColorMK2(0xCD5C5C);
    public static final SColorMK2 LIGHT_CORAL = new SColorMK2(0xF08080);
    public static final SColorMK2 SALMON = new SColorMK2(0xFA8072);

    public static final SColorMK2 RED = new SColorMK2(0xFF0000);
    public static final SColorMK2 CRIMSON = new SColorMK2(0xDC143C);
    public static final SColorMK2 FIRE_BRICK = new SColorMK2(0xB22222);
    public static final SColorMK2 DARK_RED = new SColorMK2(0x8B0000);

    public static final SColorMK2 PINK = new SColorMK2(0xFFC0CB);
    public static final SColorMK2 LIGHT_PINK = new SColorMK2(0xFFB6C1);
    public static final SColorMK2 HOT_PINK = new SColorMK2(0xFF69B4);
    public static final SColorMK2 DEEP_PINK = new SColorMK2(0xFF1493);

    public static final SColorMK2 MEDIUM_VIOLET_RED = new SColorMK2(0xC71585);
    public static final SColorMK2 PALE_VIOLET_RED = new SColorMK2(0xDB7093);

    public static final SColorMK2 DARK_SALMON = new SColorMK2(0xE9967A);
    public static final SColorMK2 LIGHT_SALMON = new SColorMK2(0xFFA07A);
    public static final SColorMK2 CORAL = new SColorMK2(0xFF7F50);
    public static final SColorMK2 TOMATO = new SColorMK2(0xFF6347);

    public static final SColorMK2 GOLD = new SColorMK2(0xFFD700);
    public static final SColorMK2 YELLOW = new SColorMK2(0xFFFF00);

    public static final SColorMK2 LIGHT_YELLOW = new SColorMK2(0xFFFFE0);
    public static final SColorMK2 LEMON_CHIFFON = new SColorMK2(0xFFFACD);
    public static final SColorMK2 LIGHT_GOLDENROD_YELLOW = new SColorMK2(0xFAFAD2);

    public static final SColorMK2 PAPAYA_WHIP = new SColorMK2(0xFFEFD5);
    public static final SColorMK2 MOCCASIN = new SColorMK2(0xFFE4B5);
    public static final SColorMK2 PEACH_PUFF = new SColorMK2(0xFFDAB9);

    public static final SColorMK2 PALE_GOLDENROD = new SColorMK2(0xEEE8AA);
    public static final SColorMK2 KHAKI = new SColorMK2(0xF0E68C);
    public static final SColorMK2 DARK_KHAKI = new SColorMK2(0xBDB76B);

    public static final SColorMK2 LAVENDER = new SColorMK2(0xE6E6FA);
    public static final SColorMK2 THISTLE = new SColorMK2(0xD8BFD8);
    public static final SColorMK2 PLUM = new SColorMK2(0xDDA0DD);
    public static final SColorMK2 VIOLET = new SColorMK2(0xEE82EE);
    public static final SColorMK2 ORCHID = new SColorMK2(0xDA70D6);

    public static final SColorMK2 FUCHSIA = new SColorMK2(0xFF00FF);
    public static final SColorMK2 MAGENTA = new SColorMK2(0xFF00FF);
    public static final SColorMK2 MEDIUM_ORCHID = new SColorMK2(0xBA55D3);

    public static final SColorMK2 MEDIUM_PURPLE = new SColorMK2(0x9370DB);
    public static final SColorMK2 REBECCA_PURPLE = new SColorMK2(0x663399);
    public static final SColorMK2 BLUE_VIOLET = new SColorMK2(0x8A2BE2);
    public static final SColorMK2 DARK_VIOLET = new SColorMK2(0x9400D3);
    public static final SColorMK2 DARK_ORCHID = new SColorMK2(0x9932CC);

    public static final SColorMK2 DARK_MAGENTA = new SColorMK2(0x8B008B);
    public static final SColorMK2 PURPLE = new SColorMK2(0x800080);

    public static final SColorMK2 INDIGO = new SColorMK2(0x4B0082);

    public static final SColorMK2 SLATE_BLUE = new SColorMK2(0x6A5ACD);
    public static final SColorMK2 DARK_SLATE_BLUE = new SColorMK2(0x483D8B);

    public static final SColorMK2 GREEN_YELLOW = new SColorMK2(0xADFF2F);
    public static final SColorMK2 CHARTREUSE = new SColorMK2(0x7FFF00);
    public static final SColorMK2 LAWN_GREEN = new SColorMK2(0x7CFC00);
    public static final SColorMK2 LIME = new SColorMK2(0x00FF00);
    public static final SColorMK2 LIME_GREEN = new SColorMK2(0x32CD32);

    public static final SColorMK2 PALE_GREEN = new SColorMK2(0x98FB98);
    public static final SColorMK2 LIGHT_GREEN = new SColorMK2(0x90EE90);
    public static final SColorMK2 MEDIUM_SPRING_GREEN = new SColorMK2(0x00FA9A);
    public static final SColorMK2 SPRING_GREEN = new SColorMK2(0x00FF7F);

    public static final SColorMK2 MEDIUM_SEA_GREEN = new SColorMK2(0x3CB371);
    public static final SColorMK2 SEA_GREEN = new SColorMK2(0x2E8B57);
    public static final SColorMK2 FOREST_GREEN = new SColorMK2(0x228B22);
    public static final SColorMK2 GREEN = new SColorMK2(0x008000);
    public static final SColorMK2 DARK_GREEN = new SColorMK2(0x006400);

    public static final SColorMK2 YELLOW_GREEN = new SColorMK2(0x9ACD32);
    public static final SColorMK2 OLIVE_DRAB = new SColorMK2(0x6B8E23);
    public static final SColorMK2 OLIVE = new SColorMK2(0x808000);
    public static final SColorMK2 DARK_OLIVE_GREEN = new SColorMK2(0x556B2F);

    public static final SColorMK2 DARK_SEA_GREEN = new SColorMK2(0x8FBC8B);

    public static final SColorMK2 MEDIUM_AQUAMARINE = new SColorMK2(0x66CDAA);
    public static final SColorMK2 LIGHT_SEA_GREEN = new SColorMK2(0x20B2AA);
    public static final SColorMK2 DARK_CYAN = new SColorMK2(0x008B8B);
    public static final SColorMK2 TEAL = new SColorMK2(0x008080);

    public static final SColorMK2 AQUA = new SColorMK2(0x00FFFF);
    public static final SColorMK2 CYAN = new SColorMK2(0x00FFFF);

    public static final SColorMK2 LIGHT_CYAN = new SColorMK2(0xE0FFFF);
    public static final SColorMK2 PALE_TURQUOISE = new SColorMK2(0xAFEEEE);

    public static final SColorMK2 AQUAMARINE = new SColorMK2(0x7FFFD4);
    public static final SColorMK2 TURQUOISE = new SColorMK2(0x40E0D0);
    public static final SColorMK2 MEDIUM_TURQUOISE = new SColorMK2(0x48D1CC);
    public static final SColorMK2 DARK_TURQUOISE = new SColorMK2(0x00CED1);

    public static final SColorMK2 CADET_BLUE = new SColorMK2(0x5F9EA0);

    public static final SColorMK2 STEEL_BLUE = new SColorMK2(0x4682B4);

    public static final SColorMK2 LIGHT_STEEL_BLUE = new SColorMK2(0xB0C4DE);
    public static final SColorMK2 POWDER_BLUE = new SColorMK2(0xB0E0E6);
    public static final SColorMK2 LIGHT_BLUE = new SColorMK2(0xADD8E6);
    public static final SColorMK2 SKY_BLUE = new SColorMK2(0x87CEEB);
    public static final SColorMK2 LIGHT_SKY_BLUE = new SColorMK2(0x87CEFA);
    public static final SColorMK2 DEEP_SKY_BLUE = new SColorMK2(0x00BFFF);
    public static final SColorMK2 DODGER_BLUE = new SColorMK2(0x1E90FF);
    public static final SColorMK2 CORNFLOWER_BLUE = new SColorMK2(0x6495ED);
    public static final SColorMK2 MEDIUM_SLATE_BLUE = new SColorMK2(0x7B68EE);
    public static final SColorMK2 ROYAL_BLUE = new SColorMK2(0x4169E1);
    public static final SColorMK2 BLUE = new SColorMK2(0x0000FF);
    public static final SColorMK2 MEDIUM_BLUE = new SColorMK2(0x0000CD);

    public static final SColorMK2 DARK_BLUE = new SColorMK2(0x00008B);
    public static final SColorMK2 NAVY = new SColorMK2(0x000080);
    public static final SColorMK2 MIDNIGHT_BLUE = new SColorMK2(0x191970);

    public static final SColorMK2 CORNSILK = new SColorMK2(0xFFF8DC);
    public static final SColorMK2 BLANCHED_ALMOND = new SColorMK2(0xFFEBCD);
    public static final SColorMK2 BISQUE = new SColorMK2(0xFFE4C4);
    public static final SColorMK2 NAVAJO_WHITE = new SColorMK2(0xFFDEAD);
    public static final SColorMK2 WHEAT = new SColorMK2(0xF5DEB3);
    public static final SColorMK2 BURLY_WOOD = new SColorMK2(0xDEB887);
    public static final SColorMK2 TAN = new SColorMK2(0xD2B48C);

    public static final SColorMK2 ROSY_BROWN = new SColorMK2(0xBC8F8F);
    public static final SColorMK2 SANDY_BROWN = new SColorMK2(0xF4A460);

    public static final SColorMK2 GOLDENROD = new SColorMK2(0xDAA520);
    public static final SColorMK2 DARK_GOLDENROD = new SColorMK2(0xB8860B);
    public static final SColorMK2 PERU = new SColorMK2(0xCD853F);
    public static final SColorMK2 CHOCOLATE = new SColorMK2(0xD2691E);
    public static final SColorMK2 SADDLE_BROWN = new SColorMK2(0x8B4513);
    public static final SColorMK2 SIENNA = new SColorMK2(0xA0522D);
    public static final SColorMK2 BROWN = new SColorMK2(0xA52A2A);
    public static final SColorMK2 MAROON = new SColorMK2(0x800000);

    public static final SColorMK2 WHITE = new SColorMK2(0xFFFFFF);
    public static final SColorMK2 SNOW = new SColorMK2(0xFFFAFA);
    public static final SColorMK2 HONEYDEW = new SColorMK2(0xF0FFF0);
    public static final SColorMK2 MINT_CREAM = new SColorMK2(0xF5FFFA);
    public static final SColorMK2 AZURE = new SColorMK2(0xF0FFFF);
    public static final SColorMK2 ALICE_BLUE = new SColorMK2(0xF0F8FF);
    public static final SColorMK2 GHOST_WHITE = new SColorMK2(0xF8F8FF);
    public static final SColorMK2 WHITE_SMOKE = new SColorMK2(0xF5F5F5);
    public static final SColorMK2 SEA_SHELL = new SColorMK2(0xFFF5EE);
    public static final SColorMK2 BEIGE = new SColorMK2(0xF5F5DC);
    public static final SColorMK2 OLD_LACE = new SColorMK2(0xFDF5E6);
    public static final SColorMK2 FLORAL_WHITE = new SColorMK2(0xFFFAF0);
    public static final SColorMK2 IVORY = new SColorMK2(0xFFFFF0);
    public static final SColorMK2 ANTIQUE_WHITE = new SColorMK2(0xFAEBD7);
    public static final SColorMK2 LINEN = new SColorMK2(0xFAF0E6);
    public static final SColorMK2 LAVENDER_BLUSH = new SColorMK2(0xFFF0F5);
    public static final SColorMK2 MISTY_ROSE = new SColorMK2(0xFFE4E1);

    public static final SColorMK2 GAINSBORO = new SColorMK2(0xDCDCDC);
    public static final SColorMK2 LIGHT_GRAY = new SColorMK2(0xD3D3D3);
    public static final SColorMK2 SILVER = new SColorMK2(0xC0C0C0);
    public static final SColorMK2 DARK_GRAY = new SColorMK2(0xA9A9A9);
    public static final SColorMK2 GRAY = new SColorMK2(0x808080);
    public static final SColorMK2 DIM_GRAY = new SColorMK2(0x696969);
    public static final SColorMK2 LIGHT_SLATE_GRAY = new SColorMK2(0x778899);
    public static final SColorMK2 SLATE_GRAY = new SColorMK2(0x708090);
    public static final SColorMK2 DARK_SLATE_GRAY = new SColorMK2(0x2F4F4F);
    public static final SColorMK2 BLACK = new SColorMK2(0x000000);

    public static final SColorMK2 TRANSPARENT = new SColorMK2(0xFFFFFF, 0);
}