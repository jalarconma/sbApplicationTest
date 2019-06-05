import { Component, OnInit } from '@angular/core';
import { WaiterApiService } from '../shared/waiter-api.service';

@Component({
    selector: 'app-create-waiter',
    templateUrl: './create-waiter.component.html',
    styleUrls: ['./create-waiter.component.scss']
})
export class CreateWaiterComponent implements OnInit {

    waiter = {};
    loading = false;

    constructor(private waiterApi: WaiterApiService) { }

    ngOnInit() {
    }

    onSubmit(): void {
        this.loading = true;
        this.waiterApi.create(this.waiter).subscribe((data: number) => {
            this.loading = false;
            this.waiter = {};
            window.alert("Camarero creado exitosamente");
        });
    }

}
