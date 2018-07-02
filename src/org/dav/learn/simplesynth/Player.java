package org.dav.learn.simplesynth;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player
{
    private Synthesizer synthesizer = null;
    private MidiChannel[] channels = null;

    public Player()
    {
        try
        {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            channels = synthesizer.getChannels();
        }
        catch (MidiUnavailableException e)
        {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void changeInstrument(int channel, int instrument)
    {
        if (channel < 0 || channel > 15)
            throw new IllegalArgumentException("There isn't such channel.");

        if (instrument < 0 || instrument > 127)
            throw new IllegalArgumentException("There insn't such instrument.");

        channels[channel].programChange(instrument);
    }

    public void close()
    {
        synthesizer.close();
    }

    public void play(int channel, int duration, int volume, int... notes)
    {
        if (channel < 0 || channel > 15)
            throw new IllegalArgumentException("There isn't such channel.");

        for (int note : notes)
            channels[channel].noteOn(note, volume);

        try
        {
            Thread.sleep(duration);
        }
        catch (InterruptedException e)
        {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, e);
        }

        for (int note : notes)
            channels[channel].noteOff(note);
    }
}
