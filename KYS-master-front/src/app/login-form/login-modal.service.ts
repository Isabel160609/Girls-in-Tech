import { Injectable } from "@angular/core";
import { User } from "./user";
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';


@Injectable({ providedIn: 'root' })

export class LoginModalService {
  user: User = {
    email: "",
    password: ""
  }
  users: User[] = [];
  registUsers: User[] = [];
  isUserRegist: boolean = false;


  constructor(private modalService: NgbModal) { }

  openLoginModal(comp: any) {
    const modalRef = this.modalService.open(comp);

    modalRef.result.then((result) => {
      result
     // console.log(result);
    }).catch((error) => {
      error
      // console.log(error);
    });
  }

  closeModal(modal: any) {
    this.modalService.dismissAll(modal);
  }

 // comprobar si el usuario esta registradò
  isRegistered(user_: User) {
    console.log(this.users)

    this.registUsers = JSON.parse(localStorage.getItem('users') || '');

  console.log(this.registUsers);
    console.log(user_);

    for (let user of this.registUsers) {
      if (user_.email == user.email && user_.password == user.password) {
        console.log(user_.email, user_.password)
        console.log(user.email, user.password)
        this.isUserRegist = true;
        console.log(this.isUserRegist)
        return this.isUserRegist
      }

      else {
        this.isUserRegist = false
      }
    }

    console.log(this.isUserRegist)
    return this.isUserRegist;

  }
}
