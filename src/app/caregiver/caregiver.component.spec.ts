import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CaregiverComponent } from './caregiver.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { By } from '@angular/platform-browser';

describe('CaregiverComponent', () => {
  let component: CaregiverComponent;
  let fixture: ComponentFixture<CaregiverComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CaregiverComponent ],
      imports: [
        RouterTestingModule,HttpClientTestingModule,FormsModule,ReactiveFormsModule
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CaregiverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  //test case
  it('should have as title `caregiver`', () => {
    const fixture = TestBed.createComponent(CaregiverComponent);
    const app = fixture.componentInstance;
    expect(app.title).toContain('caregiver');
  });
});
