package com.cydeo.bootstrap;

import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataGenerator implements CommandLineRunner {


    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final TicketRepository ticketRepository;
    private final GenreRepository genreRepository;
    private final UserRepository userRepository;

    public DataGenerator(AccountRepository accountRepository, CinemaRepository cinemaRepository, MovieRepository movieRepository, MovieCinemaRepository movieCinemaRepository, TicketRepository ticketRepository, GenreRepository genreRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.movieRepository = movieRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.ticketRepository = ticketRepository;
        this.genreRepository = genreRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(cinemaRepository.getCinemaByName("Hall 1 - EMPIRE"));
        System.out.println(accountRepository.getAllAdminAccounts());
        System.out.println(cinemaRepository.getDistinctBySponsoredName());
        System.out.println(movieRepository.getAllMovieNames());
        System.out.println(movieCinemaRepository.findAll());
        System.out.println(movieCinemaRepository.groupMovieCinemaById());
        System.out.println(ticketRepository.findAll());
//        System.out.println(ticketRepository.getTicketsByDateBetween(LocalDateTime.now().minusDays(1000), LocalDateTime.now()));
//        System.out.println(ticketRepository.retrieveAllBySearchCriteria("it"));
        System.out.println(genreRepository.fetchAll());
        System.out.println(userRepository.fetchAllUsers());

    }
}