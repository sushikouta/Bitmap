public class Develop {
    public static void main(String[] args) {
        new Develop();
    }

    public Develop() {
        BitMap.debug(400, 400, (window, mouseX, mouseY) -> {
            window.drawLine(200, 200, mouseX, mouseY, 1, SColorMK2.MAGENTA);
        });
    }
}