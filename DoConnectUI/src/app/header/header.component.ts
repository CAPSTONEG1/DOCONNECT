import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Question } from '../question';
import { Router } from '@angular/router';
import { User } from '../user';
import { AdminService } from '../admin.service';
import { Admin } from '../admin';



@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private userService:UserService, private router:Router
    , private adminService:AdminService) { }

  ngOnInit(): void {
    this.user=this.userService.giveUserData()
    this.admin=this.adminService.giveAdminData()
  }
  user=new User()
  admin = new Admin()

}
