import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ResolutionsHttpService {
  constructor(private http: HttpClient) { }

  RESOLUTIONS_URL = 'http://localhost:8080/resolutions';

  getAllResolutions(): Observable<any> {
    return this.http.get(this.RESOLUTIONS_URL);
  }
}
