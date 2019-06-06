import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BillingsByClientComponent } from './billings-by-client.component';

describe('BillingsByClientComponent', () => {
  let component: BillingsByClientComponent;
  let fixture: ComponentFixture<BillingsByClientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BillingsByClientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BillingsByClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
