package org.example.UI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.UI.filtros.*;
import org.example.obj.ComandoFiltro;
import org.example.obj.Imagen;

import javax.swing.*;
import java.awt.*;

public class ImagenFrame extends JFrame {
    private static Logger logger = LogManager.getRootLogger();
    private Imagen modelo;
    public ImagenFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        modelo = new Imagen(600,400);
        ImagenPanel panel = new ImagenPanel(modelo);
        modelo.addObserver(panel);
        this.getContentPane().add(panel, BorderLayout.CENTER);

        menu();

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void menu() {
        JMenuBar bar = new JMenuBar();

        JMenu menu = new JMenu("Archivo");
        JMenuItem item = new JMenuItem("Abrir");
        item.addActionListener(e -> {
            menuArchivoItemAbrir();
        });
        menu.add(item);

        menu.addSeparator();

        item = new JMenuItem("Salir");
        item.addActionListener(e -> {
            logger.info("El usuario sale del programa");
            System.exit(0);
        });

        menu.add(item);

        item = new JMenuItem("Reset");
        item.addActionListener(e -> {
            logger.info("El usuario elimina filtros");
            ComandoFiltro cmd = new Reset(modelo);
            cmd.ejecutar();
        });

        menu.add(item);

        bar.add(menu);

        menu = new JMenu("Imagen");
        item = new JMenuItem("Gris");
        item.addActionListener(e -> {
            logger.info("El usuario convierte la imagen a escala de grises");
            ComandoFiltro cmd = new Gris(modelo);
            cmd.ejecutar();
        });

        menu.add(item);

        item = new JMenuItem("Verdes");
        item.addActionListener(e -> {
            logger.info("El usuario convierte la imagen a escala de verdes");
            ComandoFiltro cmd = new Verde(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        item = new JMenuItem("Rojos");
        item.addActionListener(e -> {
            logger.info("El usuario convierte la imagen a escala de rojos");
            ComandoFiltro cmd = new Rojo(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        item = new JMenuItem("Azules");
        item.addActionListener(e -> {
            logger.info("El usuario convierte la imagen a escala de azules");
            ComandoFiltro cmd = new Azul(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        item = new JMenuItem("Vertical");
        item.addActionListener(e -> {
            logger.info("El usuario convierte la imagen a vertical");
            ComandoFiltro cmd = new Vertical(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        item = new JMenuItem("Horizontal");
        item.addActionListener(e -> {
            logger.info("El usuario convierte la imagen a Horizontal");
            ComandoFiltro cmd = new Horizontal(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        item = new JMenuItem("Sal y pimienta");
        item.addActionListener(e -> {
            logger.info("El usuario convierte la imagen a Sal y pimienta");
            ComandoFiltro cmd = new SalYPimienta(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        item = new JMenuItem("Floyd Steinberg");
        item.addActionListener(e -> {
            logger.info("El usuario convierte la imagen a Floyd Steinberg");
            ComandoFiltro cmd = new Steinberg(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        item = new JMenuItem("Bandera");
        item.addActionListener(e -> {
            logger.info("El usuario convierte la imagen en una bandera BOB");
            ComandoFiltro cmd = new Bandera(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        bar.add(menu);

        this.setJMenuBar(bar);
    }

    private void menuArchivoItemAbrir() {
        logger.info("Abrimos el file chooser para escoger un archivo");
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            logger.info(chooser.getSelectedFile().getAbsolutePath());
            modelo.leer(chooser.getSelectedFile());
        }
        this.pack();
    }
}
