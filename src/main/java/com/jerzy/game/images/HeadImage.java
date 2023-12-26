package com.jerzy.game.images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Objects;

import static com.jerzy.utils.Constants.*;

public class HeadImage {
  private BufferedImage headLeftImg;
  private BufferedImage headRightImg;

  private BufferedImage headUpImg;

  private BufferedImage headDownImg;

  private static HeadImage headImage;

  private HeadImage() {
    importImage();
  }

  public static HeadImage getHeadImage() {
    if (headImage == null) {
      headImage = new HeadImage();
    }
    return headImage;
  }

  private void importImage() {
    try {
      headUpImg = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(HEAD_UP_IMAGE)));
      headDownImg = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(HEAD_DOWN_IMAGE)));
      headRightImg = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(HEAD_RIGHT_IMAGE)));
      headLeftImg = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(HEAD_LEFT_IMAGE)));
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public BufferedImage getHeadLeftImg() {
    return headLeftImg;
  }

  public BufferedImage getHeadRightImg() {
    return headRightImg;
  }

  public BufferedImage getHeadUpImg() {
    return headUpImg;
  }

  public BufferedImage getHeadDownImg() {
    return headDownImg;
  }
}
