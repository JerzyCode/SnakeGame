package com.jerzy.window.panels;

import javax.swing.*;
import java.awt.*;

import static com.jerzy.utils.Constants.UNIT_SIZE;

public class ScorePanel extends JPanel {

  private int score = 0;
  private final JLabel label;

  public ScorePanel() {
    label = new JLabel();
    initialize();
  }

  private void initialize() {
    this.setSize(WIDTH, UNIT_SIZE);
    label.setText("Score: " + score);
    this.setBackground(Color.BLACK);
    label.setForeground(Color.WHITE);
    label.setFont(new Font(Font.SERIF, Font.BOLD, 40));
    this.add(label);
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void refreshScore() {
    label.setText("Score: " + score);
  }
}
