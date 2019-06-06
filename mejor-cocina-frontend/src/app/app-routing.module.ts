import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BilligResgistrationComponent } from './billig-resgistration/billig-resgistration.component';
import { CreateClientComponent } from './create-client/create-client.component';
import { CreateWaiterComponent } from './create-waiter/create-waiter.component';
import { CreateTableComponent } from './create-table/create-table.component';
import { BillingsByWaiterComponent } from './billings-by-waiter/billings-by-waiter.component';
import { BillingsByClientComponent } from './billings-by-client/billings-by-client.component';

const routes: Routes = [
    {
       path : 'billing-registration',
       component : BilligResgistrationComponent
    },
    {
        path : 'create-client',
        component : CreateClientComponent
    },
    {
        path : 'create-waiter',
        component : CreateWaiterComponent
    },
    {
        path : 'create-table',
        component : CreateTableComponent
    },
    {
        path : 'billings-waiter',
        component : BillingsByWaiterComponent
    },
    {
        path : 'billings-client',
        component : BillingsByClientComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
