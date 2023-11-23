import { Component, OnInit } from '@angular/core';
import { MovieService } from '../services/movie.service';
import { Movie } from '../models/movie.model';
import { CommonModule } from '@angular/common';
import { MovieCardComponent } from '../components/movie-card/movie-card.component';

@Component({
  selector: 'app-comedy-movies-list',
  templateUrl: './comedy-movies-list.component.html',
  styleUrls: ['./comedy-movies-list.component.css'],
  standalone: true,
  imports: [CommonModule, MovieCardComponent],
})
export class ComedyMoviesListComponent implements OnInit {
  comedyMovies: Movie[] | undefined;

  constructor(private movieService: MovieService) {}

  ngOnInit(): void {
    this.getMoviesByGenre('Comedy');
  }

  getMoviesByGenre(genre: string): void {
    this.movieService.getMoviesByGenre(genre).subscribe({
      next: (movies) => {
        this.comedyMovies = movies;
      },
      error: (error) => {
        console.error('Error fetching comedy movies', error);
      },
    });
  }
}
