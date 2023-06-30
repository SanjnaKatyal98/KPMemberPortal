import { ComponentFixture, TestBed } from '@angular/core/testing';
import { LoginComponent } from './login.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { By } from '@angular/platform-browser';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports: [
        RouterTestingModule,HttpClientTestingModule,FormsModule,ReactiveFormsModule
      ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  //TEST CASES
  it('should have type text for username', () => {
    const element=fixture.debugElement.query(By.css('#username'));
    expect(element.nativeElement.getAttribute('type')).toEqual('text');
  });
  it('should have type password for password', () => {
    const element=fixture.debugElement.query(By.css('#password'));
    expect(element.nativeElement.getAttribute('type')).toEqual('password');
  });
  it('should check username is there or not',()=>{
    const element = fixture.debugElement.query(By.css('#username'));
    expect(element.nativeElement.getAttribute('type')).toEqual('text');
  });
  it('should check username type is text or not',()=>{
     const element = fixture.debugElement.query(By.css('#username'));
    expect(element.nativeElement.getAttribute('type')).toEqual('text');
  });
  it('should check name is of username ',()=>{
    const element = fixture.debugElement.query(By.css('#username'));
    expect(element.nativeElement.getAttribute('name')).toEqual('username'); 
  });
  it('should check password is there or not',()=>{
    const element = fixture.debugElement.query(By.css('#pass'));
    expect(element.nativeElement.getAttribute('type')).toEqual('password');
  });
  it('should check name is of password ',()=>{
    const element = fixture.debugElement.query(By.css('#pass'));
    expect(element.nativeElement.getAttribute('name')).toEqual('password');
  });
  it('should check password type is text or not',()=>{
    const element = fixture.debugElement.query(By.css('#pass'));
    expect(element.nativeElement.getAttribute('type')).toEqual('password');
  });
  it('should have the submit button',()=>{
    const element = fixture.debugElement.query(By.css('#bttn'));
    expect(element.nativeElement.getAttribute('button')).toEqual('button');
  });
  it('should check input type of login button',()=>{
    const login = fixture.debugElement.query(By.css('#login'));
    const login1= login.nativeElement.getAttribute('type');
    expect(login1).toEqual('Submit'); 
  });

});
