import { Component, OnInit } from '@angular/core';
import { CounterService } from '../../services/counter.service';
import { EntryService } from '../../services/entry.service';
import { Counter } from '../../model/counter';
import { Entry } from '../../model/entry';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  // counters: Counter [] = [{id: 1, name: 'AngularCounter'}];
  countersMap: Map<Counter, Entry>  = new Map();
  counters: Counter [];
  constructor(private counterService: CounterService, private entryService: EntryService) { }

  ngOnInit(): void {
    console.log('Inside ngOnInit');
    this.getCountersAndEntries();
  }

  getCountersAndEntries() {
    console.log('HomeComponent : getCounters ');
    this.counterService.getCountersWithEntries().subscribe((data) => {
       this.countersMap = data;
    }, (err) => {
      console.log(err);
    });
  }

  getCounters() {
    console.log('HomeComponent : getCounters ');
    this.counterService.getCounters().subscribe((data) => {
       this.counters = data;
    }, (err) => {
      console.log(err);
    });
  }

}
