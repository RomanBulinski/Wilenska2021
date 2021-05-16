import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {AppConstant} from '../../common/app-constant';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'login',
  templateUrl: './login.component.html'
})

export class LoginComponent implements OnInit {

  userName = new FormControl('');
  password = new FormControl('');

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    sessionStorage.setItem('token', '');
  }

  login(): void {
    this.http.post<Observable<boolean>>(AppConstant.LOGIN_URL, {
      userName: this.userName.value,
      password: this.password.value,
    }).subscribe(isValid => {
      if (isValid) {
        sessionStorage.setItem('token', btoa(this.userName.value + ':' + this.password.value));
        this.router.navigate(['']);
      } else {
        console.log('Logger error');
      }
    });
  }
}
