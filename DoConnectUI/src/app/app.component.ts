import { Component } from '@angular/core';
import { User } from './user';
import { Admin } from './admin';
import { UserService } from './user.service';

import { Router } from '@angular/router';

import { AdminService } from './admin.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private userService:UserService, private router:Router
    , private adminService:AdminService) { }
  title = 'doconnect_UI';
  user=new User();
  admin = new Admin()
  ngOnInit(): void {
    this.user=this.userService.giveUserData()
    this.admin=this.adminService.giveAdminData()
  }
  sideBarOpen = true;

  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }


}
