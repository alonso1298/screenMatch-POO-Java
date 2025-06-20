package com.aluracursos.screenmatch.principal;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.alura.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.aluracursos.screenmatch.modelos.Titulo;
// import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) // setFieldNamingPolicy permite decirle a Gson que vamos a usar una politica que sera Upper camel case 
                .setPrettyPrinting()
                .create();

        while(true){

            System.out.println("Escriba el nombre de una pelicula: ");
            String busqueda = lectura.nextLine();

            if(busqueda.equals("salir")){
                break;
            }

            String direccion = "http://www.omdbapi.com/?t=" + busqueda.replace(" ", "+") + "&apikey=517489d5";

            try { // Se intentara ejecutar este codigo

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

                HttpResponse<String> response = client
                    .send(request, BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(miTituloOmdb);

                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("Titulo ya convertido: " + miTitulo);

                titulos.add(miTitulo);

            }catch (NumberFormatException e) { // Si hay un erro ejecutara este codigo
                    System.out.println("Ocurrio un error: ");
                    System.out.println(e.getMessage());
            }catch(IllegalArgumentException e){
                System.out.println("Error en la URI, verifique la dirección.");
            }catch (ErrorEnConversionDeDuracionException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);

        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos));

        System.out.println("Finalizo la ejecucion del programa");
        escritura.close();
        lectura.close();
    }
}
