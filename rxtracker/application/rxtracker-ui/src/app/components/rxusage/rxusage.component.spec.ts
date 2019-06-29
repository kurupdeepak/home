import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RxusageComponent } from './rxusage.component';

describe('RxusageComponent', () => {
  let component: RxusageComponent;
  let fixture: ComponentFixture<RxusageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RxusageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RxusageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
