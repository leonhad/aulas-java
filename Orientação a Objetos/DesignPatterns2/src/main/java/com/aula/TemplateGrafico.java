package com.aula;

import javax.swing.*;
import java.awt.*;

public class TemplateGrafico {
    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName() + ":" + info.getClassName());
            }

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Exemplo em swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setLayout(new FlowLayout());

        JButton button = new JButton("Ok");
        button.addActionListener(c -> {
            JOptionPane.showMessageDialog(frame, "A pedido do Linhares");
            System.exit(0);
        });
        frame.getContentPane().add(button);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
