import { NgModule } from '@angular/core';
import { HomeComponent } from './components/home/home.component';
import { PrescriptionsComponent } from './components/prescriptions/prescriptions.component';
import { RxusageComponent } from './components/rxusage/rxusage.component';
import { ActivityComponent } from './components/activity/activity.component';
import { LoginComponent } from './components/login/login.component';
import { FitnessComponent } from './components/fitness/fitness.component';
import { ReportsComponent } from './components/reports/reports.component';
import { FooddiaryComponent } from './components/fooddiary/fooddiary.component';
import { RegisterComponent } from './components/register/register.component';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'activity', component: ActivityComponent },
  { path: 'prescriptions', component: PrescriptionsComponent },
  { path: 'rxusage', component: RxusageComponent },
  { path: 'fitness', component: FitnessComponent },
  { path: 'reports', component: ReportsComponent },
  { path: 'fooddiary', component: FooddiaryComponent }
];


@NgModule({
  declarations: [
    HomeComponent,
    PrescriptionsComponent,
    RxusageComponent,
    ActivityComponent,
    ReportsComponent,
    FooddiaryComponent,
    FitnessComponent,
    LoginComponent
  ],
  imports: [
    RouterModule.forRoot(routes, {enableTracing: true})
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
