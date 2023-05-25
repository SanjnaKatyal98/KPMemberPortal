import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
//components created are imported for routing
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RegisterComponent } from './register/register.component';
import { CaregiverComponent } from './caregiver/caregiver.component';
import { AssignCaregiverComponent } from './assign-caregiver/assign-caregiver.component';
import { AboutUsComponent } from './about-us/about-us.component';

const routes: Routes = [
  {path:'',pathMatch:'full',redirectTo:'home'},
  {path:'home',pathMatch:'full',component:HomeComponent},
  {path:'login',pathMatch:'full',component:LoginComponent},
  {path:'register',pathMatch:'full',component:RegisterComponent},
  {path:'caregiver',pathMatch:'full',component:CaregiverComponent},
  {path:'assignCg',pathMatch:'full',component:AssignCaregiverComponent},
  {path:'about us',pathMatch:'full',component:AboutUsComponent},
  {path:'**',component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
