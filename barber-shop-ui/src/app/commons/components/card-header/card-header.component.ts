import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatCardHeader, MatCard, MatCardTitle } from '@angular/material/card';

@Component({
  selector: 'app-card-header',
  imports: [
    CommonModule,
    MatCard,
    MatCardHeader,
    MatCardTitle
  ],
  templateUrl: './card-header.component.html',
  styleUrl: './card-header.component.scss'
})
export class CardHeaderComponent {

}
