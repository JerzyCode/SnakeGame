package com.jerzy.game.images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import static com.jerzy.utils.Constants.FRUIT_IMAGE_URL;
import static com.jerzy.utils.Constants.GRASS_IMAGE_URL;

public class GrassImg {
  private BufferedImage img;
  private static GrassImg grassImg;

  private GrassImg() {
    importImage();
  }

  public static GrassImg getGrassImg() {
    if (grassImg == null) {
      grassImg = new GrassImg();
    }
    return grassImg;
  }

  private void importImage() {
    InputStream is = getClass().getResourceAsStream(GRASS_IMAGE_URL);
    try {
      img = ImageIO.read(is);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public BufferedImage getImg() {
    return img;
  }
}
