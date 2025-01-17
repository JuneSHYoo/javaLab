package com.test.sangHoon;


import java.util.*;
import java.util.stream.Collectors;

public class MovieManager {
 private List<Movie> movies;

 public MovieManager() {
     this.movies = new ArrayList<>();
 }

 public void addMovie(String title, String director, Integer releaseYear, List<String> genres, Integer audience) {
     if (findMovieByTitle(title) != null) {
         System.out.println("Error: Movie with this title already exists.");
         return;
     }
     Movie newMovie = new Movie(title);
     if (director != null) newMovie.setDirector(director.toLowerCase());
     if (releaseYear != null) newMovie.setReleaseYear(releaseYear);
     if (genres != null) newMovie.setGenres(genres.stream().map(String::toLowerCase).collect(Collectors.toList()));
     if (audience != null) newMovie.setAudience(audience);
     movies.add(newMovie);
     System.out.println("Movie added successfully.");
 }

 public void searchMovies(String title, String director, Integer releaseYear, List<String> genres) {
     List<Movie> results = movies.stream()
             .filter(m -> title == null || m.getTitle().contains(title.toLowerCase()))
             .filter(m -> director == null || (m.getDirector() != null && m.getDirector().contains(director.toLowerCase())))
             .filter(m -> releaseYear == null || m.getReleaseYear().equals(releaseYear))
             .filter(m -> genres == null || genres.isEmpty() || m.getGenres().stream().anyMatch(genres::contains))
             .collect(Collectors.toList());

     if (results.isEmpty()) {
         System.out.println("No movies found matching the criteria.");
     } else {
         results.forEach(this::printMovie);
     }
 }

 public void updateMovie(String title, String newDirector, Integer newReleaseYear, List<String> newGenres, Integer newAudience) {
     Movie movie = findMovieByTitle(title);
     if (movie == null) {
         System.out.println("Error: Movie not found.");
         return;
     }
     if (newDirector != null) movie.setDirector(newDirector.toLowerCase());
     if (newReleaseYear != null) movie.setReleaseYear(newReleaseYear);
     if (newGenres != null) movie.setGenres(newGenres.stream().map(String::toLowerCase).collect(Collectors.toList()));
     if (newAudience != null) movie.setAudience(newAudience);
     System.out.println("Movie updated successfully.");
 }

 public void deleteMovie(String title) {
     Movie movie = findMovieByTitle(title);
     if (movie == null) {
         System.out.println("Error: Movie not found.");
         return;
     }
     movies.remove(movie);
     System.out.println("Movie deleted successfully.");
 }

 public void listTopMovies(String genre, int limit) {
     List<Movie> filteredMovies = (genre == null || genre.isEmpty())
             ? movies
             : movies.stream().filter(m -> m.getGenres().contains(genre.toLowerCase())).collect(Collectors.toList());

     filteredMovies.stream()
             .sorted(Comparator.comparingInt((Movie m) -> m.getAudience() != null ? m.getAudience() : 0).reversed())
             .limit(limit)
             .forEach(this::printMovie);
 }

 private Movie findMovieByTitle(String title) {
     return movies.stream()
             .filter(m -> m.getTitle().equalsIgnoreCase(title))
             .findFirst()
             .orElse(null);
 }

 private void printMovie(Movie movie) {
     System.out.println("Title: " + movie.getTitle());
     System.out.println("Director: " + movie.getDirector());
     System.out.println("Release Year: " + movie.getReleaseYear());
     System.out.println("Genres: " + String.join(", ", movie.getGenres()));
     System.out.println("Audience: " + movie.getAudience());
     System.out.println("-------------------------");
 }
}
