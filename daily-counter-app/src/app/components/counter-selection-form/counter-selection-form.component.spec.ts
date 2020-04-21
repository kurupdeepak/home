import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CounterSelectionFormComponent } from './counter-selection-form.component';

describe('CounterSelectionFormComponent', () => {
  let component: CounterSelectionFormComponent;
  let fixture: ComponentFixture<CounterSelectionFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CounterSelectionFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CounterSelectionFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
