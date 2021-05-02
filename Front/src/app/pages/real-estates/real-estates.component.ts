import {Component, OnInit} from '@angular/core';
import {tap} from 'rxjs/operators';
import {RealEstateHttpService} from '../../ServicesHTTP/real-estate-http-service';
import {Owner, RealEstate} from '../../ServicesHTTP/owner';

@Component({
  selector: 'app-real-estates',
  templateUrl: './real-estates.component.html',
  styleUrls: ['./real-estates.component.css']
})
export class RealEstatesComponent implements OnInit {

  realEstates: RealEstate[];

  constructor(private realEstateHttpService: RealEstateHttpService) {
  }

  ngOnInit(): void {

    this.realEstateHttpService.getAllRealEstates()
      .pipe(
        tap((data) => this.realEstates = data)
      )
      .subscribe();
  }
}
