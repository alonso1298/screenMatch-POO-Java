package com.aluracursos.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.aluracursos.screenmatch.modelos.Titulo;
// import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el nombre de una pelicula: ");

        String busqueda = lectura.nextLine();
        String direccion = "http://www.omdbapi.com/?t=" + busqueda + "&apikey=517489d5";

        lectura.close();

        try { // Se intentara ejecutar este codigo

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

            HttpResponse<String> response = client
                .send(request, BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create(); // setFieldNamingPolicy permite decirle a Gson que vamos a usar una politica que sera Upper camel case 
            TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(miTituloOmdb);

                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("Titulo ya convertido: " + miTitulo);
        }catch (NumberFormatException e) { // Si hay un erro ejecutara este codigo
                System.out.println("Ocurrio un error: ");
                System.out.println(e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println("Error en la URI, verifique la dirección.");
        }catch (Exception e){
            System.out.println("Ocurrio un error inesperado");
        }
        System.out.println("Finalizo la ejecucion del programa");
    }
}
