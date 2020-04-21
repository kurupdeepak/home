import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError, of } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Entry } from '../model/entry';



const endpointUrl = 'http://localhost:8080/self/daily/counter';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})

export class EntryService {

  counterLabels = [];

  constructor(private http: HttpClient) {
  }

  getEntries(counterName: string): Observable<any> {
    return this.http.get(endpointUrl + '/' + counterName + '/entries');
  }

  addEntry(entry: Entry ): Observable<any> {
      const newLabel = endpointUrl + '/' + entry.counterName + '/entries';
      const tmp = {counterName: '', value: 0, details: ''};
      tmp.value = entry.value;
      tmp.details = entry.notes;
      tmp.counterName = entry.counterName;
      return this.http.post(newLabel, tmp, httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError<any>('addEntry',  entry.counterName + ':' + entry.value))
      );
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
