import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CandidatesHomeComponent } from './candidates-home/candidates-home.component';
import { CandidatesDetailComponent } from './candidates-detail/candidates-detail.component';
import { CandidatesDetailCvComponent } from "./candidates-detail-cv/candidates-detail-cv.component";
import { CandidatesNewComponent } from './candidates-new/candidates-new.component';
const routes: Routes = [
  {
    path: '',
    component: CandidatesHomeComponent
  }, {
    path: "new",
    component: CandidatesNewComponent
  }, {
    path: ":ID/curriculum/:ID_CANDIDATE",
    component: CandidatesDetailCvComponent
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
