import { Component, OnInit } from '@angular/core';
import { ClientApiService } from '../shared/client-api.service';

@Component({
    selector: 'app-billig-resgistration',
    templateUrl: './billig-resgistration.component.html',
    styleUrls: ['./billig-resgistration.component.scss']
})
export class BilligResgistrationComponent implements OnInit {

    clients = [];
    waiters = [];
    tables = [];
    billing = {};

    constructor(private clientApi: ClientApiService) { }

    ngOnInit() {
        this.findClients();
    }

    findClients(): void {
        this.clientApi.findAll().subscribe((data: []) => {
            this.clients = data;
        });
    }

}
