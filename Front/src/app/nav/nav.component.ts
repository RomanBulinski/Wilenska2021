import {Component, OnInit} from '@angular/core';
import {UserLoggerService} from '../Services/UserLogger/user-logger.service';
import {tap} from 'rxjs/operators';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  ownersLinkVisible = true;
  realEstatesLinkVisible = true;
  resolutionsLinkVisible = true;

  role = '';

  constructor( private userLoggerService: UserLoggerService) {
  }

  ngOnInit(): void {
    this.userLoggerService.getRole().pipe( tap( ( res ) => {
      console.log( '2222222222222' );
      console.log( res );
      this.role = res;
    })).subscribe();
  }
}
