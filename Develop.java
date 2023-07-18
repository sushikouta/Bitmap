public class Develop {
    public static void main(String[] args) {
        new Develop();
    }

    public Develop() {
        BitMap bitmap = new BitMap(600, 600);

        System.out.println(SColor.toHtml(SColor.mix(SColor.setAlpha(SColor.BLUE, 0x80) , SColor.RED)));

        bitmap.drawLine(0.5, 0.5, 100.5, 100.5, 1, SColor.MAGENTA);

        bitmap.show();
    }
}