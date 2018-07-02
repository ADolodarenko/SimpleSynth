package org.dav.learn.simplesynth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SynthFrame extends JFrame implements ActionListener, MouseListener
{
    private CommandPad commandPad;
    private KeyPad keyPad;

    private Player player;

    public SynthFrame()
    {
        commandPad = new CommandPad(this);
        add(commandPad, BorderLayout.NORTH);

        keyPad = new KeyPad(this);
        add(keyPad, BorderLayout.CENTER);

        player = new Player();
        player.changeInstrument(0, 0);

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if (source instanceof JComboBox)
        {
            JComboBox comboBox = (JComboBox)source;

            player.changeInstrument(0, comboBox.getSelectedIndex());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        Object source = e.getSource();

        if (source instanceof Key)
        {
            Key currentKey = (Key) source;

            currentKey.setBorder(BorderFactory.createLineBorder(Color.PINK));
            currentKey.repaint();

            if (player != null)
                player.play(0, 500, 100, currentKey.getNumber());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}
