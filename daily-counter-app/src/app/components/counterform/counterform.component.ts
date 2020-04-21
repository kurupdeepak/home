import { Component, OnInit, Injectable } from '@angular/core';
import {CounterService} from '../../services/counter.service';
import { provideRoutes } from '@angular/router';
import { Counter } from 'src/app/model/counter';

@Component({
  selector: 'app-counter-form',
  templateUrl: './counterform.component.html',
  styleUrls: ['./counterform.component.scss']
})

export class CounterFormComponent implements OnInit {
    name: string ;
    submitted = false;
    constructor(private counterService: CounterService) { }

    ngOnInit(): void {
    }

    addCounter(){
      const counter: Counter = new Counter();
      counter.name = this.name;
      this.counterService.addCounter(counter).subscribe((data) => {
        console.log('Value posted successfully');
      }, (err) => {
        console.log(err);
      });
    }

    onSubmit() {
      this.submitted = true;
      this.addCounter();
    }
  }
