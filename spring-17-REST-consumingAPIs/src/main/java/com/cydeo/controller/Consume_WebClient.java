package com.cydeo.controller;

import com.cydeo.entity.Genre;
import com.cydeo.entity.MovieCinema;
import com.cydeo.repository.GenreRepository;
import com.cydeo.repository.MovieCinemaRepository;
import com.cydeo.repository.MovieRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class Consume_WebClient {

    private final WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();

    private final MovieCinemaRepository movieCinemaRepository;
    private final GenreRepository genreRepository;

    public Consume_WebClient(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }


    @GetMapping("/flux-movie-cinema")
    public Flux<MovieCinema> getMovieCinema(){  // we use flux because list blocks the stream but flux is not
        // if we return one MovieCinema then use Mono<MovieCinema>

        return Flux.fromIterable(movieCinemaRepository.findAll());
    }

//    @GetMapping("/mono-movie-cinema/{id}")
//    public Mono<MovieCinema> getMovieById(@PathVariable("id") Long id) {
//        return Mono.just(movieCinemaRepository.findById(id).get());
//    }

    @GetMapping("/mono-movie-cinema/{id}")
    public ResponseEntity<Mono<MovieCinema>> getMovieById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(Mono.just(movieCinemaRepository.findById(id).get()));
    }

    @PostMapping("/create")
    public Mono<Genre> createGenre(@RequestBody Genre body){
        return Mono.just(genreRepository.save(body));
    }

    @DeleteMapping("/delete/genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") Long id){
        genreRepository.deleteById(id);

        return Mono.empty();
    }


    //-----------------------------------consuming-------------------------------------

    @GetMapping("/flux")
    public Flux<MovieCinema> readWithWebClient(){
       return webClient
                .get()
                .uri("/flux-movie-cinema")
               .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(MovieCinema.class);
    }

    @GetMapping("/mono/{id}")
    public Mono<MovieCinema> readById(@PathVariable("id") Long id){
        return webClient
                .get()
                .uri("/mono-movie-cinema/{id}",id)
                .header(HttpHeaders.ACCEPT,MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(MovieCinema.class);
    }
}
