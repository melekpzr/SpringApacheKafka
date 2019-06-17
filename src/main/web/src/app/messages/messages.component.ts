import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort, MatTable } from '@angular/material';
import { MessagesDataSource} from './messages-datasource';
import { MessagesService } from './messages.service';
import { Messagedb } from './messagedb';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.scss']
})
export class MessagesComponent implements AfterViewInit, OnInit {
  @ViewChild(MatPaginator, {static:true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static:true}) sort: MatSort;
  @ViewChild(MatTable, {static:true}) table: MatTable<Messagedb>;
  dataSource: MessagesDataSource;
  
  constructor(private messagesService: MessagesService) {   
  }

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['timestamp','level', 'cityName', 'message'];

  ngOnInit() {
    this.dataSource = new MessagesDataSource(this.messagesService);
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.table.dataSource = this.dataSource;
  }
  onClickMe(){
    window.location.reload();
  }
}


