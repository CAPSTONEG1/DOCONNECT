import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UHomeComponent } from './uhome.component';

describe('UHomeComponent', () => {
  let component: UHomeComponent;
  let fixture: ComponentFixture<UHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
