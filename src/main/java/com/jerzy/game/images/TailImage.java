package com.jerzy.game.images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Objects;

import static com.jerzy.utils.Constants.*;

public class TailImage {
  private BufferedImage tailDownImg;
  private BufferedImage tailLeftImg;

  private BufferedImage tailRightImg;

  private BufferedImage tailUpImg;

  private static TailImage tailImage;

  private TailImage() {
    importImage();
  }

  public static TailImage getTailImage() {
    if (tailImage == null) {
      tailImage = new TailImage();
    }
    return tailImage;
  }

  private void importImage() {
    try {
      tailRightImg = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(TAIL_RIGHT_IMAGE)));
      tailUpImg = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(TAIL_UP_IMAGE)));
      tailLeftImg = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(TAIL_LEFT_IMAGE)));
      tailDownImg = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(TAIL_DOWN_IMAGE)));
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public BufferedImage getTailDownImg() {
    return tailDownImg;
  }

  public BufferedImage getTailLeftImg() {
    return tailLeftImg;
  }

  public BufferedImage getTailRightImg() {
    return tailRightImg;
  }

  public BufferedImage getTailUpImg() {
    return tailUpImg;
  }
}
