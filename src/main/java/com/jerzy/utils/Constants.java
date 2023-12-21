package com.jerzy.utils;

import java.awt.*;

public class Constants {

  private Constants() {
  }

  public static final int WIDTH = 700;
  public static final int HEIGHT = 700;
  public static final Color BACKGROUND_COLOR = new Color(100, 150, 200);
  public static final Color FRAME_COLOR = Color.BLACK;
  public static final Color BUTTON_COLOR = new Color(60, 150, 60);
  public static final Color TEXT_COLOR = Color.BLACK;

  public static final String SETTINGS_PANEL = "settings-panel";
  public static final String GAME_PANEL = "game-panel";
  public static final String STATISTICS_PANEL = "statistics-panel";
  public static final int BUTTON_WIDTH = 250;
  public static final Dimension BUTTON_SIZE = new Dimension(250, 50);
  public static final int UNIT_SIZE = 50;
  public static final int UNITS_PER_LINE = WIDTH/UNIT_SIZE;
  public static final int FPS = 10;

}
