import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {RouterModule} from '@angular/router';
import {NavComponent} from './nav/nav.component';
import {StartComponent} from './pages/start/start.component';
import {AppRoutingModule} from './app-routing.module';
import {BetaComponent} from './pages/beta/beta.component';
import {OwnersComponent} from './pages/owners/owners.component';
import {RealEstatesComponent} from './pages/real-estates/real-estates.component';
import {ResolutionsComponent} from './pages/resolutions/resolutions.component';
import {HttpClientModule} from '@angular/common/http';
import {LoginComponent} from './pages/login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatOptionModule} from '@angular/material/core';
import {MatInputModule} from '@angular/material/input';
import {ReactiveFormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    StartComponent,
    BetaComponent,
    OwnersComponent,
    RealEstatesComponent,
    ResolutionsComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatOptionModule,
    ReactiveFormsModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
