package JavaStudy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class InnerClassTest {
    public static void main(String[] args) {
        var clock = new TalkingClock();
        clock.start(1000, true);
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
class TalkingClock{
//    private int interval;
//    private boolean beep;
//
//    public TalkingClock(int interval, boolean beep){
//        this.interval = interval;
//        this.beep = beep;
//    }
    public void start(int interval, boolean beep){
        var listenter = new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.out.println("At the tone, the time is "
                    + Instant.ofEpochMilli(event.getWhen()));
                if(beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        var timer = new Timer(interval, listenter);
        timer.start();
    }
}

