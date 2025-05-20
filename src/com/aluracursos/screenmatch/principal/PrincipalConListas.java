package com.aluracursos.screenmatch.principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
            System.out.println(item.getNombre());
            if(item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2){
                System.out.println(pelicula.getClasificacion());
            }
        }

        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Pedro Pascal");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Isable Merced");

        System.out.println("Lista de artistas no ordenada: " + listaDeArtistas);
        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artistas ordenada:" + listaDeArtistas);

        Collections.sort(lista);
        System.out.println("Lista de titulos ordenados: " + lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha: " + lista);
    }
}
