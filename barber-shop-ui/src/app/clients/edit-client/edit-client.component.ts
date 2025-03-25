import { ClientModelForm } from './../client.models';
import { Component, Inject, OnDestroy, OnInit } from '@angular/core';
import { ClientsService } from '../../services/api-client/clients/clients.service';
import { SERVICES_TOKEN } from '../../services/service.token';
import { IClientService } from '../../services/api-client/clients/iclients.service';
import { SnackbarManagerService } from '../../services/snackbar-manager.service';
import { ISnackbarManagerService } from '../../services/isnackbar-manager.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ClientFormComponent } from '../components/client-form/client-form.component';

@Component({
  selector: 'app-edit-client',
  imports: [
    ClientFormComponent
  ],
  templateUrl: './edit-client.component.html',
  styleUrl: './edit-client.component.scss',
  providers: [
      { provide: SERVICES_TOKEN.HTTP.CLIENT, useClass: ClientsService },
      { provide: SERVICES_TOKEN.SNACKBAR, useClass: SnackbarManagerService }
    ],
})
export class EditClientComponent implements OnInit, OnDestroy{

  private httpsubcription?: Subscription[] = [];

  client: ClientModelForm = {id: 0, name: '', email: '', phone: ''};

  constructor(
    @Inject(SERVICES_TOKEN.HTTP.CLIENT) private readonly httpService: IClientService,
    @Inject(SERVICES_TOKEN.SNACKBAR) private readonly snackBarManager : ISnackbarManagerService,
    private readonly activedRoute: ActivatedRoute,
    private readonly router: Router
  ) {}

  ngOnDestroy(): void {
    if (this.httpsubcription) {
      this.httpsubcription.forEach(s => s.unsubscribe());
    }
  }

  ngOnInit(): void {
    const id = this.activedRoute.snapshot.paramMap.get('id');
    if (!id) {
      this.snackBarManager.show('Erroa ao recuperar informações do cliente')
      this.router.navigate(['clients/list'])
      return
    }
    this.httpsubcription?.push(this.httpService.findById(Number(id)).subscribe(data => this.client = data));
  }

  onSubmitClient(value: ClientModelForm) {
    const { id, ...request } = value
    if (id) {
      this.httpsubcription?.push(this.httpService.update(id, request).subscribe(_ => {
        this.snackBarManager.show('O usuário foi atualizado com sucesso')
        this.router.navigate(['clients/list'])
      }))
    }
    this.snackBarManager.show('Um erro inesperado aconteceu')
    this.router.navigate(['clients/list']);
  }
}
