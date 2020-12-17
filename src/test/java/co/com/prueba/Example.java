package co.com.prueba;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Example {

    @Test
    public void filterByScore(){
        List<Movie> movies1 = new ArrayList<>();
        List<Movie> movies2 = new ArrayList<>();

         Movie movie1 = Movie.builder()
                .name("Volver al futuro")
                .durationMin(100)
                .score(8.5)
                .director("Robert Zemeckis")
                .build();

        Movie movie2 =Movie.builder()
                .name("Anabelle")
                .durationMin(110)
                .score(6.5)
                .director("John R. Leonetti")
                .build();

        Movie movie3 =Movie.builder()
                .name("Lord of the Ring")
                .durationMin(180)
                .score(9.2)
                .director("Peter Jackson")
                .build();

        Movie movie4 = Movie.builder()
                .name("El conjuro")
                .durationMin(190)
                .score(7.5)
                .director("James Wan")
                .build();

        Movie movie5 = Movie.builder()
                .name("Avatar")
                .durationMin(180)
                .score(10.0)
                .director("James Cameron")
                .build();

        movies1.add(movie1);
        movies1.add(movie2);
        movies1.add(movie3);
        movies2.add(movie4);
        movies2.add(movie5);

        Flux<Movie>movieFlux1 =Flux.fromIterable(movies1);
        Flux<Movie>movieFlux2 =Flux.fromIterable(movies2);

        System.out.println("Realizar merge entre las dos listas");
        Flux.merge(movieFlux1,movieFlux2)
                .subscribe(System.out::println);

        System.out.println("\nFiltrar por las peliculas que tiempos mayores a 120 segundos");
        Flux.merge(movieFlux1,movieFlux2)
                .filter(movie -> movie.getDurationMin()>120)
                .subscribe(System.out::println);

        System.out.println("\nFiltrar las peliculas con score mayor a 8");
        Flux.merge(movieFlux1,movieFlux2)
                .filter(movie -> movie.getScore()>8)
                .subscribe(System.out::println);

        System.out.println("\nFiltrar por un director especifico: Peter Jackson");
        Flux.merge(movieFlux1,movieFlux2)
                .filter(movie -> movie.getDirector().equals("Peter Jackson"))
                .subscribe(System.out::println);

        System.out.println("\nTodos los filtros");
        Flux.merge(movieFlux1,movieFlux2)
                .filter(movie -> movie.getDurationMin()>120)
                .filter(movie -> movie.getScore()>8)
                .filter(movie -> movie.getDirector().equals("James Cameron"))
                .subscribe(System.out::println);



    }
}
