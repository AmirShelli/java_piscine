package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Logic {
    protected int x;
    public static int index = 1;
    public static int[][] seeBMPImage(String BMPFileName, int b, int w) throws IOException {
        BufferedImage image = ImageIO.read(Files.newInputStream(Paths.get(BMPFileName)));
        int[][] array2D = new int[image.getWidth()][image.getHeight()];

        for(int xPixel = 0; xPixel < image.getWidth(); xPixel++)
            for(int yPixel = 0; yPixel < image.getHeight(); yPixel++) {
                int color = image.getRGB(xPixel,yPixel);
                if(color == Color.BLACK.getRGB())
                    array2D[xPixel][yPixel] = b;
                else
                    array2D[xPixel][yPixel] = w;
            }
        return array2D;
    }
}
