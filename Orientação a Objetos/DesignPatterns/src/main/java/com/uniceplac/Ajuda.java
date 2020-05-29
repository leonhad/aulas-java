package com.uniceplac;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ajuda extends JInternalFrame {
    public Ajuda() {
        setSize(200, 200);
        setVisible(true);
        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        setTitle("Ajuda");

        setLayout(new FlowLayout());
        JButton logar = new JButton("Logar");
        logar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Log log = Log.getInstance();
                log.log("Chamada na tela de ajuda");
                System.out.println(log);
            }
        });
        add(logar);
    }
}
