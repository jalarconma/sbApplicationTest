import { Component, OnInit } from '@angular/core';
import { BillingApiService } from '../shared/billing-api.service';

@Component({
    selector: 'app-billings-by-waiter',
    templateUrl: './billings-by-waiter.component.html',
    styleUrls: ['./billings-by-waiter.component.scss']
})
export class BillingsByWaiterComponent implements OnInit {

    year: number = null;
    month: number = null;
    loading = false;
    billingsByWaiter = [];

    constructor(private billingApi: BillingApiService) { }

    ngOnInit() {
    }

    onSubmit(): void {
        this.loading = true;
        this.billingApi.findByWaiter(this.year, this.month).subscribe((data: []) => {
            this.loading = false;
            this.billingsByWaiter = data;
        });
    }

}
