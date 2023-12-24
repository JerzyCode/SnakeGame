package com.jerzy.game.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

import static com.jerzy.utils.Constants.*;

public class Sound {

  private Clip clip;
  private final URL[] soundUrl = new URL[2];

  public Sound() {
    soundUrl[DEAD_SOUND] = getClass().getResource(DEAD_SOUND_URL);
    soundUrl[EAT_SOUND] = getClass().getResource(EAT_SOUND_URL);
  }

  public void setFile(int soundType) {
    try {
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundUrl[soundType]);
      clip = AudioSystem.getClip();
      clip.open(audioStream);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void play() {
    clip.start();
  }

  public void loop() {
    clip.loop(Clip.LOOP_CONTINUOUSLY);
  }

  public void stop() {
    clip.stop();
  }
}
