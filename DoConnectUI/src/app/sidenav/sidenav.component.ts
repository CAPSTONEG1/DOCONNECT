import { Component, OnInit } from '@angular/core';
import { UserService } from './../user.service';
import { Question } from '../question';
import { User } from '../user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit {

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.user = this.userService.giveUserData()
    this.getQuestions('all')
  }
  response:any
  questions: Question[] | undefined

  user = new User()

  getQuestions(topic: string) {
    this.userService.getQuestions(topic).subscribe((data) => {
      this.questions = data
      console.log("questions are " + this.questions)

    })
  }
  sendQuestionToGetAnswer(questionId: number) {
    this.userService.getQuestionId(questionId)
    this.router.navigate(['/question'])
  }
}





