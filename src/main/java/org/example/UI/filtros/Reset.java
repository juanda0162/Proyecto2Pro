package org.example.UI.filtros;

import org.example.obj.ComandoFiltro;
import org.example.obj.Imagen;

public class Reset extends ComandoFiltro {
    private final Imagen imagenBase;
    public Reset(Imagen modelo) {
        this.imagenBase = modelo;
    }

    @Override
    public void ejecutar() {
        int ancho = imagenBase.getAncho();
        int alto = imagenBase.getAlto();
        int[][] pixelesOriginales = imagenBase.getPixelesOriginales();
        int[][] pixeles = imagenBase.getPixeles();
        for (int i = 0; i < ancho; i++) {
            for(int j = 0; j < alto; j++) {
                pixeles[i][j] = pixelesOriginales[i][j];
            }
        }
        imagenBase.cambiosImagen();
    }
}
