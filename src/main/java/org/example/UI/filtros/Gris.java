package org.example.UI.filtros;

import org.example.obj.ComandoFiltro;
import org.example.obj.Imagen;

public class Gris extends ComandoFiltro {
    private final Imagen imagenBase;

    public Gris(Imagen img) {
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
                int g = (pixeles[i][j] >> 8) & 0x000000FF;
                int b = pixeles[i][j] & 0x000000FF;
                int prom = (r + g + b) / 3;

                pixeles[i][j] = prom + prom * 256 + prom * 256 * 256;
            }
        }
        imagenBase.cambiosImagen();
    }
}