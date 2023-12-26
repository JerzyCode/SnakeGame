package com.jerzy.window.panels;

import com.jerzy.game.game_objects.Fruit;
import com.jerzy.game.game_objects.Snake;
import com.jerzy.game.images.FruitImg;
import com.jerzy.game.images.GrassImg;
import com.jerzy.game.images.HeadImage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

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
    int xHead = snake.getxHead();
    int yHead = snake.getyHead();
    drawSnakeHead(graphics, xHead, yHead);
    int[][] tail = snake.getTail();
    for (int i = 0; i < snake.getLength(); i++) {
      graphics.setColor(Color.BLUE);
      graphics.fillRect(tail[i][0], tail[i][1], UNIT_SIZE, UNIT_SIZE);
      if (snake.snakeEatItself()) {
        graphics.setColor(Color.GRAY);
        graphics.fillRect(xHead, yHead, UNIT_SIZE, UNIT_SIZE);
      }
    }
  }

  private void drawSnakeHead(Graphics graphics, int xHead, int yHead) {
    switch (snake.getDirection()) {
      case UP -> graphics.drawImage(HeadImage.getHeadImage().getHeadUpImg(), xHead, yHead, null);
      case DOWN -> graphics.drawImage(HeadImage.getHeadImage().getHeadDownImg(), xHead, yHead, null);
      case LEFT -> graphics.drawImage(HeadImage.getHeadImage().getHeadLeftImg(), xHead, yHead, null);
      case RIGHT -> graphics.drawImage(HeadImage.getHeadImage().getHeadRightImg(), xHead, yHead, null);
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

  private static Color getRandomColor() {
    Random random = new Random();
    int red = random.nextInt(256);
    int green = random.nextInt(256);
    int blue = random.nextInt(256);
    return new Color(red, green, blue);
  }
}
