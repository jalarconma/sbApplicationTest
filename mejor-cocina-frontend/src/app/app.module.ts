import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BilligResgistrationComponent } from './billig-resgistration/billig-resgistration.component';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { CreateClientComponent } from './create-client/create-client.component';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { AlertModule } from 'ngx-bootstrap/alert';
import { CreateWaiterComponent } from './create-waiter/create-waiter.component';
import { ServerConfig } from './shared/serverConfig';
import { CreateTableComponent } from './create-table/create-table.component';
import { DatePipe } from '@angular/common';
import { BillingsByWaiterComponent } from './billings-by-waiter/billings-by-waiter.component';
import { BillingsByClientComponent } from './billings-by-client/billings-by-client.component';


@NgModule({
  declarations: [
    AppComponent,
    BilligResgistrationComponent,
    CreateClientComponent,
    CreateWaiterComponent,
    CreateTableComponent,
    BillingsByWaiterComponent,
    BillingsByClientComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    TabsModule.forRoot(),
    BsDatepickerModule.forRoot(),
    AlertModule.forRoot()
  ],
  providers: [
      ServerConfig,
      DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
