import { Component, OnInit } from '@angular/core';
import { AdminService } from './../admin.service';

import { User } from './../user';

import { Router } from '@angular/router';

@Component({
  selector: 'app-get-users',
  templateUrl: './get-users.component.html',
  styleUrls: ['./get-users.component.css']
})
export class GetUsersComponent implements OnInit {

  constructor(private router:Router,private adminService:AdminService) { }

  ngOnInit(): void {
  }
  user = new User()
  users: User[] | undefined
  userThere:boolean=false


  getUser(email:string)
  {
    this.adminService.getUser(email).subscribe((data)=>
    {
      this.user=data
    })
  }

  getAllUsers()
  {
    this.adminService.getAllUsers().subscribe((data)=>
    {
      console.log(data)
      this.users=data
      if(data.length!==0)
        this.userThere=true
      else
      alert("No users present")
    })
  }
}

