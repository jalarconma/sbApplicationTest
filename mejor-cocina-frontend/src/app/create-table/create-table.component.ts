import { Component, OnInit } from '@angular/core';
import { TableApiService } from '../shared/table-api.service';

@Component({
    selector: 'app-create-table',
    templateUrl: './create-table.component.html',
    styleUrls: ['./create-table.component.scss']
})
export class CreateTableComponent implements OnInit {

    table = {}
    loading = false;

    constructor(private tableApi: TableApiService) { }

    ngOnInit() {
    }

    onSubmit(): void {
        this.loading = true;
        this.tableApi.create(this.table).subscribe((data: number) => {
            this.loading = false;
            this.table = {};
            window.alert("Mesa creada exitosamente");
        });
    }

}
