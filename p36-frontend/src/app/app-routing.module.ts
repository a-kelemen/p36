import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { StartPageComponent } from './startpage/startpage.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

const routes: Routes = [

    { path: '', component: StartPageComponent },
    { path: 'login', component: LoginComponent },
    { path: 'registration', component: RegistrationComponent },
    { path: 'dashboard', component: DashboardComponent },
];
@NgModule({
  imports: [
      RouterModule.forRoot(routes),
      FormsModule,
      ReactiveFormsModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
