import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  title = 'web';

  ngOnInit(): void {
    var myChild= window.open('http://localhost:8080/','','width=1px,height=1px,resizable=no');  
    myChild.document.write("<p>PLEASE DO NOT CLOSE THIS PAGE!</p>");
    myChild.blur();
  }
}
