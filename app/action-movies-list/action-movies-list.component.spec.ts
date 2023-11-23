import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActionMoviesListComponent } from './action-movies-list.component';

describe('ActionMoviesListComponent', () => {
  let component: ActionMoviesListComponent;
  let fixture: ComponentFixture<ActionMoviesListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ActionMoviesListComponent]
    });
    fixture = TestBed.createComponent(ActionMoviesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
