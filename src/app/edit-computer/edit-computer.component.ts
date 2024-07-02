import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ComputerService } from '../services/computer.service';
import { Computer } from '../computer-list/computer.model';

@Component({
  selector: 'app-edit-computer',
  templateUrl: './edit-computer.component.html',
  styleUrls: ['./edit-computer.component.css']
})
export class EditComputerComponent implements OnInit {
  computerId!: number;
  isBasicInfoOpen: boolean = true;
  isHardwareSpecsOpen: boolean = false;
  isOtherInfoOpen: boolean = false;
  successMessage: string = ''; // Success message state
  errorMessage: string = ''; // Error message state

  computer: Computer = {
    id:0,
    brand: '',
    model: '',
    serialNumber: '',
    cpu: '',
    ram: 0,
    storage: 0,
    storageType: '',
    gpu: '',
    operatingSystem: '',
    formFactor: '',
    available: false,
    purchaseDate: null,
    warrantyExpiryDate: null,
  };

  constructor(
    private route: ActivatedRoute,
    private computerService: ComputerService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.computerId = +this.route.snapshot.paramMap.get('id')!;
    this.loadComputer();
  }

  loadComputer(): void {
    this.computerService.getComputerById(this.computerId).subscribe(
      (computer) => {
        this.computer = computer;
      },
      (error) => {
        console.error('Error fetching computer', error);
        // Show an error message to the user
        this.errorMessage = 'Error loading computer details. Please try again later.';
      }
    );
  }

  toggleSection(section: string) {
    if (section === 'basicInfo') {
      this.isBasicInfoOpen = !this.isBasicInfoOpen;
    } else if (section === 'hardwareSpecs') {
      this.isHardwareSpecsOpen = !this.isHardwareSpecsOpen;
    } else if (section === 'otherInfo') {
      this.isOtherInfoOpen = !this.isOtherInfoOpen;
    }
  }

  onSubmit(): void {
    this.computerService.updateComputer(this.computerId, this.computer).subscribe(
      (response) => {
        console.log('Update successful', response);
        // Reset section states
        this.isBasicInfoOpen = true;
        this.isHardwareSpecsOpen = false;
        this.isOtherInfoOpen = false;
        // Show success message
        this.successMessage = 'Update successful!';
        // Clear error message
        this.errorMessage = '';
        // Optionally navigate to another page
        this.router.navigateByUrl('/dashboard/inventory/allComputers');
      },
      (error) => {
        console.error('Error updating computer', error);
        // Show an error message to the user
        this.errorMessage = 'Error updating computer. Please try again later.';
        // Clear success message
        this.successMessage = '';
      }
    );
  }
}
