import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CandidatesHomeComponent } from './candidates-home/candidates-home.component';
import { CandidatesDetailComponent } from './candidates-detail/candidates-detail.component';
const routes: Routes = [
  {
    path: '',
    component: CandidatesHomeComponent
  },
  {
    path: ":ID",
    component: CandidatesDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CandidatesRoutingModule { }
