import {Component, OnInit} from '@angular/core';
import {switchMap, tap} from 'rxjs/operators';
import {Resolution} from '../../ServicesHTTP/models';
import {ResolutionsHttpService} from '../../ServicesHTTP/resolutions-http-service';
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
    this.userLoggerService.setHeaderWithTokenFromSessionStorage().pipe(
      switchMap( options => this.resolutionsHttpService.getAllResolutions(options).pipe(
        tap((data) => this.resolutions = data)
      ))
    ).subscribe();
  }
}

