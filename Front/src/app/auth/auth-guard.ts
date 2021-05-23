import {Injectable} from '@angular/core';
import {AuthService} from './auth-service';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate{

  constructor(private authService: AuthService, private router: Router) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

    // if (!this.authService.isLoggedIn()) {
    if (false) {
      this.router.navigate(['/login']); // go to login if not authenticated
      return false;
    }
    return true;
  }
}
