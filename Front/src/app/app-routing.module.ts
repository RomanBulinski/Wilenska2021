import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StartComponent} from './pages/start/start.component';
import {OwnersComponent} from './pages/owners/owners.component';
import {RealEstatesComponent} from './pages/real-estates/real-estates.component';
import {ResolutionsComponent} from './pages/resolutions/resolutions.component';
import {LoginComponent} from './pages/login/login.component';
import {AuthGuard} from './auth/auth-guard';

const routes: Routes = [
  {path: '', component: StartComponent},
  {path: 'start', component: StartComponent},
  {path: 'owners', component: OwnersComponent},
  {path: 'realEstates', component: RealEstatesComponent, canActivate: [AuthGuard]},
  {path: 'resolutions', component: ResolutionsComponent},
  {path: 'login', component: LoginComponent},
  {path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(routes);

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
