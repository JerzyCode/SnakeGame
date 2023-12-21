package com.jerzy.window.buttons;

import com.jerzy.window.panels.CurrentPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import static com.jerzy.utils.Constants.*;

public class StatisticsButton extends JButton {

  public StatisticsButton() {
    this.setPreferredSize(BUTTON_SIZE);
    this.setText("Statistics");
    this.setBackground(BUTTON_COLOR);
    this.setBorder(new LineBorder(TEXT_COLOR, 2));
    this.setFont(new Font("New Times Roman", Font.BOLD, 15));
    this.setForeground(TEXT_COLOR);
    this.setFocusPainted(false);
  }

  public void addKeyActionListener(CurrentPanel currentPanel) {
    this.addActionListener(e -> {
      System.out.println("Statistics Pressed");
      currentPanel.showStatisticsPanel();
    });

  }
}
