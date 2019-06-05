import { Component, OnInit } from '@angular/core';
import { ClientApiService } from '../shared/client-api.service';
import { WaiterApiService } from '../shared/waiter-api.service';
import { TableApiService } from '../shared/table-api.service';

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

    loading = false;

    constructor(private clientApi: ClientApiService, 
                private waiterApi: WaiterApiService,
                private tableApi: TableApiService) { }

    ngOnInit() {
        this.findClients();
        this.findWaiters();
        this.findTables();
    }

    findClients(): void {
        this.clientApi.findAll().subscribe((data: []) => {
            this.clients = data;
        });
    }

    findWaiters(): void {
        this.waiterApi.findAll().subscribe((data: []) => {
            this.waiters = data;
        });
    }

    findTables(): void {
        this.tableApi.findAll().subscribe((data: []) => {
            this.tables = data;
        });
    }

    onSubmit(): void {
        this.loading = true;
        // this.clientApi.createClient().subscribe((data: number) => {
        //     this.loading = false;
        //     this.billing = {};
        //     //show alert successful
        // });
    }

}
