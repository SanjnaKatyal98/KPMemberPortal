import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { caregiverList } from './caregiverList';
import { CaregiverService } from '../services/caregiver.service';

@Component({
  selector: 'app-caregiver',
  templateUrl: './caregiver.component.html',
  styleUrls: ['./caregiver.component.css']
})
export class CaregiverComponent implements OnInit{
  title="caregiver";

  //initialisation
  searchText!:string;//for searching all
  cglist:caregiverList[]=[];

  /*cglist:caregiverList[]=[{
    id:1,
    firstname:"Taylor",
    lastname:"Swift",
    username:"swiftiw13"
  },{
    id:2,
    firstname:"Selena",
    lastname:"Gomez",
    username:"selenator"
  },{
    id:3,
    firstname:"Ed",
    lastname:"Sheeran",
    username:"eddie"
  },{
    id:4,
    firstname:"Ariana",
    lastname:"Grande",
    username:"ari0"
  }];*/

  ngOnInit(): void {
    this.listCare();
  }
  constructor(private router:Router,private serv:CaregiverService){}

  listCare() {
    this.serv.getCare().subscribe(
      data => this.cglist = data
    );
  }

  //function defination
  back(){
    alert('are you sure?');
    console.log('no changes made');
    this.router.navigate(['login']);
  }

  //for assigning user caregiver
  assignC(){
    console.log('assigning caregiver');
    this.router.navigate(['assignCg']);
  }
}