package com.jerzy.game.game_objects;

import java.util.Random;

import static com.jerzy.utils.Constants.UNITS_PER_LINE;
import static com.jerzy.utils.Constants.UNIT_SIZE;

public class Fruit {
  private int x;
  private int y;
  private static final Random random = new Random();
  private final int[][] snakeTail;

  public Fruit(int[][] snakeTail) {
    this.snakeTail = snakeTail;
    int x = UNIT_SIZE * random.nextInt(UNITS_PER_LINE);
    int y = UNIT_SIZE * random.nextInt(UNITS_PER_LINE);

    while (!areProperCoordinates(x, y)) {
      x = UNIT_SIZE * random.nextInt(UNITS_PER_LINE);
      y = UNIT_SIZE * random.nextInt(UNITS_PER_LINE);
    }
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean areProperCoordinates(int x, int y) {
    for (int[] tab : snakeTail) {
      if (tab[0] == x && tab[1] == y) {
        return false;
      }
    }
    return true;
  }

}
