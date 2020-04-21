import { Component, OnInit } from '@angular/core';
import { CounterService } from '../../services/counter.service';
import { Counter } from '../../model/counter';
import { Router, ActivatedRoute, ParamMap} from '@angular/router';
import {SharedService} from '../../services/sharedservice';

@Component({
  selector: 'app-counter-selection-form',
  templateUrl: './counter-selection-form.component.html',
  styleUrls: ['./counter-selection-form.component.scss']
})

export class CounterSelectionFormComponent implements OnInit {
  selectedCounter = -1;
  counters: Counter [] = [];
  counter: Counter;
  constructor(private counterService: CounterService, private routes: Router, private sharedDataService: SharedService) { }

  ngOnInit(): void {
    this.loadCounters();
  }

  loadCounters(){
    this.counterService.getCounters().subscribe((data) => {
        this.counters  = data;
    }, (err) => {
      console.log('LoadCounters: error occured' + err);
    });
  }

  setCounter(){
    // tslint:disable-next-line:triple-equals
    this.counter = this.counters.find((c) => c.id == this.selectedCounter);
    this.sharedDataService.counter = this.counter;
    this.routes.navigate(['/entry']);
  }

}
