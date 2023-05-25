import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { caregiverList } from '../caregiver/caregiverList';

@Injectable({
  providedIn: 'root'
})
export class CaregiverService {
  private getUrl: string = "http://localhost:8083/cares/all";
  constructor(private http:HttpClient) {}
  getCare(): Observable<caregiverList[]> {
    return this.http.get<caregiverList[]>(this.getUrl).pipe(
      map(response => response)
    )
  }
}