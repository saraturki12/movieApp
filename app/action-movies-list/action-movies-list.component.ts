import { Component, OnInit } from '@angular/core';
import { MovieService } from '../services/movie.service';
import { Movie } from '../models/movie.model';
import { MovieCardComponent } from '../components/movie-card/movie-card.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-action-movies-list',
  templateUrl: './action-movies-list.component.html',
  styleUrls: ['./action-movies-list.component.css'],
  imports: [MovieCardComponent, CommonModule],
  standalone: true,
})
export class ActionMoviesListComponent implements OnInit {
  actionMovies: Movie[] | undefined;

  constructor(private movieService: MovieService) {}

  ngOnInit(): void {
    this.getMoviesByGenre('Action');
  }

  getMoviesByGenre(genre: string): void {
    this.movieService.getMoviesByGenre(genre).subscribe(
      (movies) => {
        this.actionMovies = movies;
      },
      (error) => {
        console.error('Error fetching action movies', error);
      }
    );
  }
}
