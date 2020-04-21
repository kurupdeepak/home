import { Component, OnInit, Input } from '@angular/core';
import { Entry } from '../../model/entry';
import { Counter } from '../../model/counter';
import { EntryService } from '../../services/entry.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { SharedService } from 'src/app/services/sharedservice';

@Component({
  selector: 'app-entry-form',
  templateUrl: './entryform.component.html',
  styleUrls: ['./entryform.component.scss']
})

export class EntryformComponent implements OnInit {
  entryValue = 0;
  counter: Counter;
  // @notused
  detail = '';
  submitted =  false;
  // tslint:disable-next-line:max-line-length
  constructor(private entryService: EntryService, private sharedDataService: SharedService, private routes: Router) { }

  ngOnInit(): void {
    this.counter = this.sharedDataService.counter;
    // tslint:disable-next-line:triple-equals
    if (this.counter == undefined){
        this.routes.navigate([ '/counterSelection' ]);
    }
  }

  addEntry() {
      const entry: Entry = new Entry();
      entry.value = this.entryValue;
      entry.counterName = this.counter.name;
      entry.notes = this.detail;
      this.entryService.addEntry(entry).subscribe((data) => {
          console.log('EntryForm: addEntry ' + entry);
      }, (err) => {
        console.log('addEntry : Error occured' + err);
      });
  }

  onSubmit(){
    this.submitted = true;
    this.addEntry();
    this.routes.navigate(['/home']);
  }

}
