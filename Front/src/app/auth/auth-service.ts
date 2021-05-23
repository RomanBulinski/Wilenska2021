import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public isLoggedIn(): void {
    const token = localStorage.getItem('token'); // get token from local storage
    // const payload = atob(token.split('.')[1]); // decode payload of token
    // const parsedPayload = JSON.parse(payload); // convert payload into an Object

    console.log("1111111111111");
    console.log(token);
    // console.log(payload);
    // console.log(parsedPayload);

    // return parsedPayload.exp > Date.now() / 1000; // check if token is expired
  }
}
