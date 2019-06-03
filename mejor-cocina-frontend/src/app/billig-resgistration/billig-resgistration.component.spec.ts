import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BilligResgistrationComponent } from './billig-resgistration.component';

describe('BilligResgistrationComponent', () => {
  let component: BilligResgistrationComponent;
  let fixture: ComponentFixture<BilligResgistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BilligResgistrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BilligResgistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
