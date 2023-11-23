import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComedyMoviesListComponent } from './comedy-movies-list.component';

describe('ComedyMoviesListComponent', () => {
  let component: ComedyMoviesListComponent;
  let fixture: ComponentFixture<ComedyMoviesListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ComedyMoviesListComponent],
    });
    fixture = TestBed.createComponent(ComedyMoviesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
