import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  username: string = '';
  password: string = '';
  confirmPassword: string = '';
  errorMessage: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    if (this.password !== this.confirmPassword) {
      this.errorMessage = 'Passwords do not match';
      return;
    }
    
    this.authService.register(this.username, this.password).subscribe({
      next: (response) => {
        console.log('Registration successful', response);
        this.errorMessage = '';
        this.router.navigate(['/authenticate']);  // Redirect to /authenticate after successful registration
      },
      error: (error) => {
        console.error('Registration failed', error);
        this.errorMessage = error.error || 'Registration failed';
      }
    });
  }
}
