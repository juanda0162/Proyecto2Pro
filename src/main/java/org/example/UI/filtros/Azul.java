package org.example.UI.filtros;

import org.example.obj.ComandoFiltro;
import org.example.obj.Imagen;

public class Azul extends ComandoFiltro {
    private final Imagen imagenBase;

    public Azul(Imagen img) {
        this.imagenBase = img;
    }

    @Override
    public void ejecutar() {
        int ancho = imagenBase.getAncho();
        int alto = imagenBase.getAlto();
        int[][] pixeles = imagenBase.getPixeles();
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                int b = pixeles[i][j] & 0x000000FF;
                pixeles[i][j] = b;
            }
        }
        imagenBase.cambiosImagen();
    }
}
