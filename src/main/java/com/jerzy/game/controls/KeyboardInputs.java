package com.jerzy.game.controls;

import com.jerzy.game.game_objects.Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
  private Snake snake;

  public KeyboardInputs() {
  }

  public void setSnake(Snake snake) {
    this.snake = snake;
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {

    if (!snake.isMoved())
      return;

    switch (e.getKeyCode()) {
      case KeyEvent.VK_UP:
        if (snake.getDirection() != Direction.DOWN) {
          snake.setDirection(Direction.UP);
        }
        break;
      case KeyEvent.VK_DOWN:
        if (snake.getDirection() != Direction.UP) {
          snake.setDirection(Direction.DOWN);
        }
        break;
      case KeyEvent.VK_LEFT:
        if (snake.getDirection() != Direction.RIGHT) {
          snake.setDirection(Direction.LEFT);
        }
        break;
      case KeyEvent.VK_RIGHT:
        if (snake.getDirection() != Direction.LEFT) {
          snake.setDirection(Direction.RIGHT);
        }
        break;
      default:
        break;
    }
    snake.setMoved(false);
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

}
