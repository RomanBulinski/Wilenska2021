import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class OwnersHttpService {
  constructor(private http: HttpClient) { }

  OWNERS_URL = 'http://localhost:8080/owners';

  getAllOwners(): Observable<any> {
    return this.http.get(this.OWNERS_URL);
  }

}
