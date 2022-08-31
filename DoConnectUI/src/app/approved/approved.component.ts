import { Component, OnInit } from '@angular/core';
import { Question } from './../question';
import { Router } from '@angular/router';
import { AdminService } from './../admin.service';
import { Answer } from './../answer';


@Component({
  selector: 'app-approved',
  templateUrl: './approved.component.html',
  styleUrls: ['./approved.component.css']
})
export class ApprovedComponent implements OnInit {

  constructor(private router:Router, private adminService:AdminService  ) { }

  ngOnInit(): void {
  }

  question = new Question()
  answer=new Answer()
  questions:Question[] | undefined
  answerThere:boolean=false
  questionThere:boolean=false
  userThere:boolean=false
  response:any
  answers:Answer[] | undefined
  
  approveAnswer(answerId:number)
  {
    this.adminService.approveAnswer(answerId).subscribe((data)=>
    {
      this.answer=data
      alert("Answer Approved")
      this.getUnApprovedAnswers()
      this.router.navigate(['/approved'])
    })
  }
 deleteAnswer(answerId:number)
  {
    this.adminService.deleteAnswer(answerId).subscribe((data)=>
    {
      this.response=data
      this.getUnApprovedAnswers()
      this.router.navigate(['/approved'])
    })
  }
  getUnApprovedAnswers()
  {
    this.adminService.getUnApprovedAnswers().subscribe((data)=>
    {
      console.log(data)
      this.answers=data
      if(data.length!==0)
        this.answerThere=true
      else
        alert("No answers to approve")
    })
  }
}
