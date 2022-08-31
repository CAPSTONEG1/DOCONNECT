import { Component, OnInit, Output ,EventEmitter} from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from './../user.service';
import { Answer } from './../answer';
import { Question } from './../question';
import { User } from '../user';


@Component({
  selector: 'app-uhead',
  templateUrl: './uhead.component.html',
  styleUrls: ['./uhead.component.css']
})
export class UheadComponent implements OnInit {
 
@Output() toggleSidebarForMe: EventEmitter<any> = new EventEmitter();
  constructor(private router:Router,private userService:UserService) { }

  ngOnInit(): void {
  }
  user= new User()
  response:any;
  toggleSidebar() {
    this.toggleSidebarForMe.emit();
  }
  userLogout( userId:number) {
    this.userService.userLogout(userId).subscribe((data)=>{
     this.response=data
    },err =>{
     this.user=new User()
     this.userService.sendUserData(this.user)
     this.router.navigate(["/login"])
    }
    )
 }
}
