import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UheadComponent } from './uhead.component';

describe('UheadComponent', () => {
  let component: UheadComponent;
  let fixture: ComponentFixture<UheadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UheadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UheadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
