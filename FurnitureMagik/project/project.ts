import {Component} from '@angular/core';
import {projectservice} from './projectservice';
import {allData, cateData} from "./projectdata";


@Component({
  selector: 'project',
  templateUrl: './project.html',
  styleUrls: ['./project.scss'],
  providers:[projectservice]
})

export class project {
  displayedColumns: string[] = ['name', 'price','categories',];
  dataSource : allData[];
  categories: cateData[];
  selectedcate1: string ;
  selectedcate2:string = 'select all';
  public POFranchise;

  constructor(public poFranchiseControlServ:PoFranchiseControlService, public uiCommonServ: UiCommonService){}
  ngOnInit(){

    this.projectserv.getalldata(this.selectedcate1,this.selectedcate2).subscribe((data:Array<allData>) => {
      console.log(data.data);
      this.dataSource = data.data;
    });
    this.projectserv.getcategories().subscribe((data: Array<cateData>)=>{
      this.categories = data.data;
    });

  }
  fetchFilterData(){
    this.poFranchiseControlServ.getPoFranchiseOutletStatus(this.selectedcate1,this.selectedcate2).subscribe((data:Array<allData>) => {
      console.log(data.data);
      this.dataSource = data.data;
    });
  }
  }


