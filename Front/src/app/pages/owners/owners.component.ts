import { Component, OnInit } from '@angular/core';
import {OwnersHttpService} from '../../ServicesHTTP/owners-http-service';
import {Owner} from '../../ServicesHTTP/owner';
import {tap} from 'rxjs/operators';

@Component({
  selector: 'app-owners',
  templateUrl: './owners.component.html',
  styleUrls: ['./owners.component.css']
})
export class OwnersComponent implements OnInit {

  owners: Owner[];

  constructor(
    private ownersHttpService: OwnersHttpService) { }

  ngOnInit(): void {

    this.ownersHttpService.getAllOwners()
      .pipe(
        tap((data) => this.owners = data)
      )
      .subscribe();
  }

}
