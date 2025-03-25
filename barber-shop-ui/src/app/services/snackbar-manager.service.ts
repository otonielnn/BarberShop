import { Injectable } from '@angular/core';
import { ISnackbarManagerService } from './isnackbar-manager.service';

@Injectable({
  providedIn: 'root'
})
export class SnackbarManagerService implements ISnackbarManagerService {

  constructor() { }
  show(message: string, action?: string, duration?: number): void {
    throw new Error('Method not implemented.');
  }
}
