import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginFormComponent } from '../login-form/login-form.component';
import { LoginModalService } from '../login-form/login-modal.service';
import { AlertFormService } from '../alert-form/alert.service';
import { AlertFormComponent } from '../alert-form/alert-form.component';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router, private loginService: LoginModalService, private Alertservice: AlertFormService) { }

  ngOnInit(): void {
  }

  openLoginModal() {
    this.loginService.openLoginModal(LoginFormComponent)
  }

  openAlertForm(){
    this.Alertservice.openAlertModal(AlertFormComponent)
  }

}
