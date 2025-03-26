import { Injectable } from '@angular/core';
import { IScheduleService } from './ischedule.service';
import { Observable } from 'rxjs';
import { SaveScheduleRequest, ClientScheduleAppointmentResponse } from './schedule.models';
import { environment } from '../../../../environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SchedulesService implements IScheduleService{

  private readonly basePath = environment.apiUrl

  constructor(private http: HttpClient) { }

  save(request: SaveScheduleRequest): Observable<SaveScheduleRequest> {
    return this.http.post<SaveScheduleRequest>(`${this.basePath}schedules`, request);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.basePath}schedules/${id}`);
  }
  listInMonth(year: number, month: number): Observable<ClientScheduleAppointmentResponse[]> {
    return this.http.get<ClientScheduleAppointmentResponse[]>(`${this.basePath}schedules/${year}/${month}`);
  }
}
