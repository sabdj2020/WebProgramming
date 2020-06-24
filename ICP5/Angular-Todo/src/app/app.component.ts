import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'My Todo List For SUMMER 2020';
  title2 = 'COUNTDOWN TIMER';
  todolist = [];
  addTodo(newTodoname){
    var newTodo = {
      todoname:newTodoname,
      done: false,
      priority: 1
    };
    this.todolist.push((newTodo));
  }
  deleteTodo(todo){
    this.todolist = this.todolist.filter(t => t.todoname !== todo.todoname);

  }
}



