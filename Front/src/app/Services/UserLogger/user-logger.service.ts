import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {EMPTY, Observable, of, throwError} from 'rxjs';
import {AppConstant} from '../../common/app-constant';
import {catchError, tap} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class UserLoggerService {

  constructor(private http: HttpClient) {
    // this.getOptionsTokenFromSessionStorage()
    //   .pipe(
    //     tap((options) => this.checkToken(options)))
    //   .subscribe();
  }

  userName;

  private checkAuthentication(options: {}): void {
    this.http.post<Observable<any>>(AppConstant.USER_LOGGER, {}, options)
      .pipe(
        tap(principal => {
          console.log('11111111111111111');
          console.log(principal);
          this.userName = principal;
        }),
        catchError(err => {
          console.log('2222222222222222error');
          if (err.status === 401) {
            return EMPTY;
          }
        })
      ).subscribe();
  }


  public setHeaderWithTokenFromSessionStorage(): Observable<any> {
    const tokenInHeader: HttpHeaders = new HttpHeaders({
      Authorization: 'Basic ' + sessionStorage.getItem('token')
    });

    const options = { headers: tokenInHeader };
    return of(options);
  }

  public logout(): void {
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


