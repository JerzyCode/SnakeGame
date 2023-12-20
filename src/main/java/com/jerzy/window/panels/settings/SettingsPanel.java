package com.jerzy.window.panels.settings;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static com.jerzy.utils.Constants.*;

public class SettingsPanel extends JPanel {
  private final JButton newGameButton;
  private final JButton statisticsButton;
  private final GridBagConstraints gbc;
  private final JPanel buttons;

  public SettingsPanel(JButton newGameButton, JButton statisticsButton) {
    this.newGameButton = newGameButton;
    this.statisticsButton = statisticsButton;
    this.gbc = new GridBagConstraints();
    this.buttons = new JPanel(new GridBagLayout());
    this.setBackground(FRAME_COLOR);
    this.setBorder(new EmptyBorder(10, 10, 10, 10));
    this.setLayout(new BorderLayout());
    createButtonsPanel();
    this.add(buttons, BorderLayout.CENTER);
  }

  private void addButtons() {
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    buttons.add(newGameButton, gbc);
    gbc.insets = new Insets(5, 0, 0, 0);
    buttons.add(statisticsButton, gbc);
    gbc.weighty = 1;
  }

  private void addLabel() {
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.anchor = GridBagConstraints.NORTH;
    JLabel titleLabel = new JLabel("Snake Game");
    titleLabel.setFont(new Font("New Times Roman", Font.BOLD, 36));
    titleLabel.setForeground(TEXT_COLOR);
    gbc.insets = new Insets(20, 0, 0, 0);
    buttons.add(titleLabel, gbc);
  }

  private void createButtonsPanel() {
    buttons.setBackground(BACKGROUND_COLOR);
    addLabel();
    addButtons();
  }

}
