import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestCounterComponent } from './test-counter-component';

describe('TestCounterComponent', () => {
  let component: TestCounterComponent;
  let fixture: ComponentFixture<TestCounterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TestCounterComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TestCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should start at 0', () => {
    expect(component.count).toBe(0);
  });

  it('should increment count', () => {
    component.increment();
    expect(component.count).toBe(1);
  });

  it('should display count in template', () => {
    const el = fixture.nativeElement;
    expect(el.querySelector('p').textContent).toContain('Count: 0');
  });


  it('should increment when button clicked', () => {
    const button = fixture.nativeElement.querySelector('button');
    button.click();
    fixture.detectChanges(); // update DOM
    expect(component.count).toBe(1);
  });
});
