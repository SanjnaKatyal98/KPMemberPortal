import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';//router helps to navigate between pages

@Component({
  selector: 'app-page-not-found',
  templateUrl: './page-not-found.component.html',
  styleUrls: ['./page-not-found.component.css']
})
export class PageNotFoundComponent implements OnInit{
  constructor(private router:Router){}

  //for going back to valid page
  back(){
    this.router.navigate(['home']);
  }

  ngOnInit(): void {}
}