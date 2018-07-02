package org.dav.learn.simplesynth;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CommandPad extends JPanel
{
    private JComboBox<String> instrumentsCombo;

    public CommandPad(ActionListener listener)
    {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

        for (int i = 0; i < 128; i++)
            model.addElement("Instrument #" + (i + 1));

        instrumentsCombo = new JComboBox<>(model);
        instrumentsCombo.addActionListener(listener);

        add(instrumentsCombo);
    }
}
