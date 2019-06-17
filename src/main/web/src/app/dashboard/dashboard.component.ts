import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Messagedb } from './messagedb';
import { DashboardService } from './dashboard.service';
import { DatePipe } from '@angular/common';
import * as CanvasJS from '../../assets/canvasjs.min.js';
import * as Plotly from 'plotly.js';
//import {Config, Data, Layout} from 'plotly.js';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
  providers:[DatePipe]
})
export class DashboardComponent implements OnInit{

  messages: Messagedb[];
  istanbulCounter: number;
  tokyoCounter: number;
  moscowCounter: number;
  beijingCounter: number;
  londonCounter: number;

  date= Date();
  constructor(private dashboardService: DashboardService, private datePipe: DatePipe){
    this.date = this.datePipe.transform(this.date, 'h:mm');
  }
	ngOnInit() {
   this.dashboardService.getDashboardMessage().subscribe(data=>{
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
    console.log(this.date);

  ////ISTANBUL
    let dataPoints = [];
    let dpsLength = 0;
    let dPoint = this.istanbulCounter;
    var i=0;

    let chart = new CanvasJS.Chart("chartContainer",{
      exportEnabled: true,
      title:{
        text:"This dashboard shows us how many logs are coming from İSTANBUL"
      },
      data: [{
        type: "spline",
        dataPoints : dataPoints
      }]
    });

      dataPoints.push({x: i, y: dPoint});
      dpsLength = dataPoints.length;
      chart.render();
      updateChart(); 
        
    function updateChart(){
          //window.location.reload();
          dataPoints.push({x: i, y: dPoint});
          i++;
          dpsLength++;
          if (dataPoints.length >  20) {
            dataPoints.shift();			
          }
      chart.render();
      setTimeout(function(){updateChart()}, 5000);
    }
   });
  }    

  onClickMe(){
    window.location.reload();
  }
}


