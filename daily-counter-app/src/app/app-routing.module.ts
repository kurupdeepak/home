import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { CounterFormComponent } from './components/counterform/counterform.component';
import { EntryformComponent } from './components/entryform/entryform.component';
import { CounterSelectionFormComponent } from './components/counter-selection-form/counter-selection-form.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'counter', component: CounterFormComponent },
  { path: 'counterSelection', component: CounterSelectionFormComponent },
  { path: 'entry', component: EntryformComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
