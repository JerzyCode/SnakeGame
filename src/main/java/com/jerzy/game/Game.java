package com.jerzy.game;

import com.jerzy.game.controls.KeyboardInputs;
import com.jerzy.game.game_objects.Fruit;
import com.jerzy.game.game_objects.Snake;
import com.jerzy.game.sound.Sound;
import com.jerzy.window.panels.CurrentPanel;
import com.jerzy.window.panels.GamePanel;
import com.jerzy.window.panels.ScorePanel;

import javax.swing.*;

import static com.jerzy.utils.Constants.*;

public class Game implements Runnable {
  private final Snake snake;
  private final GamePanel gamePanel;
  private final ScorePanel scorePanel;
  private final CurrentPanel currentPanel;
  private final Sound sound = new Sound();
  private Thread gameThread;

  public Game(CurrentPanel currentPanel, ScorePanel scorePanel, KeyboardInputs keyboardInputs) {
    this.currentPanel = currentPanel;
    this.snake = new Snake(UNIT_SIZE, 0);
    keyboardInputs.setSnake(this.snake);
    this.scorePanel = scorePanel;
    this.gamePanel = new GamePanel(snake, new Fruit(snake.getTail()), scorePanel, keyboardInputs);
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
    double timePerUpdate = 1000000000.0 / UPS;
    long previousTime = System.nanoTime();
    int frames = 0;
    int updates = 0;
    long lastCheck = System.currentTimeMillis();
    double deltaUpdates = 0;
    double deltaFrames = 0;

    while (!isGameOver()) {
      long currentTime = System.nanoTime();

      deltaUpdates += (currentTime - previousTime) / timePerUpdate;
      deltaFrames += (currentTime - previousTime) / timePerFrame;
      previousTime = currentTime;

      if (deltaUpdates >= 1) {
        snake.move();
        snakeEatingFruit();
        updates += 1;
        deltaUpdates -= 1;
      }

      if (deltaFrames >= 1) {
        gamePanel.repaint();
        frames += 1;
        deltaFrames -= 1;
      }

      if (System.currentTimeMillis() - lastCheck >= 1000) {
        lastCheck = System.currentTimeMillis();
        //        System.out.println("FPS: " + frames + " | UPS: " + updates);
        frames = 0;
        updates = 0;
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
      makeEatingSound();
      gamePanel.setFruit(new Fruit(snake.getTail()));
      snake.eatFruit();
      scorePanel.setScore(scorePanel.getScore() + 10);
      scorePanel.refreshScore();
    }
  }

  private boolean isGameOver() {
    if (snake.snakeEatItself()) {
      makeSnakeEatItselfSound();
      gamePanel.repaint();
      return true;
    }
    return false;
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

  private void makeEatingSound() {
    sound.setFile(EAT_SOUND);
    sound.play();
  }

  private void makeSnakeEatItselfSound() {
    sound.setFile(DEAD_SOUND);
    sound.play();
  }
}
