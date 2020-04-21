import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { CounterFormComponent } from './components/counterform/counterform.component';
import { EntryformComponent } from './components/entryform/entryform.component';
import { CounterSelectionFormComponent } from './components/counter-selection-form/counter-selection-form.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CounterFormComponent,
    EntryformComponent,
    CounterSelectionFormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
