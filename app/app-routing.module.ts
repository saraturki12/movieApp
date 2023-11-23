import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MovieManagementMenuComponent } from './movie-management-menu/movie-management-menu.component';
import { AddMovieComponent } from './add-movie/add-movie.component';

import { ActionMoviesListComponent } from './action-movies-list/action-movies-list.component';
import { ComedyMoviesListComponent } from './comedy-movies-list/comedy-movies-list.component';
import { DeleteMovieComponent } from './delete-movie/delete-movie.component';
import { UpdateMovieComponent } from './update-movie/update-movie.component';

const routes: Routes = [
  { path: '', redirectTo: '/movie-menu', pathMatch: 'full' },
  { path: 'movie-menu', component: MovieManagementMenuComponent },
  { path: 'add-movie', component: AddMovieComponent },
  { path: 'update-movie/:id', component: UpdateMovieComponent },

  { path: 'action-movies', component: ActionMoviesListComponent },
  { path: 'comedy-movies', component: ComedyMoviesListComponent },
  { path: 'delete-movie', component: DeleteMovieComponent },
  { path: '**', redirectTo: '/movie-menu' }, // Handle invalid routes
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
