import { TestBed } from '@angular/core/testing';

import { TestCalculatorService } from './test-calculator-service';
import { HttpTestingController, provideHttpClientTesting } from '@angular/common/http/testing';
import { provideHttpClient } from '@angular/common/http';

describe('TestCalculatorService', () => {
  let service: TestCalculatorService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TestCalculatorService, provideHttpClient(), provideHttpClientTesting()]
    });
    service = TestBed.inject(TestCalculatorService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should fetch users', () => {
    const mockUsers = [
      {id: 1, name: 'alice'},
      {id: 2, name: 'bob'}
    ];

    service.getUsers().subscribe(users => {
      expect(users.length).toBe(2);
    })

    const req = httpMock.expectOne('/api/users');
    expect(req.request.method).toBe('GET');
    req.flush(mockUsers);
  });

  it('should add numbers', () => {
    expect(service.add(2, 3)).toBe(5);
    expect(service.add(-1, 1)).toBe(0);
  });

  it('should multiply numbers', () => {
    expect(service.multiply(2, 3)).toBe(6);
    expect(service.multiply(0, 5)).toBe(0);
  })
});
