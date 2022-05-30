import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from "@angular/common/http";
import { environment } from 'src/environments/environment';
import { LocationModel } from '../../models/location.model';

@Injectable({
  providedIn: 'root'
})
export class MapboxService {


  constructor(private http: HttpClient) { }

  getAlldata(){
   return this.http.get<LocationModel[]>(`${environment.DATE_TO_PRINT_ON_MAP}`)
  }

  getGreen(){
    return this.http.get<LocationModel[]>(`${environment.GREEN_DATA}`)
  }

  getRed(){
    return this.http.get<LocationModel[]>(`${environment.RED_DATA}`)
  }

  getYellow(){
    return this.http.get<LocationModel[]>(`${environment.YELLOW_DATA}`)
  }

  getPurple(){
    return this.http.get<LocationModel[]>(`${environment.PURPLE_DATA}`)
  }
}
