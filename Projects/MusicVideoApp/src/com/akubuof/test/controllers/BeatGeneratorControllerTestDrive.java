package com.akubuof.test.controllers;

import com.akubuof.musicvideoapp.controllers.BeatGeneratorController;
import com.akubuof.musicvideoapp.models.BeatGeneratorModel;

import javax.sound.midi.*;

public class BeatGeneratorControllerTestDrive {
    public static void main(String[] args) {
        try {
            BeatGeneratorModel model = new BeatGeneratorModel();
            BeatGeneratorController controller = new BeatGeneratorController(model, new Listener());

            controller.generateBeat();
            controller.playBeat();
        } catch (MidiUnavailableException | InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    private static class Listener implements Receiver {
        @Override
        public void send(MidiMessage message, long timeStamp) {
            if (message instanceof ShortMessage sm) {
                if (sm.getCommand() == ShortMessage.NOTE_ON) {
                    System.out.println("Listener listened and heard a beat");
                }
            }
        }

        @Override
        public void close() {
            System.out.println("Closed receiver");
        }
    }
}
