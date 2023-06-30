import { TestBed } from '@angular/core/testing';
import { NormalGuard } from './normal.guard';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';

describe('NormalGuard', () => {
  let guard: NormalGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,HttpClientTestingModule,FormsModule,ReactiveFormsModule
      ]
    });
    guard = TestBed.inject(NormalGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
