import {Component, OnInit} from '@angular/core';
import {tap} from 'rxjs/operators';
import {RealEstateHttpService} from '../../ServicesHTTP/real-estate-http-service';
import {Models, RealEstate} from '../../ServicesHTTP/models';
import {UserLoggerService} from '../../Services/UserLogger/user-logger.service';

@Component({
  selector: 'app-real-estates',
  templateUrl: './real-estates.component.html',
  styleUrls: ['./real-estates.component.css']
})
export class RealEstatesComponent implements OnInit {

  realEstates: RealEstate[];

  constructor(private realEstateHttpService: RealEstateHttpService,
              private userLoggerService: UserLoggerService) {
  }

  ngOnInit(): void {

    const options = this.userLoggerService.options;

    this.realEstateHttpService.getAllRealEstates(options)
      .pipe(
        tap((data) => this.realEstates = data)
      )
      .subscribe();
  }
}
