package com.jerzy.window.panels;

import com.jerzy.game.controls.KeyboardInputs;
import com.jerzy.game.game_objects.Fruit;
import com.jerzy.game.game_objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static com.jerzy.utils.Constants.UNITS_PER_LINE;
import static com.jerzy.utils.Constants.UNIT_SIZE;

public class GameContentPanel extends JPanel {
  private final transient Snake snake;
  private transient Fruit fruit;
  private int frames = 0;
  private long lastCheck = 0;

  public GameContentPanel(Snake snake, Fruit fruit) {
    this.snake = snake;
    this.fruit = fruit;
    initialize();
  }

  private void initialize() {
    this.addKeyListener(new KeyboardInputs(snake));
    this.setBackground(Color.BLACK);
    this.setFocusable(true);
  }

  @Override
  public void paintComponent(Graphics graphics) {

    super.paintComponent(graphics);
    drawLines(graphics);
    drawSnake(graphics);
    drawFruit(graphics);

    frames++;
    if (System.currentTimeMillis() - lastCheck >= 1000) {
      lastCheck = System.currentTimeMillis();
      System.out.println("FPS: " + frames);
      frames = 0;
    }
  }

  private void drawLines(Graphics graphics) {
    graphics.setColor(Color.GRAY);
    graphics.drawLine(0, 0, UNIT_SIZE * UNITS_PER_LINE, 0);
  }

  private void drawSnake(Graphics graphics) {
    graphics.setColor(Color.RED);
    int xHead = snake.getxHead();
    int yHead = snake.getyHead();
    graphics.fillRect(xHead, yHead, UNIT_SIZE, UNIT_SIZE);
    int[][] tail = snake.getTail();
    for (int i = 0; i < snake.getLength(); i++) {
      graphics.setColor(Color.GREEN);
      graphics.fillRect(tail[i][0], tail[i][1], UNIT_SIZE, UNIT_SIZE);
    }

  }

  private void drawFruit(Graphics graphics) {
    graphics.setColor(Color.ORANGE);
    graphics.fillOval(fruit.getX(), fruit.getY(), UNIT_SIZE, UNIT_SIZE);
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
