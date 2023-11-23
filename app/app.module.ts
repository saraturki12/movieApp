import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MovieManagementMenuComponent } from './movie-management-menu/movie-management-menu.component';
import { AddMovieComponent } from './add-movie/add-movie.component';
import { ActionMoviesListComponent } from './action-movies-list/action-movies-list.component';
import { ComedyMoviesListComponent } from './comedy-movies-list/comedy-movies-list.component';
import { DeleteMovieComponent } from './delete-movie/delete-movie.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ActivatedRoute, RouterLinkActive } from '@angular/router';
import { MovieCardComponent } from './components/movie-card/movie-card.component';
import { UpdateMovieComponent } from './update-movie/update-movie.component';

@NgModule({
  declarations: [
    AppComponent,
    MovieManagementMenuComponent,
    AddMovieComponent,
    // ActionMoviesListComponent,
    // ComedyMoviesListComponent,
    DeleteMovieComponent,
    UpdateMovieComponent,
    // MovieCardComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterLinkActive,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
