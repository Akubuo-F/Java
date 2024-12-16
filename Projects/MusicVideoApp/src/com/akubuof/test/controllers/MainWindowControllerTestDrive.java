package com.akubuof.test.controllers;

import com.akubuof.musicvideoapp.controllers.MainWindowController;
import com.akubuof.musicvideoapp.views.GraphicDisplayerView;
import com.akubuof.musicvideoapp.views.MainWindowView;

import javax.swing.*;


public class MainWindowControllerTestDrive {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindowView view = new MainWindowView(new GraphicDisplayerView(), 400, 400);
            MainWindowController controller = new MainWindowController(view);
            controller.showWindow();
        });
    }
}
