import { Component, OnInit, ViewChild, ElementRef, Input } from '@angular/core';
import { Messagedb } from './messagedb';
import { DashboardService } from './dashboard.service';
//import * as CanvasJS from '../../assets/canvasjs.min.js';
//import * as Plotly from 'plotly.js';
import { Observable } from 'rxjs/internal/Observable';
//import {Config, Data, Layout} from 'plotly.js';
import  {Chart} from 'chart.js';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
  providers:[DatePipe]
})
export class DashboardComponent implements OnInit{

  title = 'dashboard';
  chart = [];
  istanbulPoints = []; 
  moscowPoints = [];
  tokyoPoints = [];
  beijingPoints = [];
  londonPoints = [];
  messages: Messagedb[];

  istanbulCounter: number;
  tokyoCounter: number;
  moscowCounter: number;
  beijingCounter: number;
  londonCounter: number;

  myDate = new Date();
  date:string;
  dates = []
  
  constructor(private dashboardService: DashboardService, private datePipe: DatePipe){ 
    this.date = this.datePipe.transform(this.myDate, 'h:mm');
    this.dates.push(this.date);
  }

	ngOnInit() { 
    this.dashboardService.getDashboardMessage().subscribe(data=>{
     this.messages = data;

     console.log(data);
     console.log(this.date);

     this.istanbulCounter=0;
     this.tokyoCounter=0;
     this.moscowCounter=0;
     this.beijingCounter=0;
     this.londonCounter=0;

     data.forEach(x => {
     var city = x.cityName; 

      switch(city){
        case "Istanbul":{
         this.istanbulCounter++;
         break;
        }
        case "Tokyo":{
         this.tokyoCounter++;
         break;
        }
        case "Moscow":{
         this.moscowCounter++;
         break;
        }
        case "Beijing":{
         this.beijingCounter++;
         break;
        }
        case "London":{
         this.londonCounter++;
         break;
        }
      }
    });

    console.log(this.istanbulCounter);
    console.log(this.tokyoCounter);
    console.log(this.moscowCounter);
    console.log(this.beijingCounter);
    console.log(this.londonCounter);

    this.istanbulPoints.push(this.istanbulCounter);
    this.moscowPoints.push(this.moscowCounter);
    this.tokyoPoints.push(this.tokyoCounter);
    this.beijingPoints.push(this.beijingCounter);
    this.londonPoints.push(this.londonCounter);

    console.log("İstanbul Points:" + this.istanbulPoints);
    console.log("Tokyo Points:" + this.tokyoPoints);
    console.log("Moscow Points:" + this.moscowPoints);
    console.log("Beijing Points:" + this.beijingPoints);
    console.log("London Points:" + this.londonPoints);


    this.chart = new Chart('canvas',{
      type: 'line',
      data:{
        labels:['1', '2', '3', '4', '5', '6', '7', '8', '9', '10'],
        datasets:[
          {
            label: 'İSTANBUL',
            data: this.istanbulPoints,
            backgroundColor:'red',
            borderColor:'red',
            fill:false,
          },
          {
            label: 'TOKYO',
            data: this.tokyoPoints,
            backgroundColor:'blue',
            borderColor:'blue',
            fill:false,
          },
          {
            label: 'MOSCOW',
            data: this.moscowPoints,
            backgroundColor:'pink',
            borderColor:'pink',
            fill:false,
          },
          {
            label: 'BEIJING',
            data: this.beijingPoints,
            backgroundColor:'green',
            borderColor:'green',
            fill:false,
          },
          {
            label: 'LONDON',
            data: this.londonPoints,
            backgroundColor:'yellow',
            borderColor:'yellow',
            fill:false,
          }
        ]
      }
    })
   });
  }    

  onClickMe(){
    window.location.reload();
  }
}


