import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BitMap {
    int width = 0;
    int height = 0;
    int[][] map = null;

    public BitMap(int width, int height) {
        this.width = width;
        this.height = height;
        map = new int[width][height];

        for (int[] column : map) {
            Arrays.fill(column, SColor.TRANSPARENT);
        }
    }

    public void drawLine(double startX, double startY, double deltaX, double deltaY, int stroke, int color) {
        int minX = (int) Math.floor(Math.min(startX, deltaX));
        int minY = (int) Math.floor(Math.min(startY, deltaY));
        int maxX = (int) Math.ceil(Math.max(startX, deltaX)) + stroke;
        int maxY = (int) Math.ceil(Math.max(startY, deltaY)) + stroke;

        for (int x = minX;x != maxX;x++) {
            for (int y = minY;y != maxY;y++) {
                if (minD2(x, y, startX, startY, deltaX, deltaY) < 1) {
                    drawPoint(x, y, SColor.setAlpha(color, SColor.toHex(1 - minD2(x, y, startX, startY, deltaX, deltaY))));
                }
            }
        }
    }

    public void drawPoint(int x, int y, int color) {
        if (x > -1 && y > -1 && x < width && y < height) {
            map[x][y] = color;
        }
    }

    public double minD2(double x0, double y0, double x1, double y1, double x2, double y2) {
        double a = x2 - x1;
        double b = y2 - y1;
        double a2 = a * a;
        double b2 = b * b;
        double r2 = a2 + b2;
        double tt = -(a * (x1 - x0) + b * (y1 - y0));
        if( tt < 0 ) {
            return Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
        }
        if( tt > r2 ) {
            return Math.sqrt((x2 - x0) * (x2 - x0) + (y2 - y0) * (y2 - y0));
        }
        double f1 = a * (y1 - y0) - b * (x1 - x0);
        return (f1 * f1) / r2;
    }

    public void show() {
        new JFrame() {
            {
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setTitle("BitMap [" + width + "x" + height + "]");
                add(new JPanel() {
                    {
                        setPreferredSize(new Dimension(Math.max(400, width), Math.max(400, height)));
                    }

                    @Override public void paintComponent(Graphics g) {
                        g.setColor(new Color(SColor.BLACK));
                        g.fillRect(0, 0, getWidth(), getHeight());

                        BufferedImage b = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
                        Graphics2D g2 = b.createGraphics();

                        g2.setColor(new Color(SColor.WHITE));
                        g2.fillRect(0, 0, width, height);

                        for (int x = 0;x != width;x++) {
                            for (int y = 0;y != height;y++) {
                                g2.setColor(new Color(SColor.getRed(map[x][y]), SColor.getGreen(map[x][y]), SColor.getBlue(map[x][y]), SColor.getAlpha(map[x][y])));
                                g2.drawLine(x, y, x, y);
                            }
                        }

                        g.drawImage(b, Math.max(0, (400 - width) / 2), Math.max(0, (400 - height) / 2), null);
                    }
                });
                pack();
                setResizable(false);
                setVisible(true);
            }
        };
    }
}
