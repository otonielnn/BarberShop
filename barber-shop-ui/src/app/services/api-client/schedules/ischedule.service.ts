import { Observable } from "rxjs";
import { ClientScheduleAppointmentResponse, SaveScheduleRequest } from "./schedule.models";

export interface IScheduleService {

  save(request: SaveScheduleRequest): Observable<SaveScheduleRequest>

  delete(id: number): Observable<void>

  listInMonth(year: number, month: number): Observable<ClientScheduleAppointmentResponse[]>
}
