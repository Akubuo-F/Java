package com.akubuof.musicvideoapp.controllers;

import com.akubuof.musicvideoapp.views.MainWindowView;

public class MainWindowController {
    private final MainWindowView view;

    public MainWindowController(MainWindowView view) {
        this.view = view;
    }

    public void repaint() {
        System.out.println("Repainting...");
        view.repaint();
    }

    public boolean isWindowVisible() {
        return view.isVisible();
    }

    public void showWindow() {
        view.setVisible(true);
    }
}
