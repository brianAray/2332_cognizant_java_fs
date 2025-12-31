import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ObservableExample } from './observable-example';

describe('ObservableExample', () => {
  let component: ObservableExample;
  let fixture: ComponentFixture<ObservableExample>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ObservableExample]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ObservableExample);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
