import { Component } from '@angular/core';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styles: [
    '.background {background: burlywood; color: black; font-size: 6rem }',
    'li {font-size: 3rem; padding: 0 25px}',
    'li a { color: darkcyan}',
    'ul.nav a:hover { color: red }',
    '.navbar {padding:4.5rem}',
]
})
export class HeaderComponent {
  constructor() {}

  }
