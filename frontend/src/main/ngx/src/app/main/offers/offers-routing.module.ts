import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OffersHomeComponent } from "./offers-home/offers-home.component";
import { OffersDetailComponent } from './offers-detail/offers-detail.component';


const routes: Routes = [
  {
    path: '',
    component: OffersHomeComponent
  },{
    path:':ID',
    component: OffersDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OffersRoutingModule { }
