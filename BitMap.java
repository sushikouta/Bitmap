import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BitMap {
    int width = 0;
    int height = 0;
    SColorMK2[][] map = null;

    public BitMap(int width, int height) {
        this.width = width;
        this.height = height;
        map = new SColorMK2[width][height];

        for (SColorMK2[] column : map) {
            Arrays.fill(column, SColorMK2.WHITE);
        }
    }

    public void drawLine(double startX, double startY, double deltaX, double deltaY, int stroke, SColorMK2 color) {
        int minX = (int) Math.floor(Math.min(startX, deltaX));
        int minY = (int) Math.floor(Math.min(startY, deltaY));
        int maxX = (int) Math.ceil(Math.max(startX, deltaX)) + stroke;
        int maxY = (int) Math.ceil(Math.max(startY, deltaY)) + stroke;

        for (int x = minX;x != maxX;x++) {
            for (int y = minY;y != maxY;y++) {
                if (minD2(x, y, startX, startY, deltaX, deltaY) < 1) {
                    drawPoint(x, y, new SColorMK2(color, 1 - minD2(x, y, startX, startY, deltaX, deltaY)));
                }
            }
        }
    }

    public void background(SColorMK2 color) {
        for (int x = 0 ;x != width;x++) {
            for (int y = 0;y != height;y++) {
                drawPoint(x, y, color);
            }
        }
    }

    public void drawPoint(int x, int y, SColorMK2 color) {
        if (x > -1 && y > -1 && x < width && y < height) {
            map[x][y] = map[x][y].mix(color);
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
                                g2.setColor(new Color(map[x][y].toNoAlpha()));
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
    public static void debug(int width, int height, TriConsumer<BitMap, Integer, Integer> action) {
        new JFrame() {
            {
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setTitle("BitMap [" + width + "x" + height + "]");
                add(new JPanel() {
                    BitMap show = new BitMap(width, height);
                    {
                        setPreferredSize(new Dimension(Math.max(400, width), Math.max(400, height)));
                        addMouseMotionListener(new MouseMotionListener() {
                            @Override public void mouseDragged(MouseEvent e) {
                                show = new BitMap(width, height);
                                action.accept(show, e.getX(), e.getY());
                                repaint();
                            }
                            @Override public void mouseMoved(MouseEvent e) {
                                show = new BitMap(width, height);
                                action.accept(show, e.getX(), e.getY());
                                repaint();
                            }
                            
                        });
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
                                g2.setColor(new Color(show.map[x][y].toNoAlpha()));
                                g2.drawLine(x, y, x, y);
                            }
                        }

                        g.drawImage(b, 0, 0, null);
                    }
                });
                pack();
                setResizable(false);
                setVisible(true);
            }
        };
    }
}