import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.sound.sampled.*;

import java.io.IOException;

import Objects.Audio;
import Objects.Objects;

public class Menu extends Frame implements ActionListener {

    Image image;
    Objects.Panel bgpanel;

    // Buttons
    Objects.Button cbutton;
    Objects.Button nbutton;
    Objects.Button sbutton;

    Menu() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        this.setSize(width, height);

        image = new ImageIcon("res/images/menu.png").getImage();

        // Panels
        Objects.Panel tpanel = new Objects.Panel(new FlowLayout(), Color.BLACK);
        
        bgpanel = new Objects.Panel(new BorderLayout(), Color.BLACK) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), bgpanel);
            }
        };

        Objects.Panel bpanel = new Objects.Panel(new FlowLayout(), Color.BLACK);

        // Text
        Objects.Text title = new Objects.Text("Five nights at Freddy", 27, Color.WHITE);
        Objects.Text title1 = new Objects.Text("REBUILD", 37, Color.RED);

        // Buttons
        cbutton = new Objects.Button("Continue", 27, this);
        nbutton = new Objects.Button("New game", 27, this);
        sbutton = new Objects.Button("Settings", 27, this);

        // Includes
        this.add(tpanel, BorderLayout.NORTH);
        this.add(bgpanel, BorderLayout.CENTER);
        this.add(bpanel, BorderLayout.SOUTH);

        tpanel.add(title, FlowLayout.LEFT);
        tpanel.add(title1);

        bpanel.add(cbutton, FlowLayout.LEFT);
        bpanel.add(nbutton, FlowLayout.CENTER);
        bpanel.add(sbutton, FlowLayout.RIGHT);

        this.setVisible(true);
        Audio.playSound("res/audio/Main Menu.wav");
    }

    // Action listener
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // Continue button
        if (arg0.getSource() == cbutton) {
            try {
                Audio.stopSound();
                Audio.playSound("res/audio/Blip3.wav");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }

        // New game button
        if (arg0.getSource() == nbutton) {
            try {
                Audio.stopSound();
                Audio.playSound("res/audio/Blip3.wav");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }

        // Settings button
        if (arg0.getSource() == sbutton) {

            try {
                Audio.stopSound();
                Audio.playSound("res/audio/Blip3.wav");
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }

            this.setEnabled(false);
            this.setVisible(false);

            try {
                new Settings();
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}