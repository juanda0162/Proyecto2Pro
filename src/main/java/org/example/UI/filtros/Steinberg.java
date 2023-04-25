package org.example.UI.filtros;

import org.example.obj.ComandoFiltro;
import org.example.obj.Imagen;

import java.awt.*;

public class Steinberg extends ComandoFiltro {
    private final Imagen imagenBase;

    public Steinberg(Imagen img) {
        this.imagenBase = img;
    }

    @Override
    public void ejecutar() {

        /*  for each y from top to bottom do
            for each x from left to right do
            oldpixel := pixels[x][y]
            newpixel := find_closest_palette_color(oldpixel)
            pixels[x][y] := newpixel
            quant_error := oldpixel - newpixel
            pixels[x + 1][y    ] := pixels[x + 1][y    ] + quant_error × 7 / 16
            pixels[x - 1][y + 1] := pixels[x - 1][y + 1] + quant_error × 3 / 16
            pixels[x    ][y + 1] := pixels[x    ][y + 1] + quant_error × 5 / 16
            pixels[x + 1][y + 1] := pixels[x + 1][y + 1] + quant_error × 1 / 16

            find_closest_palette_color(oldpixel) = round(oldpixel / 255)
            */
        ComandoFiltro grises = new Gris(imagenBase);
        grises.ejecutar();
        int ancho = imagenBase.getAncho();
        int alto = imagenBase.getAlto();
        int[][] pixeles = imagenBase.getPixeles();

        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                // Se obtienen los valores RGB del pixel actual
                int r = (pixeles[i][j] >> 16) & 0x000000FF;
                int g = (pixeles[i][j] >> 8) & 0x000000FF;
                int b = pixeles[i][j] & 0x000000FF;
                // Se calcula la escala de grises promediando los valores RGB
                int prom = (r + g + b) / 3;

                // Si el promedio es mayor a 127, se pinta el pixel de blanco,
                // sino se pinta de negro
                if (prom > 127) {
                    pixeles[i][j] = Color.WHITE.getRGB();
                } else {
                    pixeles[i][j] = Color.BLACK.getRGB();
                }
                // Se calcula el error entre el valor original y el valor de la escala de grises
                int error = prom - ((pixeles[i][j] >> 16) & 0x000000FF);

                // Se aplica el algoritmo de difusión de error
                if (i + 1 < ancho) {
                    pixeles[i + 1][j] = pixeles[i + 1][j] + (error * 7 / 16);
                }
                if (i - 1 >= 0 && j + 1 < alto) {
                    pixeles[i - 1][j + 1] = pixeles[i - 1][j + 1] + (error * 3 / 16);
                }
                if (j + 1 < alto) {
                    pixeles[i][j + 1] = pixeles[i][j + 1] + (error * 5 / 16);
                }
                if (i + 1 < ancho && j + 1 < alto) {
                    pixeles[i + 1][j + 1] = pixeles[i + 1][j + 1] + (error * 1 / 16);
                }

            }
        }
        imagenBase.cambiosImagen();
    }
}