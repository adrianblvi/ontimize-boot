import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CandidatesHomeComponent } from './candidates-home/candidates-home.component';
const routes: Routes = [
  {
    path: '',
    component: CandidatesHomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CandidatesRoutingModule { }
