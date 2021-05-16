import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppConstant} from '../common/app-constant';

@Injectable({
  providedIn: 'root',
})
export class ResolutionsHttpService {
  constructor(private http: HttpClient) { }

  getAllResolutions(options: any): Observable<any> {
    return this.http.get(AppConstant.RESOLUTIONS_URL, options);
  }
}
