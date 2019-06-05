import { Component, OnInit } from '@angular/core';
import { ClientApiService } from '../shared/client-api.service';
import { WaiterApiService } from '../shared/waiter-api.service';
import { TableApiService } from '../shared/table-api.service';
import { BillingApiService } from '../shared/billing-api.service';
import { DatePipe } from '@angular/common';

@Component({
    selector: 'app-billig-resgistration',
    templateUrl: './billig-resgistration.component.html',
    styleUrls: ['./billig-resgistration.component.scss']
})
export class BilligResgistrationComponent implements OnInit {

    clients = [];
    waiters = [];
    tables = [];
    billing = {
        client: null,
        waiter: null,
        table: null,
        value: null,
        registrationDate: null
    };

    loading = false;

    constructor(private clientApi: ClientApiService,
        private waiterApi: WaiterApiService,
        private tableApi: TableApiService,
        private billingApi: BillingApiService,
        private datePipe: DatePipe) { }

    ngOnInit() {
        this.initValues();
    }

    initValues(): void {
        this.clients = [];
        this.waiters = [];
        this.tables = [];
        this.billing = {
            client: null,
            waiter: null,
            table: null,
            value: null,
            registrationDate: null
        };

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
        let billingDate = this.datePipe.transform(this.billing.registrationDate, "dd-MM-yyyy");
        let billingIn = {
            clientId: this.billing.client,
            waiterId: this.billing.waiter,
            tableId: this.billing.table,
            value: this.billing.value,
            registrationDate: billingDate
        };

        this.billingApi.create(billingIn).subscribe((data: number) => {
            this.loading = false;
            this.initValues();
            window.alert("Factura registrada exitosamente");
        });
    }

}
