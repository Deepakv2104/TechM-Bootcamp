import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ComputerService {

  private baseUrl = 'http://localhost:8080/inventory';

  constructor(private http: HttpClient) { }

  getAllComputers(): Observable<any> {
    return this.http.get(`${this.baseUrl}/allComputers`).pipe(
      catchError(this.handleError)
    );
  }

  getComputersByBrand(brand: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/brand/${brand}`).pipe(
      catchError(this.handleError)
    );
  }

  getComputerById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/get/${id}`).pipe(
      catchError(this.handleError)
    );
  }

  addComputer(computer: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/add`, computer).pipe(
      catchError(this.handleError)
    );
  }

  updateComputer(id: number, computer: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/edit/${id}`, computer).pipe(
      catchError(this.handleError)
    );
  }

  deleteComputer(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse): Observable<any> {
    if (error.error instanceof ErrorEvent) {
      // Client-side error
      console.error('An error occurred:', error.error.message);
    } else {
      // Server-side error
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${JSON.stringify(error.error)}`); // Log the error body as JSON
    }
    // Return an observable with a user-facing error message
    return throwError('Something bad happened; please try again later.');
  }
}
