import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AheadComponent } from './ahead.component';

describe('AheadComponent', () => {
  let component: AheadComponent;
  let fixture: ComponentFixture<AheadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AheadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AheadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
