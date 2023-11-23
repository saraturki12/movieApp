import { CommonModule } from '@angular/common';
import { Component, Input, inject } from '@angular/core';
import { Router } from '@angular/router';
import { MovieService } from 'src/app/services/movie.service';

@Component({
  selector: 'app-movie-card',
  templateUrl: './movie-card.component.html',
  styleUrls: ['./movie-card.component.css'],
  standalone: true,
  imports: [CommonModule],
})
export class MovieCardComponent {
  @Input() title = '';
  @Input() releaseYear = '';
  @Input() duration = '';
  @Input() id = '';
  moviesService = inject(MovieService);
  router = inject(Router);
  onDelete() {
    // Handle delete logic here
    console.log('Delete clicked');
    this.moviesService.deleteMovie(Number(this.id)).subscribe({
      next: (res) => {
        window.location.reload();
      },
    });
  }

  onEdit() {
    // Handle edit logic here
    console.log(this.id);

    this.router.navigateByUrl(`/update-movie/${this.id}`);
    console.log('Edit clicked');
  }
}
