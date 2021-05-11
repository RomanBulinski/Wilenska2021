import {Component, OnInit} from '@angular/core';
import {tap} from 'rxjs/operators';
import {Resolution} from '../../ServicesHTTP/models';
import {ResolutionsHttpService} from '../../ServicesHTTP/resolutions-http-service';

@Component({
  selector: 'app-resolutions',
  templateUrl: './resolutions.component.html',
  styleUrls: ['./resolutions.component.css']
})
export class ResolutionsComponent implements OnInit {

  resolutions: Resolution[];

  constructor(private resolutionsHttpService: ResolutionsHttpService) {
  }

  ngOnInit(): void {
    this.resolutionsHttpService.getAllResolutions()
      .pipe(
        tap((data) => this.resolutions = data)
      )
      .subscribe();
  }

}
