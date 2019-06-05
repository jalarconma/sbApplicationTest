import { Component, OnInit } from '@angular/core';
import { ClientApiService } from '../shared/client-api.service';

@Component({
    selector: 'app-create-client',
    templateUrl: './create-client.component.html',
    styleUrls: ['./create-client.component.scss']
})
export class CreateClientComponent implements OnInit {

    client = {};
    loading = false;

    constructor(private clientApi: ClientApiService) { }

    ngOnInit() {
    }

    onSubmit(): void {
        this.loading = true;
        this.clientApi.create(this.client).subscribe((data: number) => {
            this.loading = false;
            this.client = {};
            window.alert("Cliente creado exitosamente");
        });

    }

}
