package Objects;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Audio {

    public static Clip clip;
    
    public static void playSound(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        File spath = new File(path);

        if(spath.exists()){
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(spath);
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        }
        else{
            System.out.println("Can't find audio file");
        }
    }

    public static void stopSound(){
        clip.stop();
        clip.close();
    }

}