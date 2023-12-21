package com.jerzy.window;

import com.jerzy.window.panels.CurrentPanel;
import com.jerzy.window.panels.SettingsPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import static com.jerzy.utils.Constants.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Window {

  private final JFrame mainFrame;
  private final SettingsPanel settingsPanel;
  private final CurrentPanel currentPanel;
  private final JButton newGameButton;
  private final JButton statisticsButton;

  public Window() {
    this.newGameButton = new JButton();
    this.statisticsButton = new JButton();
    this.mainFrame = new JFrame();
    createButtons();
    this.settingsPanel = new SettingsPanel(newGameButton, statisticsButton);
    this.currentPanel = new CurrentPanel(settingsPanel);
    initialize();
  }

  private void initialize() {
    this.mainFrame.setTitle("Snake!!");
    this.mainFrame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    this.mainFrame.setResizable(false);
    this.mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.mainFrame.add(currentPanel);
    this.mainFrame.setLocation(0, 0);
    this.mainFrame.setVisible(true);
    this.mainFrame.pack();
  }

  private void createButtons() {
    createNewGameButton();
    createStatisticsButton();
  }

  private void createButton(JButton button, String text) {
    button.setPreferredSize(BUTTON_SIZE);
    button.setText(text);
    button.setBackground(BUTTON_COLOR);
    button.setBorder(new LineBorder(TEXT_COLOR, 2));
    button.setFont(new Font("New Times Roman", Font.BOLD, 15));
    button.setForeground(TEXT_COLOR);
    button.setFocusPainted(false);
  }

  private void createStatisticsButton() {
    createButton(statisticsButton, "Statistics Button");
    statisticsButton.addActionListener(e -> {
      System.out.println("Statistics Pressed");
      currentPanel.showStatisticsPanel();
    });
  }

  private void createNewGameButton() {
    createButton(newGameButton, "New Game");
    newGameButton.addActionListener(e -> {
      System.out.println("New Game Pressed");
      currentPanel.showGamePanel();
    });
  }

}
