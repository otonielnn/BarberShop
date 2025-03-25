import { Routes } from '@angular/router';
import { EditClientComponent } from './clients/edit-client/edit-client.component';
import { NewClientComponent } from './clients/new-client/new-client.component';
import { ListClientsComponent } from './clients/list-clients/list-clients.component';
import { ScheduleCalendarComponent } from './schedules/components/schedule-calendar/schedule-calendar.component';

export const routes: Routes = [
  {path: 'clients/edit-client/:id', component: EditClientComponent, data: {title: 'Atualizar Cliente'}},
  {path: 'clients/new-client', component: NewClientComponent, data: {title: 'Cadastrar Cliente'}},
  {path: 'clients/list', component: ListClientsComponent, data: {title: 'Clientes Cadastrados'}},
  {path: 'schedules/month', component: ScheduleCalendarComponent, data: {title: 'Agendamentos'}},
  {path: '**', redirectTo: 'schedules/month'},
];
