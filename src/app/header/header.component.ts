import { Component, OnInit, OnDestroy } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { Subscription, interval } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnDestroy {
  isLoggedIn: boolean = false;
  sessionTimeLeft: number = 0; // Initialize to 0
  private timerSubscription: Subscription | undefined;
  private readonly SESSION_DURATION = 30 * 60; // 30 minutes in seconds

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    this.authService.isLoggedInObservable().subscribe((loggedIn: boolean) => {
      this.isLoggedIn = loggedIn;
      if (loggedIn) {
        this.startSessionTimer();
      } else {
        this.stopSessionTimer();
      }
    });
  }

  ngOnDestroy(): void {
    this.stopSessionTimer();
  }

  startSessionTimer(): void {
    const sessionStartTime = localStorage.getItem('sessionStartTime');
    const now = Math.floor(Date.now() / 1000); // Current time in seconds

    if (sessionStartTime) {
      const elapsedTime = now - parseInt(sessionStartTime, 10);
      this.sessionTimeLeft = this.SESSION_DURATION - elapsedTime;
    } else {
      localStorage.setItem('sessionStartTime', now.toString());
      this.sessionTimeLeft = this.SESSION_DURATION;
    }

    this.timerSubscription = interval(1000).subscribe(() => {
      this.sessionTimeLeft--;
      if (this.sessionTimeLeft <= 0) {
        this.logout(); // Automatically logout when session time is over
      }
    });
  }

  stopSessionTimer(): void {
    if (this.timerSubscription) {
      this.timerSubscription.unsubscribe();
    }
    localStorage.removeItem('sessionStartTime'); // Clear session start time on logout
  }

  logout(): void {
    this.authService.logout();
    this.router.navigate(['/']);
  }

  get formattedSessionTimeLeft(): string {
    const minutes = Math.floor(this.sessionTimeLeft / 60);
    const seconds = this.sessionTimeLeft % 60;
    return `${minutes}:${seconds < 10 ? '0' : ''}${seconds}`;
  }
}
