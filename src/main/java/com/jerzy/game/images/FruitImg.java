package com.jerzy.game.images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import static com.jerzy.utils.Constants.FRUIT_IMAGE_URL;

public class FruitImg {
  private BufferedImage img;
  private static FruitImg fruitImg;

  private FruitImg() {
    importImage();
  }

  public static FruitImg getFruitImg() {
    if (fruitImg == null) {
      fruitImg = new FruitImg();
    }
    return fruitImg;
  }

  private void importImage() {
    InputStream is = getClass().getResourceAsStream(FRUIT_IMAGE_URL);
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
