import {Component, OnDestroy, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Subscription} from 'rxjs';
import {environment} from '../environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy {
  title = 'Chuck Norris App';
  joke = '';
  private subscribed: Subscription;

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.updateRandomJoke();
  }

  ngOnDestroy(): void {
    this.subscribed.unsubscribe();
  }

  next(): void {
    this.updateRandomJoke();
  }

  private updateRandomJoke(): void {
    this.subscribed = this.http.get(`http://${environment.apiUrl}/api/randomJoke`, {responseType: 'text'})
      .subscribe(data => this.joke = data);
  }
}
