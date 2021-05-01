import {RealEstatesComponent} from '../pages/real-estates/real-estates.component';

export interface Owner {
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

export enum RealEstateType{
  FLAT, GARAGE
}
