package org.example.UI.filtros;

import org.example.obj.ComandoFiltro;
import org.example.obj.Imagen;

public class Verde extends ComandoFiltro {
    private final Imagen imagenBase;

    public Verde(Imagen img) {
        this.imagenBase = img;
    }
    @Override
    public void ejecutar() {
        int ancho = imagenBase.getAncho();
        int alto = imagenBase.getAlto();
        int[][] pixeles = imagenBase.getPixeles();
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                // Obtiene el valor de verde del píxel
                int g = (pixeles[i][j] >> 8) & 0x000000FF;
                // Creamos un nuevo valor entero que representa el color verde del píxel,
                // manteniendo los otros componentes de color en cero
                int verde = (g << 8) + 0xFF000000;
                pixeles[i][j] = verde;
            }
        }
        imagenBase.cambiosImagen();
    }

}
