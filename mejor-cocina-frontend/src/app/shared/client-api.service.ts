import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { ServerConfig } from './serverConfig';


@Injectable({
    providedIn: 'root'
})
export class ClientApiService {

    constructor(private http: HttpClient, private config: ServerConfig) {}

    findAll(): Observable<[]> {
        return this.http.get<[]>(this.config.apiURL + '/client/all')
            .pipe(
                retry(1),
                catchError(this.config.handleError)
            )
    }

    create(client): Observable<number> {
        return this.http.post<number>(this.config.apiURL + '/client', JSON.stringify(client), this.config.httpOptions)
            .pipe(
                retry(1),
                catchError(this.config.handleError)
            )
    }
}
