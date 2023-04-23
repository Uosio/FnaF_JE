import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import javax.swing.*;

import java.io.IOException;

import Objects.Audio;
import Objects.Objects;

public class Settings extends Frame implements ActionListener {

    // Screen resolution
    JComboBox srselector = new JComboBox<>(sresolution);
    public static String[] sresolution = { "2560x1440", "1920x1080", "1024x720", "640x480" };

    // Buttons
    Objects.Button abutton;
    Objects.Button bbutton;

    Settings() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        // Panel
        Objects.Panel panel = new Objects.Panel(new FlowLayout(), Color.BLACK);
        Objects.Panel spanel = new Objects.Panel(new BorderLayout(), Color.BLACK);

        // Text
        Objects.Text srlabel = new Objects.Text("Screen resolution: ", 27, Color.WHITE);

        // Screen resolution selector
        srselector.setFont(new Font("FreeMono", Font.BOLD, 27));
        srselector.setFocusable(false);
        srselector.setOpaque(false);

        // Buttons
        abutton = new Objects.Button("Apply", 27, this);
        bbutton = new Objects.Button("Back", 27, this);

        // Includes
        this.add(panel, BorderLayout.CENTER);
        this.add(spanel, BorderLayout.SOUTH);

        panel.add(srlabel);
        panel.add(srselector);

        spanel.add(abutton);
        spanel.add(bbutton, FlowLayout.LEFT);

        this.setVisible(true);

    }

    // Action listener
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == abutton) {

            // Sound
            try {
                Audio.stopSound();
                Audio.playSound("res/audio/Blip3.wav");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }

            // Screen resolution
            int output = srselector.getSelectedIndex();
            if (output == 0) {
                width = 2560;
                height = 1440;
                this.setSize(width, height);
            }
            
            if (output == 1) {
                width = 1920;
                height = 1080;
                this.setSize(width, height);
            }

            if (output == 2) {
                width = 1024;
                height = 720;
                this.setSize(width, height);
            }

            if (output == 3) {
                width = 640;
                height = 480;
                this.setSize(width, height);
            }
        }

        // Back
        if (arg0.getSource() == bbutton) {
            Audio.stopSound();
            this.setEnabled(false);
            this.setVisible(false);
            try {
                new Menu();
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}