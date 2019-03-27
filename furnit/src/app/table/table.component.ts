import {Component} from '@angular/core';
import { TableService } from './table.service';
import {allData, cateData} from "./tabledata";


@Component({
  selector: 'TableComponent',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],
  providers:[TableService]
})

export class TableComponent {
  displayedColumns: string[] = ['name', 'price','categories',];
  dataSource : allData[];
  categories: cateData[];
  selectedcate1: string ;
  selectedcate2:string = 'select all';
  public POFranchise;

  constructor(public TableService:TableService){}
  ngOnInit(){

    this.TableService.getalldata(this.selectedcate1,this.selectedcate2).subscribe((data:Array<allData>) => {
      console.log(data);
      this.dataSource = data;
    });
    this.TableService.getcategories().subscribe((data: Array<cateData>)=>{
      this.categories = data;
    });

  }
  fetchFilterData(){
    this.TableService.getalldata(this.selectedcate1,this.selectedcate2).subscribe((data:Array<allData>) => {
      console.log(data);
      this.dataSource = data;
    });
  }
  }

