import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OntimizeWebModule } from "ontimize-web-ngx";
import { CandidatesRoutingModule } from './candidates-routing.module';
import { CandidatesHomeComponent } from './candidates-home/candidates-home.component';
import { CandidatesDetailComponent } from './candidates-detail/candidates-detail.component';

@NgModule({
  imports: [
    CommonModule,
    OntimizeWebModule,
    CandidatesRoutingModule
  ],
  declarations: [CandidatesHomeComponent, CandidatesDetailComponent]
})
export class CandidatesModule { }
