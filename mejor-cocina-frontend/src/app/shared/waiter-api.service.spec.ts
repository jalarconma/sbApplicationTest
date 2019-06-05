import { TestBed } from '@angular/core/testing';

import { WaiterApiService } from './waiter-api.service';

describe('WaiterApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: WaiterApiService = TestBed.get(WaiterApiService);
    expect(service).toBeTruthy();
  });
});
