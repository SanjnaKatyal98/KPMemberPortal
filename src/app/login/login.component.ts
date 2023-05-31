import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  loginForm!:FormGroup;
  ngOnInit(): void {}
  constructor(private router:Router,private fb:FormBuilder,private login:LoginService){
    this.loginForm=this.fb.group({
      username:['',[Validators.required,Validators.minLength(3)]],
      password:['',[Validators.required,Validators.minLength(3)]]
    });
  }

  //two way data binding
  credentials={
    username: '',
    password: '',
  };

  onSubmit(){
    if(!this.loginForm.valid)
      return;
    console.log(this.loginForm.value);
    //request to server to generate token
    this.login.generateToken(this.credentials).subscribe(
      (data:any)=>{
        console.log("success");
        console.log(data);
        //login
        this.login.loginUser(data.token);
        this.login.getCurrentUser().subscribe((user: any) => {
          this.login.setUser(user);
          console.log(user);
          //redirect to ADMIN dashboard
          if(this.login.getUserRole() == "ADMIN"){
            alert('Welcome!');
            this.router.navigate(['admin']);
            this.login.loginStatusSubject.next(true);
          }
          //redirect to NORMAL user dashboard
          else if(this.login.getUserRole() == "NORMAL"){
            alert('login successful!');
            this.router.navigate(['caregiver']);
            this.login.loginStatusSubject.next(true);
          }
          else{
            this.login.logout();
          }
        });
      },
      (err)=>{
        console.log("error!");
        console.log(err);
      }
    );
    alert('successfull!!');
    this.router.navigate(['caregiver']);
  }

  //in reactive form we hv to manually get the value
  get username(){
    return this.loginForm.get("username");
  }
  get password(){
    return this.loginForm.get("password");
  }

  //will clear all fields
  reset(){
    this.loginForm.reset();
  }
  
  //navigate back
  back(){
    console.log('no changes made');
    this.router.navigate(['home']);
  }
  
  //navigate forward
  reg(){
    console.log('new user');
    this.router.navigate(['register']);
  }
}