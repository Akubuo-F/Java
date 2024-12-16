package com.akubuof.musicvideoapp.controllers;

import com.akubuof.musicvideoapp.graphics.shapes.ShapeType;
import com.akubuof.musicvideoapp.models.BeatGeneratorModel;
import com.akubuof.musicvideoapp.models.GraphicDisplayerModel;
import com.akubuof.musicvideoapp.views.GraphicDisplayerView;
import com.akubuof.musicvideoapp.views.MainWindowView;

import javax.sound.midi.*;
import javax.swing.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AppController implements Receiver{
    private final int windowWidth;
    private final int windowHeight;
    private MainWindowController mainWindowController;
    private final BeatGeneratorController beatGeneratorController;
    private final GraphicDisplayerController graphicDisplayerController;
    private final CountDownLatch latch;

    public AppController() {
        windowWidth = 400;
        windowHeight = 400;
        latch = new CountDownLatch(1);
        try {
            // init GraphicDisplayer
            GraphicDisplayerModel graphicDisplayerModel = new GraphicDisplayerModel(windowWidth, windowHeight);
            GraphicDisplayerView graphicDisplayerView = new GraphicDisplayerView();
            graphicDisplayerController = new GraphicDisplayerController(graphicDisplayerModel, graphicDisplayerView);

            // init BeatGenerator
            BeatGeneratorModel beatGeneratorModel = new BeatGeneratorModel();
            beatGeneratorController = new BeatGeneratorController(beatGeneratorModel, this);

            // init MainWindow
            SwingUtilities.invokeLater(() ->  {
                MainWindowView mainWindowView = new MainWindowView(graphicDisplayerView, windowWidth, windowHeight);
                mainWindowController = new MainWindowController(mainWindowView);
                mainWindowController.showWindow();
                latch.countDown();
            });
        } catch (MidiUnavailableException | InvalidMidiDataException e) {
            throw new RuntimeException("Couldn't initialize AppController!");
        }
    }

    public void run() {
        Thread runThread = new Thread(() -> {
            try {
                latch.await();
                while (true) {
                    try {
                        beatGeneratorController.generateBeat();
                        beatGeneratorController.playBeat();
                        TimeUnit.MILLISECONDS.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            beatGeneratorController.closeSequencer();
        });
        runThread.start();
    }

    @Override
    public void send(MidiMessage message, long timeStamp) {
        if (message instanceof ShortMessage sm) {
            if (sm.getCommand() == ShortMessage.NOTE_ON) {
                graphicDisplayerController.generateRandomShape(ShapeType.RECTANGLE);
                graphicDisplayerController.displayGraphics();
            }
        }
    }

    @Override
    public void close() {
        System.out.println("AppController is no longer listening for beats");
    }
}
