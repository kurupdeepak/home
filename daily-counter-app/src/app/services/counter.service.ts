import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError, of } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Counter} from '../model/counter';



const endpointUrl = 'http://localhost:8080/self/daily/counter';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})

export class CounterService {

  constructor(private http: HttpClient) {
  }

  getCounters(): Observable<any> {
    console.log('CounterService : getCounters called' );
    return this.http.get(endpointUrl);
  }

  getCountersWithEntries(): Observable<any> {
    console.log('CounterService : getCountersWithEntries called' );
    return this.http.get(endpointUrl + '/all');
  }

  addCounter(counter: Counter ) {
      const newLabel = endpointUrl + '/' + counter.name;
      return this.http.post(newLabel, httpOptions).pipe(
        catchError(this.handleError<any>('addCounter', counter.name))
      );
  }

  findCounter(name: string): Observable<any> {
    console.log('CounterService : findCounter called' );
    return this.http.get(endpointUrl);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
