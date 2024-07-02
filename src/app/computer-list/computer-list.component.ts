import { Component, OnInit } from '@angular/core';
import { ComputerService } from '../services/computer.service';
import { Computer } from './computer.model';  // Ensure Computer model is imported correctly
import { Router } from '@angular/router';

@Component({
  selector: 'app-computer-list',
  templateUrl: './computer-list.component.html',
  styleUrls: ['./computer-list.component.css']
})
export class ComputerListComponent implements OnInit {
  computers: Computer[] = [];
  filteredComputers: Computer[] = [];
  uniqueBrands: string[] = [];
  totalComputers: number = 0;
  availableComputers: number = 0;
  searchTerm: string = '';
  sidebarOpen=false;
  selectedBrand: string = '';
  selectedAvailability: string = '';
  constructor(private computerService: ComputerService, private router: Router) { }

  ngOnInit(): void {
    this.loadComputers();
  }

  loadComputers(): void {
    this.computerService.getAllComputers().subscribe((data: Computer[]) => {
      this.computers = data;
      this.filteredComputers = data;
      this.totalComputers = data.length;
      this.availableComputers = data.filter(computer => computer.available).length;
      this.uniqueBrands = [...new Set(data.map(computer => computer.brand))];
    });
  }
  filterComputers(): void {
    this.filteredComputers = this.computers.filter(computer => {
      const matchesSearchTerm = this.searchTerm === '' ||
        computer.id.toString().includes(this.searchTerm) ||
        (computer.serialNumber && computer.serialNumber.includes(this.searchTerm)) ||
        computer.model.includes(this.searchTerm) ||
        computer.brand.includes(this.searchTerm);
      const matchesBrand = this.selectedBrand === '' || computer.brand === this.selectedBrand;
      const matchesAvailability = this.selectedAvailability === '' || 
        (this.selectedAvailability === 'true' && computer.available) ||
        (this.selectedAvailability === 'false' && !computer.available);
      return matchesSearchTerm && matchesBrand && matchesAvailability;
    });
  }
  editComputer(computer: Computer): void {
    // Navigate to edit computer page with computer id
    this.router.navigate(['/dashboard/inventory/edit', computer.id]);
  }

  deleteComputer(id: number): void {
    this.computerService.deleteComputer(id).subscribe(() => {
      // After deletion, reload the list of computers
      this.loadComputers();
      location.reload();
    });
  }

  toggleSidebar(): void {
    this.sidebarOpen = !this.sidebarOpen;
  }
}
