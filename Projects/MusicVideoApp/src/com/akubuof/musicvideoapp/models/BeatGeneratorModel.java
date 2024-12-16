package com.akubuof.musicvideoapp.models;

import javax.sound.midi.*;
import java.util.Random;

public class BeatGeneratorModel {
    private final Sequencer sequencer;
    private final Sequence sequence;
    private final Track track;
    private MidiEvent noteOnEvent;
    private MidiEvent noteOffEvent;
    private final Random randomer;

    public BeatGeneratorModel() throws MidiUnavailableException, InvalidMidiDataException {
        sequencer = MidiSystem.getSequencer();
        sequencer.open();
        sequence = new Sequence(Sequence.PPQ, 24);
        track = sequence.createTrack();
        noteOnEvent = null;
        noteOffEvent = null;
        randomer = new Random();
    }

    public void generateBeat() {
        int instrument = randomer.nextInt(16);
        int note = randomer.nextInt(128);
        int velocity = Math.max(60, randomer.nextInt(127));
        int startTick = 0;
        int endTick = 1 + randomer.nextInt(21);

        try {
            ShortMessage noteOnMessage = new ShortMessage();
            noteOnMessage.setMessage(ShortMessage.NOTE_ON, instrument, note, velocity);
            noteOnEvent = new MidiEvent(noteOnMessage, startTick);
            track.add(noteOnEvent);

            ShortMessage noteOffMessage = new ShortMessage();
            noteOffMessage.setMessage(ShortMessage.NOTE_OFF, instrument, note, velocity);
            noteOffEvent = new MidiEvent(noteOffMessage, endTick);
            track.add(noteOffEvent);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    public void playBeat() throws InvalidMidiDataException{
        if (noteOnEvent == null || noteOffEvent == null) {
            throw new InvalidMidiDataException("Generate A Beat First");
        }
        try {
            sequencer.setSequence(sequence);
            sequencer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setReceiver(Receiver listener) {
        try {
            sequencer.getTransmitter().setReceiver(listener);
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void closeSequencer() {
        sequencer.close();
    }
}
