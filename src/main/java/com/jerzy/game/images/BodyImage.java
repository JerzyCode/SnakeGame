package com.jerzy.game.images;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Objects;

import static com.jerzy.utils.Constants.*;

public class BodyImage {
  private BufferedImage bodyBottomLeftImg;
  private BufferedImage bodyBottomRightImg;
  private BufferedImage bodyTopLeftImg;
  private BufferedImage bodyTopRightImg;
  private BufferedImage bodyHorizontalImg;
  private BufferedImage bodyVerticalImg;

  private static BodyImage bodyImage;

  private BodyImage() {
    importImage();
  }

  public static BodyImage getBodyImage() {
    if (bodyImage == null) {
      bodyImage = new BodyImage();
    }
    return bodyImage;
  }

  private void importImage() {
    try {
      bodyTopLeftImg = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(BODY_TOP_LEFT_IMAGE)));
      bodyTopRightImg = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(BODY_TOP_RIGHT_IMAGE)));
      bodyBottomRightImg = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(BODY_BOTTOM_RIGHT_IMAGE)));
      bodyBottomLeftImg = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(BODY_BOTTOM_LEFT_IMAGE)));
      bodyHorizontalImg = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(BODY_HORIZONTAL_IMAGE)));
      bodyVerticalImg = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(BODY_VERTICAL_IMAGE)));

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public BufferedImage getBodyBottomLeftImg() {
    return bodyBottomLeftImg;
  }

  public BufferedImage getBodyBottomRightImg() {
    return bodyBottomRightImg;
  }

  public BufferedImage getBodyTopLeftImg() {
    return bodyTopLeftImg;
  }

  public BufferedImage getBodyTopRightImg() {
    return bodyTopRightImg;
  }

  public BufferedImage getBodyHorizontalImg() {
    return bodyHorizontalImg;
  }

  public BufferedImage getBodyVerticalImg() {
    return bodyVerticalImg;
  }
}
