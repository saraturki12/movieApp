import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieManagementMenuComponent } from './movie-management-menu.component';

describe('MovieManagementMenuComponent', () => {
  let component: MovieManagementMenuComponent;
  let fixture: ComponentFixture<MovieManagementMenuComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MovieManagementMenuComponent]
    });
    fixture = TestBed.createComponent(MovieManagementMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
