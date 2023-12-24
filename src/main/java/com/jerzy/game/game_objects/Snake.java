package com.jerzy.game.game_objects;

import com.jerzy.game.controls.Direction;

import static com.jerzy.utils.Constants.UNITS_PER_LINE;
import static com.jerzy.utils.Constants.UNIT_SIZE;

public class Snake {
  private int xHead;
  private int yHead;
  private int length;
  private boolean moved;
  private Direction direction;
  private int[][] tail;

  public Snake(int xHead, int yHead) {
    this.xHead = xHead;
    this.yHead = yHead;
    this.tail = new int[UNITS_PER_LINE * UNITS_PER_LINE][2];
    this.length = 0;
    tail[length][0] = xHead;
    tail[length][1] = yHead;
    length += 1;
    direction = Direction.RIGHT;
  }

  public int getxHead() {
    return xHead;
  }

  public int getyHead() {
    return yHead;
  }

  public int getLength() {
    return length;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public Direction getDirection() {
    return direction;
  }

  public int[][] getTail() {
    return tail;
  }

  public boolean isMoved() {
    return moved;
  }

  public void setMoved(boolean moved) {
    this.moved = moved;
  }

  public void move() {

    for (int i = length - 1; i > 0; i--) {
      tail[i][0] = tail[i - 1][0];
      tail[i][1] = tail[i - 1][1];
    }
    if (length > 0) {
      tail[0][0] = xHead;
      tail[0][1] = yHead;
    }

    switch (direction) {
      case UP -> yHead -= UNIT_SIZE;
      case DOWN -> yHead += UNIT_SIZE;
      case LEFT -> xHead -= UNIT_SIZE;
      case RIGHT -> xHead += UNIT_SIZE;
    }
    if (yHead > 650)
      yHead = 0;
    if (yHead < 0)
      yHead = 650;
    if (xHead > 650)
      xHead = 0;
    if (xHead < 0)
      xHead = 650;

    moved = true;
  }

  public void eatFruit() {
    tail[length][0] = xHead;
    tail[length][1] = yHead;
    length += 1;
  }

  public boolean snakeEatItself() {
    for (int i = 1; i < length; i++) {
      if (xHead == tail[i - 1][0] && yHead == tail[i - 1][1]) {
        return true;
      }
    }
    return false;
  }
}
