import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AssignCaregiverComponent } from './assign-caregiver.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { By } from '@angular/platform-browser';

describe('AssignCaregiverComponent', () => {
  let component: AssignCaregiverComponent;
  let fixture: ComponentFixture<AssignCaregiverComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssignCaregiverComponent ],
      imports: [
        RouterTestingModule,HttpClientTestingModule,FormsModule,ReactiveFormsModule
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AssignCaregiverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  //test case
  it('should have type text for user id', () => {
    const element=fixture.debugElement.query(By.css('#uid'));
    expect(element.nativeElement.getAttribute('type')).toEqual('text');
  });
  it('should have type text for caregiver id', () => {
    const element=fixture.debugElement.query(By.css('#cid'));
    expect(element.nativeElement.getAttribute('type')).toEqual('text');
  });
  it('should have as title `assign caregiver`', () => {
    const fixture = TestBed.createComponent(AssignCaregiverComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('assign caregiver');
  });
});
