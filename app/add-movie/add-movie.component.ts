import { Component } from '@angular/core';
import { MovieService } from '../services/movie.service';
import { Movie } from '../models/movie.model';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css'],
})
export class AddMovieComponent {
  newMovie: Movie = {
    id: 0,
    title: '',
    genre: '',
    releaseYear: 0,
    duration: 0,
  };

  constructor(private movieService: MovieService) {}

  addMovie(): void {
    this.movieService.addMovie(this.newMovie).subscribe({
      next: (response) => {
        console.log('Movie added successfully', response);
        // Optionally, you can navigate to another component after adding the movie
      },
      error: (error) => {
        console.error('Error adding movie', error);
      },
    });
  }
}
