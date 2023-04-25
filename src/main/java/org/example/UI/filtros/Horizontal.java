package org.example.UI.filtros;

import org.example.obj.ComandoFiltro;
import org.example.obj.Imagen;

public class Horizontal extends ComandoFiltro {
    private final Imagen imagenBase;

    public Horizontal(Imagen img) {
        this.imagenBase = img;
    }

    @Override
    public void ejecutar() {
        int ancho = imagenBase.getAncho();
        int alto = imagenBase.getAlto();
        int[][] pixeles = imagenBase.getPixeles();

        for (int i = 0; i < ancho/2; i++) { //filas
            for (int j = 0; j < alto; j++) { //columnas
                int actual = pixeles[i][j];
                //intercambiamos las posiciones de la fila actual con la fila opuesta
                pixeles[i][j] = pixeles[ancho-1-i][j];
                //intercambiamos las posiciones de la fila opuesta con la fila actual
                pixeles[ancho-1-i][j] = actual;
            }
        }
        imagenBase.cambiosImagen();
    }
}
