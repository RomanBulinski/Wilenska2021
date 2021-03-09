import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {StartComponent} from './pages/start/start.component';
import {BetaComponent} from './pages/beta/beta.component';


const routes: Routes = [
  {path: '', component: StartComponent},
  {path: 'start', component: StartComponent},
  {path: 'beta', component: BetaComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
