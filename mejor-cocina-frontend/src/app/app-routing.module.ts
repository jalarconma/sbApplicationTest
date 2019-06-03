import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BilligResgistrationComponent } from './billig-resgistration/billig-resgistration.component';

const routes: Routes = [
    {
       path : 'billing-registration',
       component : BilligResgistrationComponent
    }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
