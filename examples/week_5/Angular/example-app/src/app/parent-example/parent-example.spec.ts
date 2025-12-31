import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParentExample } from './parent-example';

describe('ParentExample', () => {
  let component: ParentExample;
  let fixture: ComponentFixture<ParentExample>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ParentExample]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ParentExample);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
