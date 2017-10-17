package com.example.moviessite.controllers;


import com.example.moviessite.entities.Movie;
import com.example.moviessite.entities.MpaRating;
import com.example.moviessite.entities.User;
import com.example.moviessite.repositories.GenreRepository;
import com.example.moviessite.repositories.MoviesRepository;
import com.example.moviessite.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MovieController {
    @Autowired
    // @Autowired tells Spring to give "moviesRepo" a value
    // whenever this Controller is created.
    MoviesRepository moviesRepo;

    @Autowired
    GenreRepository genresRepo;

    @Autowired
    UserRepository usersRepo;

    @GetMapping("/")
    // to use spring's model, simply add it
    // to the parameter list of your action.
    // spring will GIVE YOU a proper "Model" object
    // Through a process called dependency injection.
    public String getMovies(Model model, HttpSession session) {
        if (session.getAttribute("current_user") == null) {
            return "login";
        }

        model.addAttribute("movies", moviesRepo.findAll());
        model.addAttribute("ratings", MpaRating.values());
        model.addAttribute("genres", genresRepo.findAll());
        return "index";
    }

    @PostMapping("/movies")
    // This is the movie that the user submitted.
    // SPRING LOOKS AT THE FORM DATA AND BUILDS US
    // THIS MOVIE. THIS IS AWESOME.
    public String addMovie(Movie submittedMovie) {
        // save "submittedMovie" into the database.
        moviesRepo.save(submittedMovie);

        return "redirect:/";
    }

    @PostMapping("/login")
    public String loginUser(User submittedUser, HttpSession session) {
        // find a user in our databases
        // where the name and password match
        // what was submitted
        User u = usersRepo
                .findByNameAndPassword(submittedUser.getName(), submittedUser.getPassword());

        // if u != null, we found a user in our database
        // that matches the username and password

        // i.e. they login successfully
        if (u != null) {
            session.setAttribute("current_user", u.getId());
        }

        return "redirect:/";
    }
}
