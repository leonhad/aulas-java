package com.uniceplac;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcaoAjuda implements ActionListener {

    private JDesktopPane pane;

    public AcaoAjuda(JDesktopPane pane) {
        this.pane = pane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Ajuda ajuda = new Ajuda();
        ajuda.setVisible(true);
        pane.add(ajuda);
    }
}
