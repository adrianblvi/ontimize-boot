import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuardService } from 'ontimize-web-ngx';

import { MainComponent } from './main.component';
import { HomeModule } from './home/home.module';
import { CandidatesModule } from "./candidates/candidates.module";
import { OffersModule } from './offers/offers.module';


export function loadHomeModule() {
  return HomeModule;
}
export function loadCandidatesModule() {
  return CandidatesModule;
}

export function loadOffersModule() {
  return OffersModule;
}

export const routes: Routes = [
  {
    path: '',
    component: MainComponent,
    canActivate: [AuthGuardService],
    children: [
      { path: '', redirectTo: 'home', pathMatch: 'full' },
      {
        path: 'home',
        loadChildren: loadHomeModule
      },
      {
        path: 'candidates',
        loadChildren: loadCandidatesModule
      },
      {
        path: 'offers',
        loadChildren: loadOffersModule
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainRoutingModule { }
