package com.akubuof.musicvideoapp.views;

import javax.swing.*;

public class MainWindowView extends JFrame{

    public MainWindowView(GraphicDisplayerView graphicDisplayer, int width, int height) {
        setTitle("Music Video App");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeWindow(graphicDisplayer);
    }

    private void initializeWindow(GraphicDisplayerView graphicDisplayer) {
        add(graphicDisplayer);
    }
}
