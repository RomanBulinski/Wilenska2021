import {Component, OnInit} from '@angular/core';
import {catchError, tap} from 'rxjs/operators';
import {Resolution} from '../../ServicesHTTP/models';
import {ResolutionsHttpService} from '../../ServicesHTTP/resolutions-http-service';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {EMPTY, Observable} from 'rxjs';
import {UserLoggerService} from '../../Services/UserLogger/user-logger.service';

@Component({
  selector: 'app-resolutions',
  templateUrl: './resolutions.component.html',
  styleUrls: ['./resolutions.component.css']
})
export class ResolutionsComponent implements OnInit {

  resolutions: Resolution[];

  constructor(private resolutionsHttpService: ResolutionsHttpService,
              private userLoggerService: UserLoggerService) {
  }

  ngOnInit(): void {

    const options = this.userLoggerService.options;

    this.resolutionsHttpService.getAllResolutions(options)
      .pipe(
        tap((data) => this.resolutions = data)
      )
      .subscribe();
  }
}

