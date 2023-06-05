import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-assign-caregiver',
  templateUrl: './assign-caregiver.component.html',
  styleUrls: ['./assign-caregiver.component.css']
})
export class AssignCaregiverComponent implements OnInit{
  ngOnInit(): void {}
  constructor(private router:Router){}

  onSubmit(acgForm:NgForm){
    alert('caregiver assigned successfully!');
    console.log('success');
    console.log(acgForm.value);
    this.router.navigate(['home']);
  }
  
  reset(acgForm:NgForm){
    acgForm.resetForm();
  }
  
  back(){
    console.log('no changes made');
    this.router.navigate(['caregiver']);
  }
}