package com.jerzy.game;

import com.jerzy.game.game_objects.Fruit;
import com.jerzy.game.game_objects.Snake;
import com.jerzy.window.panels.CurrentPanel;
import com.jerzy.window.panels.GamePanel;
import com.jerzy.window.panels.ScorePanel;

import javax.swing.*;

import static com.jerzy.utils.Constants.FPS;

public class Game implements Runnable {
  private final Snake snake;
  private final GamePanel gamePanel;
  private final ScorePanel scorePanel;
  private final CurrentPanel currentPanel;
  private Thread gameThread;

  public Game(CurrentPanel currentPanel, ScorePanel scorePanel) {
    this.currentPanel = currentPanel;
    this.snake = new Snake(0, 0);
    this.scorePanel = scorePanel;
    this.gamePanel = new GamePanel(snake, new Fruit(snake.getTail()), scorePanel);
    refreshGamePanel();
    startGameLoop();
  }

  private void startGameLoop() {
    gameThread = new Thread(this);
    gameThread.start();
  }

  @Override
  public void run() {

    //DURATION SHOULD EACH FRAME LAST
    double timePerFrame = 1000000000.0 / FPS;

    long lastFrame = System.nanoTime();
    while (!isGameOver()) {
      long now = System.nanoTime();
      if (now - lastFrame >= timePerFrame) {
        gamePanel.repaint();
        snake.move();
        snakeEatingFruit();
        lastFrame = now;
      }
    }
    try {
      Thread.sleep(100);
      System.out.println("GAME OVER");
      closeGame();
    }
    catch (Exception e) {
      closeGame();
    }
  }

  private void snakeEatingFruit() {
    if (gamePanel.getFruit().getX() == snake.getxHead()
        && gamePanel.getFruit().getY() == snake.getyHead()) {
      gamePanel.setFruit(new Fruit(snake.getTail()));
      snake.eatFruit();
      scorePanel.setScore(scorePanel.getScore() + 10);
      scorePanel.refreshScore();
    }
  }

  private boolean isGameOver() {
    return snake.snakeEatItself();
  }

  public void closeGame() {
    JOptionPane.showMessageDialog(currentPanel, "Game Over, Score:" + scorePanel.getScore());
    currentPanel.showSettingsPanel();
    gameThread.interrupt();
  }

  private void refreshGamePanel() {
    SwingUtilities.invokeLater(this.gamePanel::requestFocus);
    this.currentPanel.refreshGameInCurrentPanel(gamePanel);
    this.currentPanel.showGamePanel();
  }
}
