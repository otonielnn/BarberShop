import { Observable } from "rxjs";
import {SaveScheduleRequest } from "./schedule.models";
import { ScheduleAppointmentMonthModel } from "../../../schedules/schedule.models";

export interface IScheduleService {

  save(request: SaveScheduleRequest): Observable<SaveScheduleRequest>

  delete(id: number): Observable<void>

  listInMonth(year: number, month: number): Observable<ScheduleAppointmentMonthModel>
}
