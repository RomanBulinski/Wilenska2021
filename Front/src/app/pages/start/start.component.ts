import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserLoggerService} from '../../Services/UserLogger/user-logger.service';

@Component({
  selector: 'app-start',
  templateUrl: './start.component.html',
  styleUrls: ['./start.component.css']
})
export class StartComponent implements OnInit {

  userName: string;

  constructor(private http: HttpClient,
              private userLoggerService: UserLoggerService) {
  }

  ngOnInit(): void {
  }

  logout(): void {
    this.userLoggerService.logout();
  }
}

