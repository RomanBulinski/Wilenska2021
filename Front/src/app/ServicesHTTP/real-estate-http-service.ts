import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppConstant} from '../common/app-constant';

@Injectable({
  providedIn: 'root',
})
export class RealEstateHttpService {

  constructor(private http: HttpClient) { }

  getAllRealEstates(options: any): Observable<any> {
    return this.http.get(AppConstant.REALESTATE_URL, options);
  }
}
