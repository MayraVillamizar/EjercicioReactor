package co.com.prueba;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Operators {

    //Uso operator Map operaciones matematicas
    @Test
    public void mapTest1(){
        Flux.range(1,10)
                .map(x -> x*20)
                .subscribe(System.out::println);

    }

    @Test
    public void mapTest2(){
        Flux.range(1,10)
                .map(x -> x*20)
                .map(y -> y/10)
                .subscribe(System.out::println);

    }

    //Uso operator Map String
    @Test
    public void mapTest3(){
        Mono.just("Mayra")
                .map(x -> x.toUpperCase())
                .subscribe(System.out::println);

    }

    @Test
    public void mergeTest(){
        Flux<String> flux1 = Flux.just("2","4","6","8");
        Flux<String> flux2 = Flux.just("1","3","5","7");
        Flux.merge(flux1,flux2)
                .subscribe(System.out::println);

    }

    @Test
    public void mergeTest1(){
        Flux<String> flux1 = Flux.just("2","4","6","8");
        Flux<String> flux2 = Flux.just("1","3","5","7");
        Flux.mergeOrdered(flux1,flux2)
                .subscribe(System.out::println);

    }

    @Test
    public void concatTest(){
        Flux<String> flux1 = Flux.just("2","4","6","8");
        Flux<String> flux2 = Flux.just("1","3","5","7");
        Flux.concat(flux1,flux2)
                .subscribe(System.out::println);

    }

}
