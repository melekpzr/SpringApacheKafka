import { Component, OnInit, ViewChild, ElementRef, Input } from '@angular/core';
import { Messagedb } from './messagedb';
import { DashboardService } from './dashboard.service';
import { Observable } from 'rxjs/internal/Observable';
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
  istanbulPoints = [0]; 
  moscowPoints = [0];
  tokyoPoints = [0];
  beijingPoints = [0];
  londonPoints = [0];
  messages: Messagedb[];

  istanbulCounter: number;
  tokyoCounter: number;
  moscowCounter: number;
  beijingCounter: number;
  londonCounter: number;
  
  date:string;
  dates = [];
  
  constructor(private dashboardService: DashboardService, private datePipe: DatePipe){ 

  }

	ngOnInit() { 

    var intervalLoop = setInterval (() => {
      this.dashboardService.getDashboardMessage().subscribe(data => {
      this.messages = data;
      console.log(data);

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

    this.date = this.datePipe.transform(new Date, 'h:mm:ss');
    
    this.dates.push(this.date);
    this.istanbulPoints.push(this.istanbulCounter);
    this.moscowPoints.push(this.moscowCounter);
    this.tokyoPoints.push(this.tokyoCounter);
    this.beijingPoints.push(this.beijingCounter);
    this.londonPoints.push(this.londonCounter);

    console.log(this.istanbulPoints.length);
    console.log(this.dates.length);
    console.log("DATES: " + this.dates);
    if(this.istanbulPoints.length >10){
       this.istanbulPoints.shift();
       this.moscowPoints.shift();
       this.tokyoPoints.shift();
       this.beijingPoints.shift();
       this.londonPoints.shift();
       if(this.dates.length >10){
       this.dates.shift();
       }
    }
    console.log("İstanbul Points:" + this.istanbulPoints);
    console.log("Tokyo Points:" + this.tokyoPoints);
    console.log("Moscow Points:" + this.moscowPoints);
    console.log("Beijing Points:" + this.beijingPoints);
    console.log("London Points:" + this.londonPoints);

    this.chart = new Chart('canvas',{
      type: 'line',
      data:{
        labels:this.dates,
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
      })
  }, 10000);
}   

  onClickMe(){
    window.location.reload();
  }
}


