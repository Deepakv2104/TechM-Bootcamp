import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr'; // Import ToastrService
import { ComputerService } from '../services/computer.service';

@Component({
  selector: 'app-add-computer',
  templateUrl: './add-computer.component.html',
  styleUrls: ['./add-computer.component.css']
})
export class AddComputerComponent implements OnInit {
  computerForm: FormGroup;
  minWarrantyDate!: string;

  constructor(
    private fb: FormBuilder,
    private computerService: ComputerService,
    private toastr: ToastrService // Inject ToastrService
  ) {
    this.computerForm = this.fb.group({
      brand: ['', Validators.required],
      model: ['', Validators.required],
      serialNumber: [''],
      cpu: ['', Validators.required],
      ram: [null, [Validators.required, Validators.min(1)]],
      storage: [null, [Validators.required, Validators.min(1)]],
      storageType: [''],
      gpu: ['', Validators.required],
      operatingSystem: [''],
      formFactor: [''],
      purchaseDate: [null, Validators.required],
      warrantyExpiryDate: [null, Validators.required],
      isAvailable: [true]
    }, {
      validators: this.warrantyExpiryDateValidator
    });
  }

  ngOnInit(): void {
    this.updateWarrantyMinDate();
  }

  onSubmit(): void {
    if (this.computerForm.valid) {
      this.computerService.addComputer(this.computerForm.value)
        .subscribe({
          next: (response) => {
            console.log('Computer added successfully:', response);
            this.showToast('success', 'Computer Added', 'Computer added successfully.');
            this.computerForm.reset();
          },
          error: (error) => {
            console.error('Error adding computer:', error);
            this.showToast('error', 'Error', 'Failed to add computer. Please try again.');
          }
        });
    } else {
      // Form is invalid, handle accordingly (e.g., display error messages)
    }
  }

  updateWarrantyMinDate(): void {
    const purchaseDateControl = this.computerForm.get('purchaseDate');
    if (purchaseDateControl && purchaseDateControl.value) {
      const purchaseDate = purchaseDateControl.value;
      const minDate = new Date(purchaseDate);
      minDate.setFullYear(minDate.getFullYear() + 1);
      this.minWarrantyDate = minDate.toISOString().split('T')[0];
    }
  }

  warrantyExpiryDateValidator(group: FormGroup): { [key: string]: any } | null {
    const purchaseDate = group.get('purchaseDate')?.value;
    const warrantyExpiryDate = group.get('warrantyExpiryDate')?.value;

    if (purchaseDate && warrantyExpiryDate && new Date(warrantyExpiryDate) < new Date(purchaseDate)) {
      return { 'invalidDate': true };
    }
    return null;
  }

  showToast(type: string, title: string, message: string): void {
    this.toastr.show(message, title, {
      closeButton: true,
      timeOut: 3000, // Toast timeout duration
      positionClass: 'toast-top-right', // Toast position
      progressBar: true, // Display a progress bar
      toastClass: `ngx-toastr toast-${type}`,
    });
  }
}
