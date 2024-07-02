import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  sidebarOpen = false;
  username: string = ''; // Initialize username variable

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.username = this.authService.getUsername() || '';
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/']);
  }

  toggleSidebar() {
    this.sidebarOpen = !this.sidebarOpen;
  }
}
