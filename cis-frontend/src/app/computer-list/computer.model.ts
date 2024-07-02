export interface Computer {
  id: number;
  brand: string;
  model: string;
  serialNumber: string | null;
  cpu: string;
  ram: number;
  storage: number;
  storageType: string | null;
  gpu: string;
  operatingSystem: string | null;
  formFactor: string | null;
  available: boolean;
  purchaseDate: Date | null;
  warrantyExpiryDate: Date | null;
}
