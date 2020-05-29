package com.uniceplac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Documento extends JInternalFrame {

    public Documento() {
        setSize(200, 100);
        setVisible(true);
        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        setTitle("Documento");


        setLayout(new FlowLayout());
        JButton logar = new JButton("Logar");
        logar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Log log = Log.getInstance();
                log.log("Chamada na tela de documento");
                System.out.println(log);
            }
        });
        add(logar);
    }
}
