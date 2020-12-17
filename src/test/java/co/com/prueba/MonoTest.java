package co.com.prueba;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.Duration;
import java.util.Arrays;

public class MonoTest {

    @Test
    public void monoTest1(){

        //creo un objeto tipo mono y se subscribio
        Mono.just("Hola Mundo").
                subscribe(System.out::println);

    }

    @Test
    public void fluxTest1(){
        Flux.just(1,2,3,4,5)
                .subscribe(System.out::println);
    }

    @Test
    public void fluxTest2(){
        Flux.range(1,20)
                .subscribe(System.out::println);
    }

    @Test
    public void fluxTest3(){
        Flux.range(1,20).take(5)
                .subscribe(System.out::println);
    }

//Mostrar Log
    @Test
    public void fluxTest4(){
        Flux.range(1,20).take(5).log()
                .subscribe(System.out::println);
    }

    //Flux en intervalos de tiempo
    @Test
    public void fluxTest5(){
        Flux.interval(Duration.ofSeconds(1)).take(5)
                .subscribe(System.out::println);

        //Thread.sleep(2000);
    }

    @Test
    public void fluxTest6() {

        Flux.fromIterable(Arrays.asList(1,2,3,4,5))
                .subscribe(System.out::println);
    }
}
