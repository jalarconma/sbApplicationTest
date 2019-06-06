import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { ServerConfig } from './serverConfig';

@Injectable({
    providedIn: 'root'
})
export class BillingApiService {

    constructor(private http: HttpClient, private config: ServerConfig) { }

    create(billing): Observable<number> {
        return this.http.post<number>(this.config.apiURL + '/billing', JSON.stringify(billing), this.config.httpOptions)
            .pipe(
                retry(1),
                catchError(this.config.handleError)
            )
    }

    findByWaiter(year, month): Observable<[]> {
        let url = this.config.apiURL + `/billing/by-waiter/year/${year}/month/${month}`;
        return this.http.get<[]>(url).pipe(
            retry(1),
            catchError(this.config.handleError)
        )
    }

    findByClient(): Observable<[]> {
        let url = this.config.apiURL + '/billing/by-client';
        return this.http.get<[]>(url).pipe(
            retry(1),
            catchError(this.config.handleError)
        )
    }
}
