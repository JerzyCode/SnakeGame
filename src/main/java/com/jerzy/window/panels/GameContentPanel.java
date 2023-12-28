package com.jerzy.window.panels;

import com.jerzy.game.game_objects.Fruit;
import com.jerzy.game.game_objects.Snake;
import com.jerzy.game.images.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static com.jerzy.utils.Constants.UNITS_PER_LINE;
import static com.jerzy.utils.Constants.UNIT_SIZE;

public class GameContentPanel extends JPanel {
  private final transient Snake snake;
  private transient Fruit fruit;

  public GameContentPanel(Snake snake, Fruit fruit) {
    this.snake = snake;
    this.fruit = fruit;
    initialize();
  }

  private void initialize() {
    this.setBackground(Color.BLACK);
    this.setFocusable(true);
  }

  @Override
  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    drawGrass(graphics);
    drawLines(graphics);
    drawSnake(graphics);
    drawFruit(graphics);
  }

  private void drawGrass(Graphics graphics) {
    BufferedImage image = GrassImg.getGrassImg().getImg();
    for (int i = 0; i < UNITS_PER_LINE; i++) {
      for (int j = 0; j < UNITS_PER_LINE; j++) {
        graphics.drawImage(image, i * UNIT_SIZE, j * UNIT_SIZE, null);
      }
    }
  }

  private void drawLines(Graphics graphics) {
    graphics.setColor(Color.GRAY);
    graphics.drawLine(0, 0, UNIT_SIZE * UNITS_PER_LINE, 0);
  }

  private void drawSnake(Graphics graphics) {
    drawSnakeHead(graphics);
    drawSnakeBody(graphics);
    drawSnakeTail(graphics);
  }

  private void drawSnakeHead(Graphics graphics) {
    int xHead = snake.getxHead();
    int yHead = snake.getyHead();
    switch (snake.getDirection()) {
      case UP -> graphics.drawImage(HeadImage.getHeadImage().getHeadUpImg(), xHead, yHead, null);
      case DOWN -> graphics.drawImage(HeadImage.getHeadImage().getHeadDownImg(), xHead, yHead, null);
      case LEFT -> graphics.drawImage(HeadImage.getHeadImage().getHeadLeftImg(), xHead, yHead, null);
      case RIGHT -> graphics.drawImage(HeadImage.getHeadImage().getHeadRightImg(), xHead, yHead, null);
    }
  }

  private void drawSnakeBody(Graphics graphics) {
    drawSnakeHead(graphics);
    int[][] tail = snake.getTail();
    for (int i = snake.getLength() - 3; i >= 0; i--) {

      int x0 = tail[i][0];
      int y0 = tail[i][1];
      int x1 = tail[i + 1][0];
      int y1 = tail[i + 1][1];
      int x2 = tail[i + 2][0];
      int y2 = tail[i + 2][1];

      if (y0 == y1 && y1 == y2) {
        graphics.drawImage(BodyImage.getBodyImage().getBodyHorizontalImg(), x1, y1, null);
      }
      else if (x0 == x1 && x1 == x2) {
        graphics.drawImage(BodyImage.getBodyImage().getBodyVerticalImg(), x1, y1, null);
      }
      else if (isDrawBottomLeft(x0, x1, x2, y0, y1, y2)) {
        graphics.drawImage(BodyImage.getBodyImage().getBodyBottomLeftImg(), x1, y1, null);
      }
      else if (isDrawBottomRight(x0, x1, x2, y0, y1, y2)) {
        graphics.drawImage(BodyImage.getBodyImage().getBodyBottomRightImg(), x1, y1, null);
      }
      else if (isDrawTopRight(x0, x1, x2, y0, y1, y2)) {
        graphics.drawImage(BodyImage.getBodyImage().getBodyTopRightImg(), x1, y1, null);
      }
      else if (isDrawTopLeft(x0, x1, x2, y0, y1, y2)) {
        graphics.drawImage(BodyImage.getBodyImage().getBodyTopLeftImg(), x1, y1, null);
      }

      if (snake.snakeEatItself()) {
        graphics.setColor(Color.GRAY);
        graphics.fillRect(tail[0][0], tail[0][1], UNIT_SIZE, UNIT_SIZE);
      }

    }
  }

  private void drawSnakeTail(Graphics graphics) {
    int tailPreLastX = snake.getTail()[snake.getLength() - 2][0];
    int tailPreLastY = snake.getTail()[snake.getLength() - 2][1];
    int tailLastX = snake.getTail()[snake.getLength() - 1][0];
    int tailLastY = snake.getTail()[snake.getLength() - 1][1];

    if (tailPreLastX > tailLastX) {
      graphics.drawImage(TailImage.getTailImage().getTailLeftImg(), tailLastX, tailLastY, null);
    }
    else if (tailPreLastX < tailLastX) {
      graphics.drawImage(TailImage.getTailImage().getTailRightImg(), tailLastX, tailLastY, null);
    }
    else if (tailPreLastY < tailLastY) {
      graphics.drawImage(TailImage.getTailImage().getTailDownImg(), tailLastX, tailLastY, null);
    }
    else if (tailPreLastY > tailLastY) {
      graphics.drawImage(TailImage.getTailImage().getTailUpImg(), tailLastX, tailLastY, null);
    }
  }

  private void drawFruit(Graphics graphics) {
    BufferedImage image = FruitImg.getFruitImg().getImg();
    graphics.drawImage(image, fruit.getX(), fruit.getY(), null);
  }

  public void setFruit(Fruit fruit) {
    this.fruit = fruit;
  }

  public Fruit getFruit() {
    return fruit;
  }

  private boolean isDrawBottomLeft(int x0, int x1, int x2, int y0, int y1, int y2) {
    return (x0 < x1 && y0 == y1 && x1 == x2 && y1 < y2) || (y0 > y1 && x0 == x1 && y1 == y2 && x1 > x2);
  }

  private boolean isDrawBottomRight(int x0, int x1, int x2, int y0, int y1, int y2) {
    return (x0 > x1 && y0 == y1 && x1 == x2 && y1 < y2) || (y0 > y1 && x0 == x1 && y1 == y2 && x1 < x2);
  }

  private boolean isDrawTopRight(int x0, int x1, int x2, int y0, int y1, int y2) {
    return (y0 < y1 && x0 == x1 && y1 == y2 && x1 < x2) || (x0 > x1 && y1 == y0 && x1 == x2 && y2 < y1);
  }

  private boolean isDrawTopLeft(int x0, int x1, int x2, int y0, int y1, int y2) {
    return (y0 == y1 && x1 == x2 && x0 < x1 && y2 < y1) || (y0 < y1 && x0 == x1 && x1 > x2 && y1 == y2);
  }

}
