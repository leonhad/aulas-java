package com.uniceplac;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Principal extends JFrame {
    private JDesktopPane pane = new JDesktopPane();

    public Principal() {
        setTitle("Janela de teste");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar barra = new JMenuBar();
        setJMenuBar(barra);

        JMenu arquivo = new JMenu("Arquivo");
        barra.add(arquivo);

        JMenu editar = new JMenu("Editar");
        barra.add(editar);

        AcaoNovo acaoNovo = new AcaoNovo(pane);

        JMenuItem novo = new JMenuItem("Novo");
        novo.addActionListener(acaoNovo);
        novo.setAccelerator(KeyStroke.getKeyStroke("F2"));
        arquivo.add(novo);

        arquivo.addSeparator();

        JMenuItem sair = new JMenuItem("Sair");
        arquivo.add(sair);

        JToolBar toolBar = new JToolBar();

        try {
            Image image = ImageIO.read(this.getClass().getResource("/imagem/Doc-Add.png"));
            ImageIcon icon = new ImageIcon(image);

            JButton buttonNovo = new JButton(icon);
            buttonNovo.addActionListener(acaoNovo);

            toolBar.add(buttonNovo);

            image = ImageIO.read(this.getClass().getResource("/imagem/help_book.png"));
            icon = new ImageIcon(image);

            JButton ajuda = new JButton(icon);
            ajuda.addActionListener(new AcaoAjuda(pane));
            toolBar.add(ajuda);
        } catch(IOException e) {
            e.printStackTrace();
        }

        toolBar.addSeparator();
        toolBar.add(new JComboBox());

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pane, BorderLayout.CENTER);
        getContentPane().add(toolBar, BorderLayout.NORTH);
    }
}
