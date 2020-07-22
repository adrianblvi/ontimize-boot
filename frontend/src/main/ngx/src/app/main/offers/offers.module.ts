import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OntimizeWebModule } from "ontimize-web-ngx";
import { OffersRoutingModule } from './offers-routing.module';
import { OffersHomeComponent } from './offers-home/offers-home.component';

@NgModule({
  imports: [
    CommonModule,
    OntimizeWebModule,
    OffersRoutingModule,
  ],
  declarations: [OffersHomeComponent]
})
export class OffersModule { }
