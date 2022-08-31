import { Component, OnInit } from '@angular/core';
import { Admin } from '../admin';
import { AdminService } from './../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-register',
  templateUrl: './admin-register.component.html',
  styleUrls: ['./admin-register.component.css']
})
export class AdminRegisterComponent implements OnInit {

  constructor(private adminService: AdminService,private router:Router) { }

  ngOnInit(): void {

    this.admin=this.adminService.giveAdminData()
    if(this.admin.id!==0){
      this.router.navigate(['/admin-login'])
    }
  }

  token: string = 'abc';
  isToken: boolean = false;
  errorMsg: string = '';
  getToken(event: Event) {
    if(this.token == (event.target as HTMLInputElement).value)
    {
      this.isToken = true;
      this.errorMsg = "Token is correct"
      console.log(this.errorMsg)
    } 
    else{
      this.isToken = false;
      this.errorMsg = "Token is Incorrect";
      console.log(this.errorMsg)
    }

  }

  admin= new Admin();

  adminRegister(data:any){

   this.admin.email= data.email
    this.admin.name= data.fName+" "+data.lName
    this.admin.password=data.password
    this.admin.phoneNumber=data.mNumber

     this.adminService.adminRegister(this.admin).subscribe((data)=>{
      this.admin=data
      alert("succesfully registered")
      this.router.navigate(['/admin'])
     },err =>{
      alert("Admin Already Registered, you should login")
      this.router.navigate(['/admin-login'])
     })

    }
}
