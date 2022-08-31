import { Component, OnInit ,Output,EventEmitter} from '@angular/core';
import { AdminService } from './../admin.service';
import { Admin } from '../admin';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ahead',
  templateUrl: './ahead.component.html',
  styleUrls: ['./ahead.component.css']
})
export class AheadComponent implements OnInit {
  @Output() toggleSidebarForMe: EventEmitter<any> = new EventEmitter();

  constructor(private router:Router,private adminService:AdminService) { }

  ngOnInit(): void {
  }
  admin=new Admin()
  response:any;
  toggleSidebar() {
    this.toggleSidebarForMe.emit();
  }
  adminLogout(adminId:number)
  {
     this.adminService.adminLogout(adminId).subscribe((data)=>
     {
      this.response=(data)
     }, err =>
     {
      console.log("error called"+err)
      this.admin=new Admin()
      this.adminService.sendAdminData(this.admin)
      this.router.navigate(['/admin-login'])
     })
   }

}
