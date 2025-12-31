import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccessParamsExample } from './access-params-example';

describe('AccessParamsExample', () => {
  let component: AccessParamsExample;
  let fixture: ComponentFixture<AccessParamsExample>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AccessParamsExample]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AccessParamsExample);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
