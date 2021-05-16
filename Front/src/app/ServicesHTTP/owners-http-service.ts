import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {AppConstant} from '../common/app-constant';

@Injectable({
  providedIn: 'root',
})
export class OwnersHttpService {
  constructor(private http: HttpClient) { }

  getAllOwners(options: any): Observable<any> {
    return this.http.get(AppConstant.OWNERS_URL, options);
  }
}

