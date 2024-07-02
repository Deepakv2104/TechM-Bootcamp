import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ComputerListComponent } from './computer-list/computer-list.component';
import { AddComputerComponent } from './add-computer/add-computer.component';
import { EditComputerComponent } from './edit-computer/edit-computer.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  { path: 'authenticate', component: LoginComponent },
  { path: 'register', component: SignupComponent },
  { path: '', redirectTo: '/authenticate', pathMatch: 'full' },
  { 
    path: 'dashboard', 
    component: DashboardComponent,
    children: [
      { path: '', redirectTo: 'inventory/allComputers', pathMatch: 'full' },
      { path: 'inventory/allComputers', component: ComputerListComponent },
      { path: 'inventory/addComputer', component: AddComputerComponent },
      { path: 'inventory/edit/:id', component: EditComputerComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
