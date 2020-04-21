import { Injectable } from '@angular/core';
import { Counter } from '../model/counter';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  counter: Counter;
  constructor() { }
  setCounter(c: Counter){
    this.counter = c;
  }
  getCounter(){
    return this.counter;
  }
}
