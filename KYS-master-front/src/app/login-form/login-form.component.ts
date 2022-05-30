import { Component, OnInit } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginModalService } from './login-modal.service';
import { User } from './user';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  isLoginMode = false;
  user: User = {
    email: "",
    password: ""
  }
  users: User[] = [];
  isUserRegist: boolean = false;

  constructor(public http:HttpClient, public activeModal: NgbActiveModal, public router: Router, public loginService: LoginModalService) { }


  ngOnInit(): void {
  }

  closeModal() {
    this.activeModal.close();
  }
 // cambiar Login mode a Sign In mode
  onSwitchMode() {
    this.isLoginMode = !this.isLoginMode;
  }

  onSubmit(form: NgForm) {
    if (!form.valid) {
      return
    }
    //obtener data de formulario
    this.user.email = form.value.email;
    this.user.password = form.value.password;

    this.http.post(`${environment.USER_DATA}`, form.value).subscribe(res => (console.log(res)));
    this.activeModal.close();
  }
}
