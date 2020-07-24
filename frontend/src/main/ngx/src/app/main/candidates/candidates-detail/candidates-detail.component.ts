import { Component, OnInit, ViewChild } from '@angular/core';
import { OTextInputComponent } from 'ontimize-web-ngx';

@Component({
  selector: 'app-candidates-detail',
  templateUrl: './candidates-detail.component.html',
  styleUrls: ['./candidates-detail.component.scss']
})
export class CandidatesDetailComponent implements OnInit {

  constructor() {
  }
  ngAfterContentChecked():void{
    this.id = this.idcurriculum.getValue()
  }
  @ViewChild('ids') idcurriculum: OTextInputComponent
  id: string
  ngOnInit() {
  }

}
