import { Component, OnInit } from '@angular/core';
import { BillingApiService } from '../shared/billing-api.service';

@Component({
    selector: 'app-billings-by-client',
    templateUrl: './billings-by-client.component.html',
    styleUrls: ['./billings-by-client.component.scss']
})
export class BillingsByClientComponent implements OnInit {

    loading = false;
    billingsByClient = [];

    constructor(private billingApi: BillingApiService) { }

    ngOnInit() {
        this.loading = true;
        this.billingApi.findByClient().subscribe((data: []) => {
            this.loading = false;
            this.billingsByClient = data;
        });
    }

}
