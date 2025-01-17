package com.test.sangHoon;

import java.util.*;

public class SangHoon {
    
    public void movieManagerApp(Scanner scanner) {
        MovieManager movieManager = new MovieManager();

        // Sample movies
        movieManager.addMovie("Inception", "Christopher Nolan", 2010, Arrays.asList("sci-fi", "thriller"), 1000000);
        movieManager.addMovie("Interstellar", "Christopher Nolan", 2014, Arrays.asList("sci-fi", "drama"), 1200000);
        movieManager.addMovie("The Dark Knight", "Christopher Nolan", 2008, Arrays.asList("action", "drama"), 1500000);

        try {
            while (true) {
                System.out.println("\n=== Movie Manager ===");
                System.out.println("1. Add Movie");
                System.out.println("2. Search Movies");
                System.out.println("3. Update Movie");
                System.out.println("4. Delete Movie");
                System.out.println("5. List Top Movies");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter director (or leave blank): ");
                        String director = scanner.nextLine();
                        System.out.print("Enter release year (or leave blank): ");
                        String yearInput = scanner.nextLine();
                        Integer releaseYear = yearInput.isEmpty() ? null : Integer.parseInt(yearInput);
                        System.out.print("Enter genres (comma-separated, or leave blank): ");
                        String genresInput = scanner.nextLine();
                        List<String> genres = genresInput.isEmpty() ? null : Arrays.asList(genresInput.split(","));
                        System.out.print("Enter audience (or leave blank): ");
                        String audienceInput = scanner.nextLine();
                        Integer audience = audienceInput.isEmpty() ? null : Integer.parseInt(audienceInput);

                        movieManager.addMovie(title, director, releaseYear, genres, audience);
                        break;
                    case 2:
                        System.out.print("Enter title to search (or leave blank): ");
                        String searchTitle = scanner.nextLine();
                        System.out.print("Enter director to search (or leave blank): ");
                        String searchDirector = scanner.nextLine();
                        System.out.print("Enter release year to search (or leave blank): ");
                        String searchYearInput = scanner.nextLine();
                        Integer searchYear = searchYearInput.isEmpty() ? null : Integer.parseInt(searchYearInput);
                        System.out.print("Enter genres to search (comma-separated, or leave blank): ");
                        String searchGenresInput = scanner.nextLine();
                        List<String> searchGenres = searchGenresInput.isEmpty() ? null : Arrays.asList(searchGenresInput.split(","));

                        movieManager.searchMovies(searchTitle, searchDirector, searchYear, searchGenres);
                        break;
                    case 3:
                        System.out.print("Enter title of the movie to update: ");
                        String updateTitle = scanner.nextLine();
                        System.out.print("Enter new director (or leave blank): ");
                        String newDirector = scanner.nextLine();
                        System.out.print("Enter new release year (or leave blank): ");
                        String newYearInput = scanner.nextLine();
                        Integer newReleaseYear = newYearInput.isEmpty() ? null : Integer.parseInt(newYearInput);
                        System.out.print("Enter new genres (comma-separated, or leave blank): ");
                        String newGenresInput = scanner.nextLine();
                        List<String> newGenres = newGenresInput.isEmpty() ? null : Arrays.asList(newGenresInput.split(","));
                        System.out.print("Enter new audience (or leave blank): ");
                        String newAudienceInput = scanner.nextLine();
                        Integer newAudience = newAudienceInput.isEmpty() ? null : Integer.parseInt(newAudienceInput);

                        movieManager.updateMovie(updateTitle, newDirector, newReleaseYear, newGenres, newAudience);
                        break;
                    case 4:
                        System.out.print("Enter title of the movie to delete: ");
                        String deleteTitle = scanner.nextLine();
                        movieManager.deleteMovie(deleteTitle);
                        break;
                    case 5:
                        System.out.print("Enter genre to filter (or leave blank): ");
                        String filterGenre = scanner.nextLine();
                        movieManager.listTopMovies(filterGenre, 10);
                        break;
                    case 6:
                        System.out.println("Exiting Movie Manager. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
