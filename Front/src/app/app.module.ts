import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {RouterModule} from '@angular/router';
import { NavComponent } from './nav/nav.component';
import {StartComponent} from './pages/start/start.component';
import {AppRoutingModule} from './app-routing.module';
import {BetaComponent} from './pages/beta/beta.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    StartComponent,
    BetaComponent
  ],
    imports: [
        BrowserModule,
        RouterModule,
        AppRoutingModule,
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
