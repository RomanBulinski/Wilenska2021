import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {RouterModule} from '@angular/router';
import { NavComponent } from './nav/nav.component';
import {StartComponent} from './pages/start/start.component';
import {AppRoutingModule} from './app-routing.module';
import {BetaComponent} from './pages/beta/beta.component';
import { OwnersComponent } from './pages/owners/owners.component';
import { RealEstatesComponent } from './pages/real-estates/real-estates.component';
import { ResolutionsComponent } from './pages/resolutions/resolutions.component';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    StartComponent,
    BetaComponent,
    OwnersComponent,
    RealEstatesComponent,
    ResolutionsComponent
  ],
    imports: [
        BrowserModule,
        HttpClientModule,
        RouterModule,
        AppRoutingModule,
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
