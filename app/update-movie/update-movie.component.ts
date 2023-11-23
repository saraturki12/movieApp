import { Component, OnInit, inject } from '@angular/core';
import { MovieService } from '../services/movie.service';
import { Movie } from '../models/movie.model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-movie',
  templateUrl: './update-movie.component.html',
  styleUrls: ['./update-movie.component.css'],
})
export class UpdateMovieComponent implements OnInit {
  newMovie: Movie = {
    id: 0,
    title: '',
    genre: '',
    releaseYear: 0,
    duration: 0,
  };
  err = '';

  constructor(private movieService: MovieService) {}
  ngOnInit(): void {
    const movieId = this.router.snapshot.params['id'];
    this.newMovie = { ...this.newMovie, id: Number(movieId) };
    this.movieService.getMovie(Number(movieId)).subscribe({
      next: (res) => {
        console.log(res);
        this.newMovie = res;
      },
      error: (err) => {
        console.log(err);
      },
    });
    // throw new Error('Method not implemented.');
  }
  router = inject(ActivatedRoute);
  updateMovie(): void {
    this.movieService.updateMovie(this.newMovie).subscribe({
      next: (response) => {
        console.log('Movie edit successfully', response);
        // Optionally, you can navigate to another component after adding the movie
      },
      error: (error) => {
        console.error('Error adding movie', error);
      },
    });
  }
}
