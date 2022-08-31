import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AllQuestionsComponent } from './all-questions/all-questions.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatCardModule} from '@angular/material/card';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminRegisterComponent } from './admin-register/admin-register.component';
import { AskQuestionComponent } from './ask-question/ask-question.component';

import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { FormsModule } from '@angular/forms';
import { ChatComponent } from './chat/chat.component';
import { GetAnswerComponent } from './get-answer/get-answer.component';
import { HomeComponent } from './home/home.component';
import { FooterComponentComponent } from './footer/footer-component.component';
import { SearchComponent } from './search/search.component';
import { HeaderComponent } from './header/header.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { Sidenav1Component } from './sidenav1/sidenav1.component';
import { UheadComponent } from './uhead/uhead.component';
import {MatMenuModule }  from '@angular/material/menu';

import {MatIconModule } from '@angular/material/icon';

import {MatDividerModule} from '@angular/material/divider';

import {MatListModule } from '@angular/material/list';
import { MatToolbarModule } from '@angular/material/toolbar';
import { UHomeComponent } from './uhome/uhome.component';
import { AheadComponent } from './ahead/ahead.component';
import { UnapprovedComponent } from './unapproved/unapproved.component';
import { ApprovedComponent } from './approved/approved.component';
import { GetUsersComponent } from './get-users/get-users.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    AllQuestionsComponent,
    AdminLoginComponent,
    AdminRegisterComponent,
    AskQuestionComponent,

    AdminComponent,
    UserComponent,
    ChatComponent,
    GetAnswerComponent,
    HomeComponent,
    FooterComponentComponent,
    SearchComponent,
    HeaderComponent,
    SidenavComponent,
    Sidenav1Component,
    UheadComponent,
    UHomeComponent,
    AheadComponent,
    UnapprovedComponent,
    ApprovedComponent,
    GetUsersComponent,
   
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatCardModule,
    MatSidenavModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatMenuModule,
    MatIconModule,
    MatDividerModule ,
    MatListModule,
    MatToolbarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
