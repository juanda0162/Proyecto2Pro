package org.example.UI.filtros;

import org.example.obj.ComandoFiltro;
import org.example.obj.Imagen;

public class Vertical extends ComandoFiltro {
    private final Imagen imagenBase;

    public Vertical(Imagen img) {
        this.imagenBase = img;
    }

    @Override
    public void ejecutar() {
        int ancho = imagenBase.getAncho();
        int alto = imagenBase.getAlto();
        int[][] pixeles = imagenBase.getPixeles();
        //Cuando llegamos a la mitad de la imagen los pixeles ya han sido intercambiados
        for (int i = 0; i < ancho/2; i++) {
            for (int j = 0; j < alto; j++) {
                int actual = pixeles[i][j];
                //Asignamos el valor del primer pixel al ultimo
                pixeles[i][j] = pixeles[ancho - 1 - i][alto - 1 - j];
                //Asignamos el valor del ultimo al primero
                pixeles[ancho - 1 - i][alto - 1 - j] = actual;
            }
        }
        imagenBase.cambiosImagen();
    }
}
