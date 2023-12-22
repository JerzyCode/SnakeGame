package com.jerzy.window.buttons;

import com.jerzy.game.Game;
import com.jerzy.game.controls.KeyboardInputs;
import com.jerzy.window.panels.CurrentPanel;
import com.jerzy.window.panels.ScorePanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import static com.jerzy.utils.Constants.*;

public class NewGameButton extends JButton {

  public NewGameButton() {
    initialize();
  }

  private void initialize() {
    this.setPreferredSize(BUTTON_SIZE);
    this.setText("New Game");
    this.setBackground(BUTTON_COLOR);
    this.setBorder(new LineBorder(TEXT_COLOR, 2));
    this.setFont(new Font("New Times Roman", Font.BOLD, 15));
    this.setForeground(TEXT_COLOR);
    this.setFocusPainted(false);
  }

  public void addKeyActionListener(CurrentPanel currentPanel, KeyboardInputs keyboardInputs) {
    this.addActionListener(e -> {
      System.out.println("New Game Pressed");
      ScorePanel scorePanel = new ScorePanel();
      new Game(currentPanel, scorePanel, keyboardInputs);
    });
  }

}
