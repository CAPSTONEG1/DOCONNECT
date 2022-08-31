import { Component, OnInit } from '@angular/core';
import { Question } from './../question';
import { Router } from '@angular/router';
import { AdminService } from './../admin.service';

@Component({
  selector: 'app-unapproved',
  templateUrl: './unapproved.component.html',
  styleUrls: ['./unapproved.component.css']
})
export class UnapprovedComponent implements OnInit {

  constructor(private router:Router, private adminService:AdminService ) { }

  ngOnInit(): void {
  }

  question = new Question()
  questions:Question[] | undefined
  answerThere:boolean=false
  questionThere:boolean=false
  userThere:boolean=false
  response:any



  approveQuestion(questionId:number)
  {
    this.adminService.approveQuestion(questionId).subscribe((data)=>
    {
      this.question=data
      alert("Question Approved")
      this.getUnApprovedQuestions()   
      this.router.navigate(['/admin'])
    })
  }

  getUnApprovedQuestions()
  {
     this.adminService.getUnApprovedQuestions().subscribe((data)=>
     {
       console.log(data)
       this.questions=data
       if(data.length!==0)
         this.questionThere=true
       else
         alert("No Questions to approve")
    })
 }

 deleteQuestion(questionId:number)
  {
    this.adminService.deleteQuestion(questionId).subscribe((data)=>
    {
      this.response=data
      this.getUnApprovedQuestions()
      this.router.navigate(['/unapproved'])
    })
  }


}