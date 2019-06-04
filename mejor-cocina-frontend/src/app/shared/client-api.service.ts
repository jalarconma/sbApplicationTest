import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';

import { Client } from '../shared/client'


@Injectable({
    providedIn: 'root'
})
export class ClientApiService {

    apiURL = 'http://localhost:8080';

    // Http Options
    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })
    }

    constructor(private http: HttpClient) { }

    findAll(): Observable<[]> {
        return this.http.get<[]>(this.apiURL + '/client/all')
            .pipe(
                retry(1),
                catchError(this.handleError)
            )
    }

    create(client): Observable<number> {
        return this.http.post<number>(this.apiURL + '/client', JSON.stringify(client), this.httpOptions)
            .pipe(
                retry(1),
                catchError(this.handleError)
            )
    }

    // Error handling 
    handleError(error) {
        let errorMessage = '';
        if (error.error instanceof ErrorEvent) {
            // Get client-side error
            errorMessage = error.error.message;
        } else {
            // Get server-side error
            errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
        }
        window.alert(errorMessage);
        return throwError(errorMessage);
    }
}
