package com.aluracursos.screenmatch.principal;

import java.util.ArrayList;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

public class PrincipalConListas {
    public static void main(String[] args) {
        
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.evalua(9);
        Pelicula otraPelicula = new Pelicula("Interestelar", 2016);
        otraPelicula.evalua(6);
        var peliculaDeAlonso = new Pelicula("El señor de los anillos", 2001);
        peliculaDeAlonso.evalua(10);
        Serie malcom = new Serie("Malcom el del medio", 2006);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaDeAlonso);
        lista.add(malcom);

        for (Titulo item: lista) {
            System.out.println(item);
            Pelicula pelicula = (Pelicula) item;
            System.out.println(pelicula.getClasificacion());
        }

    }
}
