import { Injectable } from "@angular/core";
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { HttpClient } from '@angular/common/http';
import { LocationModel } from '../../models/location.model';


@Injectable({ providedIn: 'root' })

export class AlertFormService {

location!: LocationModel;
  constructor(private modalService: NgbModal, private http: HttpClient) { }

  openAlertModal(comp: any) {
    const modalRef = this.modalService.open(comp);

    modalRef.result.then((result) => {
      result
     // console.log(result);
    }).catch((error) => {
      error
      // console.log(error);
    });
  }

  sendData(){
   this.http.put('http://localhost:8080/points', this.location ).subscribe(results => { console.log(results)})
  }
}
