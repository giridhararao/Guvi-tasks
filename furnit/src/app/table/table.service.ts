
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import {Observable} from "rxjs/index";
import { alldata } from './tabledata';
@Injectable()

export class TableService {

  constructor(private http: HttpClient) {
  }

  public getalldata(selectedcate1: string,selectedcate2:string) {
    let _params: HttpParams = new HttpParams();
    _params = _params.append('category1', "" + selectedcate1);
    _params = _params.append('category2', ""+selectedcate2);
    return this.http.get('/mainpath/alldata', {params: _params});
  }
  public getcategories(){
    return this.http.get('/mainpath/categories');
  }

}
