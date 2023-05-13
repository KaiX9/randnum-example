import { Component, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { RandomNumberService } from './service/random-number.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  randSvc = inject(RandomNumberService)

  num$!: Observable<number[]>

  getRandomNumbers() {
    this.num$ = this.randSvc.getRandomNumbers()
  }
  
}
