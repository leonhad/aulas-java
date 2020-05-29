package com.uniceplac;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcaoNovo implements ActionListener {

    private final JDesktopPane pane;

    public AcaoNovo(JDesktopPane pane) {
        this.pane = pane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Documento documento = new Documento();
        documento.setVisible(true);
        pane.add(documento);
    }
}
