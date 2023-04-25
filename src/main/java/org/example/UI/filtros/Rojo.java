package org.example.UI.filtros;


import org.example.obj.ComandoFiltro;
import org.example.obj.Imagen;

public class Rojo extends ComandoFiltro {
    private final Imagen imagenBase;

    public Rojo(Imagen img) {
        this.imagenBase = img;
    }

    @Override
    public void ejecutar() {
        int ancho = imagenBase.getAncho();
        int alto = imagenBase.getAlto();
        int[][] pixeles = imagenBase.getPixeles();
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                int r = (pixeles[i][j] >> 16) & 0x000000FF;
                int rojo = (r << 16) + 0xFF000000;
                pixeles[i][j] = rojo;
            }
        }
        imagenBase.cambiosImagen();
    }
}
