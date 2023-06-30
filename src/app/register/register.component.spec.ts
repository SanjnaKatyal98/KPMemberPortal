import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RegisterComponent } from './register.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { By } from '@angular/platform-browser';

describe('RegisterComponent', () => {
  let component: RegisterComponent;
  let fixture: ComponentFixture<RegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterComponent ],
      imports: [
        RouterTestingModule,HttpClientTestingModule,FormsModule,ReactiveFormsModule
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  //test cases
  it('should have password type of password', () => {
    const element=fixture.debugElement.query(By.css('#pass'));
    expect(element.nativeElement.getAttribute('type')).toEqual('password');
  });
  it('should have username type of email ', () => {
    const element=fixture.debugElement.query(By.css('#id'));
    expect(element.nativeElement.getAttribute('type')).toEqual('email');
  });
  it('should have firstname type of text', () => {
    const element=fixture.debugElement.query(By.css('#firstname'));
    expect(element.nativeElement.getAttribute('type')).toEqual('text');
  });
  it('should have lastname type of text', () => {
    const element=fixture.debugElement.query(By.css('#lastname'));
    expect(element.nativeElement.getAttribute('type')).toEqual('text');
  });
});
