import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BillingsByWaiterComponent } from './billings-by-waiter.component';

describe('BillingsByWaiterComponent', () => {
  let component: BillingsByWaiterComponent;
  let fixture: ComponentFixture<BillingsByWaiterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BillingsByWaiterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BillingsByWaiterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
