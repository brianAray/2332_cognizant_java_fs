import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChildExample } from './child-example';

describe('ChildExample', () => {
  let component: ChildExample;
  let fixture: ComponentFixture<ChildExample>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ChildExample]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChildExample);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
