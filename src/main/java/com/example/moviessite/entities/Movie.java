package com.example.moviessite.entities;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    private Genre genre;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private double score;

    @Column(nullable= false)
    private MpaRating rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public MpaRating getRating() {
        return rating;
    }

    public void setRating(MpaRating rating) {
        this.rating = rating;
    }
}
