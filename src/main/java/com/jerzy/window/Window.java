package com.jerzy.window;

import com.jerzy.game.controls.KeyboardInputs;
import com.jerzy.window.buttons.NewGameButton;
import com.jerzy.window.buttons.StatisticsButton;
import com.jerzy.window.panels.CurrentPanel;
import com.jerzy.window.panels.SettingsPanel;

import javax.swing.*;
import java.awt.*;

import static com.jerzy.utils.Constants.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Window {

  private final JFrame mainFrame;
  private final SettingsPanel settingsPanel;
  private final NewGameButton gameButton;
  private final CurrentPanel currentPanel;
  private final StatisticsButton statisticsButton;

  //TODO ma być jeden obiekt typu KeyBoardsInput, i przekazać go w konstruktorach aż do GamePanel


  public Window() {
    this.mainFrame = new JFrame();
    this.gameButton = new NewGameButton();
    this.statisticsButton = new StatisticsButton();
    this.settingsPanel = new SettingsPanel(gameButton, statisticsButton);
    this.currentPanel = new CurrentPanel(settingsPanel);
    addKeyListeners();
    initialize();
  }

  private void initialize() {
    this.mainFrame.setTitle("Snake!!");
    this.mainFrame.setLayout(new BorderLayout());
    this.mainFrame.setPreferredSize(new Dimension(WIDTH + UNITS_PER_LINE, HEIGHT + UNITS_PER_LINE + UNIT_SIZE + 35));
    this.mainFrame.setResizable(false);
    this.mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.mainFrame.add(currentPanel, BorderLayout.CENTER);
    this.mainFrame.setLocation(0, 0);
    this.mainFrame.setVisible(true);
    this.mainFrame.pack();
  }

  private void addKeyListeners() {
    gameButton.addKeyActionListener(this.currentPanel);
    statisticsButton.addKeyActionListener(this.currentPanel);
  }

}
