package com.jerzy.window.panels;

import com.jerzy.game.controls.KeyboardInputs;
import com.jerzy.game.game_objects.Fruit;
import com.jerzy.game.game_objects.Snake;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

  private final transient Snake snake;
  private final GameContentPanel gameContentPanel;
  private final ScorePanel scorePanel;

  public GamePanel(Snake snake, Fruit fruit, ScorePanel scorePanel) {
    this.scorePanel = scorePanel;
    this.gameContentPanel = new GameContentPanel(snake, fruit);
    this.snake = snake;
    initialize();
  }

  private void initialize() {
    this.setLayout(new BorderLayout());
    this.add(scorePanel, BorderLayout.NORTH);
    this.add(gameContentPanel, BorderLayout.CENTER);
    this.addKeyListener(new KeyboardInputs(snake));
    this.setBackground(Color.BLACK);
    this.setFocusable(true);
  }

  public void setFruit(Fruit fruit) {
    this.gameContentPanel.setFruit(fruit);
  }

  public Fruit getFruit() {
    return this.gameContentPanel.getFruit();
  }
}
