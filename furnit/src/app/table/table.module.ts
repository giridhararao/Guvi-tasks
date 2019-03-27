import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {TableComponent} from './table.component
@NgModule({
  declarations: [TableComponent],
  imports: [
    RouterModule.forChild([{ path: '**', component: TableComponent }])
  ]
})
export class TableModule { }
