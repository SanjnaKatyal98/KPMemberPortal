import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit{

  title="Admin";

  ngOnInit(): void {}
  constructor(private router:Router){}

  back(){
    console.log('no changes made');
    this.router.navigate(['home']);
  }
}