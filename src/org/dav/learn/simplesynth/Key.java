package org.dav.learn.simplesynth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Key extends JPanel
{
    private static final int WIDTH = 20;
    private static final int HEIGHT = 80;

    private int number;
    private String caption;
    private JLabel label;

    public Key(int number, String caption)
    {
        this.number = number;
        this.caption = caption;
        this.label = new JLabel(caption);

        setColors();

        add(label);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e)
            {
                setBorder(BorderFactory.createLineBorder(Color.CYAN));
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                setBorder(BorderFactory.createLineBorder(Color.CYAN));
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }
        });
    }

    private void setColors()
    {
        if (caption != null && caption.substring(1).equalsIgnoreCase("#"))
        {
            setForeground(Color.WHITE);
            setBackground(Color.BLACK);
            label.setForeground(Color.WHITE);
        }
        else
        {
            setForeground(Color.BLACK);
            setBackground(Color.WHITE);
            label.setForeground(Color.BLACK);
        }
    }

    public int getNumber()
    {
        return number;
    }

    public String getCaption()
    {
        return caption;
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(WIDTH, HEIGHT);
    }
}
