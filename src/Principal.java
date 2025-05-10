import java.util.ArrayList;

import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.setDuracionEnMinutos(120);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        miPelicula.evalua(7.8);
        System.out.println(miPelicula.getTotalDeLasEvaluaciones());
        System.out.println(miPelicula.calculaMedia());

        Serie malcom = new Serie("Malcom el del medio", 2006);
        malcom.setTemporadas(7);
        malcom.setMinutosPorEpisodio(30);
        malcom.setEpisodiosPorTemporada(8);
        malcom.muestraFichaTecnica();
        System.out.println(malcom.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula("Interestelar", 2016);
        otraPelicula.setDuracionEnMinutos(180);

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(malcom);
        calculadora.incluye(otraPelicula);
        System.out.println("Tiempo necesario para ver tus títulos favoritos estas vacaciones: "+ calculadora.getTiempoTotal() + " minutos");

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.fitra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("El cumpleaños de Lois");
        episodio.setSerie(malcom);
        episodio.setTotalVisualizaciones(50);

        filtroRecomendacion.fitra(episodio);

        var peliculaDeAlonso = new Pelicula("El señor de los anillos", 2001); // Var hace la inferencia de datos y no hay necesidad de poner Pelicula
        peliculaDeAlonso.setDuracionEnMinutos(180);

        ArrayList<Pelicula> listaDePEliculas = new ArrayList<>();
        listaDePEliculas.add(peliculaDeAlonso);
        listaDePEliculas.add(miPelicula);
        listaDePEliculas.add(otraPelicula);
        
        System.out.println("Tamanaño de la lista: " + listaDePEliculas.size());
        System.out.println("La primera pelicula es: " + listaDePEliculas.get(0).getNombre());
        System.out.println(listaDePEliculas.toString());
        System.out.println("toString de la pelicula " + listaDePEliculas.get(0).toString());

    }
}
