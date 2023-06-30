import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
//root component
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
//components created
import { AboutUsComponent } from './about-us/about-us.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CaregiverComponent } from './caregiver/caregiver.component';
import { AssignCaregiverComponent } from './assign-caregiver/assign-caregiver.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
//imported for template or reactive forms
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormGroup,FormArray, FormBuilder, FormControl } from '@angular/forms';
//for calling server
import { HttpClientModule } from '@angular/common/http';
//security
import { authInterceptorProviders } from './services/auth.interceptor';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
//for search via pipe
import { FilterPipe } from './filter.pipe';

@NgModule({
  declarations: [
    AppComponent,
    AboutUsComponent,
    HomeComponent,
    NavbarComponent,
    LoginComponent,
    RegisterComponent,
    CaregiverComponent,
    AssignCaregiverComponent,
    PageNotFoundComponent,
    AdminDashboardComponent,
    FilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule //spring;http client class use kr sakte
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }