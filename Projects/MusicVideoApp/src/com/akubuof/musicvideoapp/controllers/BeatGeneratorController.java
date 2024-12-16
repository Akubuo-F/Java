package com.akubuof.musicvideoapp.controllers;

import com.akubuof.musicvideoapp.models.BeatGeneratorModel;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Receiver;


public class BeatGeneratorController {
    private final BeatGeneratorModel model;
    //private final Receiver beatListener;

    public BeatGeneratorController(BeatGeneratorModel model, Receiver beatListener) {
        this.model = model;
        model.setReceiver(beatListener);
        //this.beatListener = beatListener;
    }

    public void generateBeat() {
        model.generateBeat();
    }

    public void playBeat() {
        Thread beatPlayingThread = new Thread(() -> {
            try {
                model.playBeat();
            } catch (InvalidMidiDataException e) {
                e.printStackTrace();
            }
        });
        beatPlayingThread.start();
    }

    public void closeSequencer() {
        model.closeSequencer();
    }
}
