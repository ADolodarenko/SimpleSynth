package org.dav.learn.simplesynth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

public class KeyPad extends JPanel
{
    public KeyPad(MouseListener listener)
    {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));

        for (int i = 12; i < 120; i++)
        {
            DescriptPair pair = getNoteDescription(i);

            JPanel key = new Key(i, pair.getCaption());
            key.setToolTipText(pair.getHint());
            key.addMouseListener(listener);

            add(key);
        }
    }

    private static DescriptPair getNoteDescription(int noteNumber)
    {
        switch (noteNumber % 12)
        {
            case 0:
                return new DescriptPair("C", "до");
            case 1:
                return new DescriptPair("C#", "до диез");
            case 2:
                return new DescriptPair("D", "ре");
            case 3:
                return new DescriptPair("D#", "ре диез");
            case 4:
                return new DescriptPair("E", "ми");
            case 5:
                return new DescriptPair("F", "фа");
            case 6:
                return new DescriptPair("F#", "фа диез");
            case 7:
                return new DescriptPair("G", "соль");
            case 8:
                return new DescriptPair("G#", "соль диез");
            case 9:
                return new DescriptPair("A", "ля");
            case 10:
                return new DescriptPair("A#", "ля диез");
            case 11:
                return new DescriptPair("B", "си");
            default:
                return null;
        }
    }

}
