import {Component, OnInit} from '@angular/core';
import {OwnersHttpService} from '../../ServicesHTTP/owners-http-service';
import {Models} from '../../ServicesHTTP/models';
import {switchMap, tap} from 'rxjs/operators';
import {UserLoggerService} from '../../Services/UserLogger/user-logger.service';

@Component({
  selector: 'app-owners',
  templateUrl: './owners.component.html',
  styleUrls: ['./owners.component.css']
})
export class OwnersComponent implements OnInit {

  owners: Models[];

  constructor(
    private ownersHttpService: OwnersHttpService,
    private userLoggerService: UserLoggerService) {
  }

  ngOnInit(): void {
    this.userLoggerService.setHeaderWithTokenFromSessionStorage().pipe(
      switchMap(options => this.ownersHttpService.getAllOwners(options).pipe(
        tap((data) => this.owners = data)
      ))
    ).subscribe();
  }
}
