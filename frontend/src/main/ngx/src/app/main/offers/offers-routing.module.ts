import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OffersHomeComponent } from "./offers-home/offers-home.component";


const routes: Routes = [
  {
    path: '',
    component: OffersHomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OffersRoutingModule { }
