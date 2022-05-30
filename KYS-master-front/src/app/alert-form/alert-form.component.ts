import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { LocationModel } from 'src/models/location.model';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-alert-form',
  templateUrl: './alert-form.component.html',
  styleUrls: ['./alert-form.component.css']
})
export class AlertFormComponent implements OnInit {

  constructor(public activeModal: NgbActiveModal, public http: HttpClient) { }

  ngOnInit(): void {
  }
  location = new LocationModel()

  colors: string[] = [
    "Seguro",
    "Peligroso"
  ]

  onSubmit(alertForm:any){
    console.log(alertForm.value);
    this.http.put('http://localhost:8080/points', alertForm.value).subscribe(res => (console.log(res))
    )
  }

  closeModal() {
    this.activeModal.close();
  }
}
