import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from '../models/movie.model';

@Injectable({
  providedIn: 'root',
})
export class MovieService {
  private apiUrl = 'http://localhost:8081/api/movies';

  http = inject(HttpClient);
  // constructor(private http: HttpClient) { }

  addMovie(newMovie: Movie): Observable<Movie> {
    return this.http.post<Movie>(this.apiUrl, newMovie);
  }

  updateMovie(updateData: Movie): Observable<Movie> {
    const updateUrl = `${this.apiUrl}/${updateData.id}`;
    return this.http.put<Movie>(updateUrl, updateData);
  }

  deleteMovie(movieId: number): Observable<void> {
    const deleteUrl = `${this.apiUrl}/${movieId}`;
    return this.http.delete<void>(deleteUrl);
  }

  getMoviesByGenre(genre: string): Observable<Movie[]> {
    const genreUrl = `${this.apiUrl}?genre=${genre}`;
    return this.http.get<Movie[]>(genreUrl);
  }
  getMovie(id: number): Observable<Movie> {
    const genreUrl = `${this.apiUrl}/${id}`;
    return this.http.get<Movie>(genreUrl);
  }
}
