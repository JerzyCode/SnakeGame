package com.jerzy.window.panels;

import javax.swing.*;
import java.awt.*;

import static com.jerzy.utils.Constants.*;

public class CurrentPanel extends JPanel {
  private final CardLayout cardLayout;
  private final SettingsPanel settingsPanel;
  private GamePanel gamePanel;

  public CurrentPanel(SettingsPanel settingsPanel) {
    this.settingsPanel = settingsPanel;
    this.cardLayout = new CardLayout();
    initialize();
  }

  private void initialize() {
    this.setLayout(cardLayout);
    addLayouts();
    setDefaultLayout();
  }

  private void addLayouts() {
    cardLayout.addLayoutComponent(settingsPanel, SETTINGS_PANEL);
    this.add(settingsPanel);
  }

  private void setDefaultLayout() {
    cardLayout.show(this, SETTINGS_PANEL);
  }

  public void showSettingsPanel() {
    cardLayout.show(this, SETTINGS_PANEL);
  }

  public void showGamePanel() {
    cardLayout.show(this, GAME_PANEL);
  }

  public void showStatisticsPanel() {
    cardLayout.show(this, STATISTICS_PANEL);
  }

  public void refreshGameInCurrentPanel(GamePanel gamePanel) {
    if (this.gamePanel != null) {
      this.remove(this.gamePanel);
    }
    this.gamePanel = gamePanel;
    this.add(this.gamePanel);
    this.cardLayout.addLayoutComponent(this.gamePanel, GAME_PANEL);
    this.setLayout(cardLayout);
  }

}
