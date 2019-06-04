import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Mejor Cocina';

  constructor(private router: Router) {}

  goToLink(link: string): void {
      this.router.navigateByUrl(link);
  }

  
}
