import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {EMPTY, Observable, throwError} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import {AppConstant} from '../../common/app-constant';


@Injectable({
  providedIn: 'root'
})
export class UserLoggerService {

  options = {};

  constructor(private http: HttpClient) {

    const headers: HttpHeaders = new HttpHeaders({
      Authorization: 'Basic ' + sessionStorage.getItem('token')
    });

    this.options = { headers };

    this.http.post<Observable<any>>( AppConstant.USER_LOGGER, {}, this.options)
      .pipe(
        tap(principal => {
          console.log('11111111111111111');
          console.log(principal);
          // this.userName = principal.;
        }),
        catchError(err => {
          if (err.status === 401) {
            return EMPTY;
          }
        })
      ).subscribe();
  }

  logout(): void {
    sessionStorage.setItem('token', '');
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError(
      'Something bad happened; please try again later.');
  }

}


