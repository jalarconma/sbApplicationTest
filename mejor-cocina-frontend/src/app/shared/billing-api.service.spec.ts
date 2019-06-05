import { TestBed } from '@angular/core/testing';

import { BillingApiService } from './billing-api.service';

describe('BillingApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BillingApiService = TestBed.get(BillingApiService);
    expect(service).toBeTruthy();
  });
});
