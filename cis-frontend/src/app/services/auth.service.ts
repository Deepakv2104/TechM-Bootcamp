import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080'; // Adjust this to your Spring Boot API URL
  private loggedInSubject: BehaviorSubject<boolean>;

  constructor(private http: HttpClient) {
    this.loggedInSubject = new BehaviorSubject<boolean>(this.isLoggedIn());
  }

  login(username: string, password: string): Observable<{ token: string }> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.post<{ token: string }>(`${this.apiUrl}/authenticate`,
      { username, password },
      { headers: headers }
    ).pipe(
      tap(response => {
        if (response && response.token) {
          localStorage.setItem('token', response.token);
          this.loggedInSubject.next(true); // Update logged in status
        }
      })
    );
  }

  register(username: string, password: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, { username, password });
  }

  logout(): void {
    localStorage.removeItem('token');
    this.loggedInSubject.next(false); // Update logged in status
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('token');
  }

  isLoggedInObservable(): Observable<boolean> {
    return this.loggedInSubject.asObservable();
  }

  getUsername(): string | null {
    const token = this.getToken();
    if (token) {
      const decodedToken = this.decodeToken(token);
      return decodedToken ? decodedToken.sub : null; // Assuming 'sub' contains the username in your JWT payload
    }
    return null;
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }
   private decodeToken(token: string): any {
    try {
      const jwtPayload = JSON.parse(atob(token.split('.')[1]));
      return jwtPayload;
    } catch (error) {
      console.error('Error decoding token');
      return null;
    }
  }
}
