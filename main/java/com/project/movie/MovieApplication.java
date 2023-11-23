package com.project.movie;

import com.project.movie.model.ActionMovie;
import com.project.movie.model.ComedyMovie;
import com.project.movie.model.Movie;
import com.project.movie.repositroy.ActionMovieRepository;
import com.project.movie.repositroy.ComedyMovieRepository;
import com.project.movie.repositroy.movierepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class MovieApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

	@Autowired
	movierepository movierepository1;
	@Autowired
	ActionMovieRepository actionMovieRepository;
	@Autowired
	ComedyMovieRepository comedyMovieRepository;

	@Override
	public void run(String... args) throws Exception {

		// Create a Scanner for user input
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Movie Management Menu:");
			System.out.println("1. Add a new movie");
			System.out.println("2. Update an existing movie");
			System.out.println("3. List all Action movie");
			System.out.println("4. List all Comedy movie");
			System.out.println("5. Delete a movie");
			System.out.println("6. Exit");
			System.out.print("Please select an option : ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
				case 1:
					// Option to add a new movie
					System.out.print("Enter movie title: ");
					String title = scanner.nextLine();
					System.out.print("Enter release year: ");
					int releaseYear = scanner.nextInt();
					scanner.nextLine(); // Consume the newline character
					System.out.print("Enter director: ");
					String director = scanner.nextLine();
					System.out.print("Enter duration (in minutes): ");
					int duration = scanner.nextInt();
					scanner.nextLine(); // Consume the newline character

					// Ask the user about the type of movie
					System.out.print("Is it a comedy or action movie? (c/a): ");
					String movieType = scanner.nextLine().toLowerCase();

					// Create a new Movie object based on the type
					Movie newMovie;
					if (movieType.equals("c")) {
						// Create a ComedyMovie
						ComedyMovie comedyMovie = new ComedyMovie();
						comedyMovie.setTitle(title);
						comedyMovie.setReleaseYear(releaseYear);
						comedyMovie.setDirector(director);
						comedyMovie.setDuration(duration);
						newMovie = comedyMovieRepository.save(comedyMovie);
					} else if (movieType.equals("a")) {
						// Create an ActionMovie
						ActionMovie actionMovie = new ActionMovie();
						actionMovie.setTitle(title);
						actionMovie.setReleaseYear(releaseYear);
						actionMovie.setDirector(director);
						actionMovie.setDuration(duration);
						newMovie = actionMovieRepository.save(actionMovie);
					} else {
						System.out.println("Invalid movie type. Movie not added.");
						break;
					}

					// Display a status message
					if (newMovie != null) {
						System.out.println("Movie added successfully. New movie ID: " + newMovie.getId());
					} else {
						System.out.println("Failed to add the movie.");
					}
					break;

				case 2:
					// Option to update an existing movie
					List<Movie> allMovies = movierepository1.findAll();

					if (allMovies.isEmpty()) {
						System.out.println("No movies found for updating.");
					} else {
						System.out.println("Select a movie to update:");

						for (int i = 0; i < allMovies.size(); i++) {
							Movie movie = allMovies.get(i);
							System.out.println(i + 1 + ". " + movie.getTitle() + " (" + movie.getReleaseYear() + ")");
						}

						System.out.print("Enter the number of the movie to update: ");
						int selectedIndex = scanner.nextInt();

						// Validate user input
						if (selectedIndex >= 1 && selectedIndex <= allMovies.size()) {
							// Get the selected movie
							Movie selectedMovie = allMovies.get(selectedIndex - 1);

							System.out.println("Updating movie: " + selectedMovie.getTitle());

							// Prompt the user for updated movie details
							System.out.print("Enter updated movie title: ");
							String updatedTitle = scanner.next();
							System.out.print("Enter updated release year: ");
							int updatedReleaseYear = scanner.nextInt();
							scanner.nextLine(); // Consume the newline character
							System.out.print("Enter updated director: ");
							String updatedDirector = scanner.nextLine();
							System.out.print("Enter updated duration (in minutes): ");
							int updatedDuration = scanner.nextInt();
							scanner.nextLine(); // Consume the newline character

							// Update the selected movie with the new details
							selectedMovie.setTitle(updatedTitle);
							selectedMovie.setReleaseYear(updatedReleaseYear);
							selectedMovie.setDirector(updatedDirector);
							selectedMovie.setDuration(updatedDuration);

							// Save the updated movie to the database using the MovieRepository
							Movie updatedMovie = movierepository1.save(selectedMovie);

							// Display a status message
							if (updatedMovie != null) {
								System.out.println("Movie updated successfully.");
							} else {
								System.out.println("Failed to update the movie.");
							}
						} else {
							System.out.println("Invalid selection. Movie not updated.");
						}
					}
					break;

				case 3:
					// Option to list all action movies
					List<ActionMovie> actionMovies = actionMovieRepository.findAll();
					if (!actionMovies.isEmpty()) {
						System.out.println("List of Action Movies:");
						for (ActionMovie actionMovie : actionMovies) {
							System.out.println(actionMovie.getTitle() + " (" + actionMovie.getReleaseYear() + ")");
						}
					} else {
						System.out.println("No action movies found.");
					}
					break;

				case 4:
					// Option to list all comedy movies
					List<ComedyMovie> comedyMovies = comedyMovieRepository.findAll();
					if (!comedyMovies.isEmpty()) {
						System.out.println("List of Comedy Movies:");
						for (ComedyMovie comedyMovie : comedyMovies) {
							System.out.println(comedyMovie.getTitle() + " (" + comedyMovie.getReleaseYear() + ")");
						}
					} else {
						System.out.println("No comedy movies found.");
					}
					break;
				case 5:
					// Option to delete an existing movie
					List<Movie> allMovies1 = movierepository1.findAll();

					if (allMovies1.isEmpty()) {
						System.out.println("No movies found for deletion.");
					} else {
						System.out.println("Select a movie to delete:");

						for (int i = 0; i < allMovies1.size(); i++) {
							Movie movie = allMovies1.get(i);
							System.out.println(i + 1 + ". " + movie.getTitle() + " (" + movie.getReleaseYear() + ")");
						}

						System.out.print("Enter the number of the movie to delete: ");
						int selectedIndex = scanner.nextInt();

						// Validate user input
						if (selectedIndex >= 1 && selectedIndex <= allMovies1.size()) {
							// Get the selected movie
							Movie selectedMovie = allMovies1.get(selectedIndex - 1);

							System.out.println("Deleting movie: " + selectedMovie.getTitle());

							// Ask for confirmation
							System.out.print("Are you sure you want to delete this movie? (y/n): ");
							String confirmation = scanner.next();

							if (confirmation.equalsIgnoreCase("y")) {
								// Delete the selected movie from the database using the MovieRepository
								movierepository1.delete(selectedMovie);
								System.out.println("Movie deleted successfully.");
							} else {
								System.out.println("Movie not deleted.");
							}
						} else {
							System.out.println("Invalid selection. Movie not deleted.");
						}
					}
					break;

				case 6:
					// Option to exit the program
					System.out.println("Exiting Movie Management System. Goodbye!");
					scanner.close();
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice. Please select a valid option (1/2/3).");
			}
		}
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200")
						.allowedMethods("*");
			}
		};
	}
}
