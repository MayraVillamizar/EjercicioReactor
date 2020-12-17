package co.com.prueba;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Movie {
    private String name;
    private int durationMin;
    private double score;
    private String director;


}
