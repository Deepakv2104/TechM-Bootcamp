import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class ComputerService {

  private baseUrl = 'http://localhost:8080/inventory';

  constructor(private http: HttpClient, private toastr: ToastrService) { }

  getAllComputers(): Observable<any> {
    return this.http.get(`${this.baseUrl}/allComputers`).pipe(
      catchError((error: HttpErrorResponse) => {
        this.handleError(error);
        return throwError('Failed to fetch computers');
      })
    );
  }

  getComputersByBrand(brand: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/brand/${brand}`).pipe(
      catchError((error: HttpErrorResponse) => {
        this.handleError(error);
        return throwError(`Failed to fetch computers by brand ${brand}`);
      })
    );
  }

  getComputerById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/get/${id}`).pipe(
      catchError((error: HttpErrorResponse) => {
        this.handleError(error);
        return throwError(`Failed to fetch computer with ID ${id}`);
      })
    );
  }

  addComputer(computer: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/add`, computer).pipe(
      catchError((error: HttpErrorResponse) => {
        this.handleError(error);
        return throwError('Failed to add computer');
      })
    );
  }

  updateComputer(id: number, computer: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/edit/${id}`, computer).pipe(
      catchError((error: HttpErrorResponse) => {
        this.handleError(error);
        return throwError(`Failed to update computer with ID ${id}`);
      })
    );
  }

  deleteComputer(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`).pipe(
      catchError((error: HttpErrorResponse) => {
        this.handleError(error);
        return throwError(`Failed to delete computer with ID ${id}`);
      })
    );
  }

  private handleError(error: HttpErrorResponse): void {
    if (error.error instanceof ErrorEvent) {
      // Client-side error
      console.error('An error occurred:', error.error.message);
    } else {
      // Server-side error
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${JSON.stringify(error.error)}`
      );
      this.showToast('error', 'Error', error.error.text || 'Server error occurred');
    }
  }

  private showToast(type: 'success' | 'error', title: string, message: string): void {
    if (type === 'success') {
      this.toastr.success(message, title, {
        closeButton: true,
        timeOut: 3000,
        positionClass: 'toast-top-right',
        progressBar: true,
      });
    } else if (type === 'error') {
      this.toastr.error(message, title, {
        closeButton: true,
        timeOut: 3000,
        positionClass: 'toast-top-right',
        progressBar: true,
      });
    }
  }
}
