export interface Models {
  id: number;
  email: string;
  phone: string;
  name: string;
  realEstates: RealEstate[];
}

export interface RealEstate {
  id: number;
  level: number;
  participation: number;
  realEstateNumber: string;
  realEstateType: RealEstateType;
}

export enum RealEstateType {
  FLAT, GARAGE
}

export interface Resolution {
  symbolNumber: string;
  title: string;
  content: string;
}
