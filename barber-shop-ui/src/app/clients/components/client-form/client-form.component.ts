import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ClientModelForm } from '../../client.models';
import { FormsModule, NgForm } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { NgxMaskDirective } from 'ngx-mask';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-client-form',
  imports: [
    CommonModule,
    FormsModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    NgxMaskDirective,
],
  templateUrl: './client-form.component.html',
  styleUrl: './client-form.component.scss',
})
export class ClientFormComponent {

  @Input() client: ClientModelForm = {id: 0, name: '', email: '', phone: ''};

  @Output() clientSubmited = new EventEmitter<ClientModelForm>();

  onSubmit(_: NgForm) {
    console.log(this.client);
    this.clientSubmited.emit(this.client);
  }
}
