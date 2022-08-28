import { Component, OnInit } from '@angular/core';
import { Question } from './../question';
import { UserService } from './../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
 

  
  constructor(private userService:UserService,private router:Router ) { }

  ngOnInit(): void {
   
  }

  isSearched:boolean=false

  questions:Question[] | undefined
  getValue(values:string){
    if(values !==''){
      this.userService.searchQuestion(values).subscribe((data)=>{
        console.log(data)
        this.questions=data
        if(data.length==0){
          console.log("No Question Found");
        }else{
        this.isSearched=true
        values =="";
      }
      
      })
    }
    else{
      this.questions=[]

    }
  }
  sendQuestionToGetAnswer(id:number){
    console.log(id)
    this.userService.getQuestionId(id)
    this.router.navigate(['/get-answer'])
    this.isSearched=false
    

  }


  
  
  
}

