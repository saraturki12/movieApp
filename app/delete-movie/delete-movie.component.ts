import { Component } from '@angular/core';
import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-delete-movie',
  templateUrl: './delete-movie.component.html',
  styleUrls: ['./delete-movie.component.css']
})
export class DeleteMovieComponent {
  movieIdToDelete: number | undefined;
  deletionMessage: string | undefined;

  constructor(private movieService: MovieService) { }

  deleteMovie(): void {
    if (this.movieIdToDelete) {
      this.movieService.deleteMovie(this.movieIdToDelete)
        .subscribe(
          () => {
            this.deletionMessage = `Movie with ID ${this.movieIdToDelete} deleted successfully.`;
            this.movieIdToDelete = undefined;
          },
          (error) => {
            console.error('Error deleting movie', error);
            this.deletionMessage = `Error deleting movie with ID ${this.movieIdToDelete}.`;
          }
        );
    }
  }
}
