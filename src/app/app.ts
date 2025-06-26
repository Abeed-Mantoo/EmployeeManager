import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { EmployeeService } from './employee.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Employee } from './employee';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms'; 

@Component({
  selector: 'app-root',
  // standalone: true,
  imports: [CommonModule, RouterOutlet, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  public employees: Employee[] = [];
  constructor(private employeeService:EmployeeService){}

  ngOnInit() {
      this.getEmployees();
  }
  public getEmployees():void{
    this.employeeService.getEmployees().subscribe(
      (response:Employee[])=>{
        this.employees=response;
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }

  public onAddEmployee(addForm: NgForm): void{
    document.getElementById('add-employee-form')?.click();
    this.employeeService.addEmployee(addForm.value).subscribe(
      (response:Employee)=>{
        console.log(response);
        this.getEmployees();
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    );
    
  }

  public onOpenModal(employee:Employee|null,mode:string):void{
     const container=document.getElementById('main-container');
     if(container){
     const button=document.createElement('button');
     button.type='button';
     button.style.display='none';
     button.setAttribute('data-toggle','modal');
     if(mode==='add'){
      button.setAttribute('data-target','#addEmployeeModal');
     }
     if(mode==='edit'){
      button.setAttribute('data-target','#updateEmployeeModal');
     }
     if(mode==='delete'){
      button.setAttribute('data-target','#deleteEmployeeModal');
     }
     container.appendChild(button);
     button.click();
    }
  }

}
