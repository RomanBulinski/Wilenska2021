import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class RealEstateHttpService {

  constructor(private http: HttpClient) { }

  REALESTATE_URL = 'http://localhost:8080/realEstates';

  getAllRealEstates(): Observable<any> {
    return this.http.get(this.REALESTATE_URL);
  }

}
