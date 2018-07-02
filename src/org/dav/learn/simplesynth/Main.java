package org.dav.learn.simplesynth;

import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                JFrame frame = new SynthFrame();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });

    }
}
