import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { StartPageComponent } from './startpage/startpage.component';

const routes: Routes = [

    { path: '', component: StartPageComponent },
    { path: 'login', component: LoginComponent },
    { path: 'registration', component: RegistrationComponent },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
