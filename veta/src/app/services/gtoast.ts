import { Injectable } from '@angular/core';
import { MessageService } from 'primeng/api';

export interface ToastOptions {
  summary?: string;
  detail: string;
  life?: number;
  sticky?: boolean;
  closable?: boolean;
}

@Injectable({
  providedIn: 'root',
})
export class GToast {
  constructor(private messageService: MessageService) {}

  success(detail: string, options?: Partial<ToastOptions>): void {
    this.messageService.add({
      severity: 'success',
      summary: options?.summary ?? 'Éxito',
      detail,
      life: options?.life ?? 2000,
      sticky: options?.sticky ?? false,
      closable: options?.closable ?? true,
    });
  }

  info(detail: string, options?: Partial<ToastOptions>): void {
    this.messageService.add({
      severity: 'info',
      summary: options?.summary ?? 'Información',
      detail,
      life: options?.life ?? 3000,
      sticky: options?.sticky ?? false,
      closable: options?.closable ?? true,
    });
  }

  warn(detail: string, options?: Partial<ToastOptions>): void {
    this.messageService.add({
      severity: 'warn',
      summary: options?.summary ?? 'Advertencia',
      detail,
      life: options?.life ?? 4000,
      sticky: options?.sticky ?? false,
      closable: options?.closable ?? true,
    });
  }

  error(detail: string, options?: Partial<ToastOptions>): void {
    this.messageService.add({
      severity: 'error',
      summary: options?.summary ?? 'Error',
      detail,
      life: options?.life ?? 5000,
      sticky: options?.sticky ?? false,
      closable: options?.closable ?? true,
    });
  }

  secondary(detail: string, options?: Partial<ToastOptions>): void {
    this.messageService.add({
      severity: 'secondary',
      summary: options?.summary ?? 'Aviso',
      detail,
      life: options?.life ?? 2000,
      sticky: options?.sticky ?? false,
      closable: options?.closable ?? true,
    });
  }

  contrast(detail: string, options?: Partial<ToastOptions>): void {
    this.messageService.add({
      severity: 'contrast',
      summary: options?.summary ?? 'Notificación',
      detail,
      life: options?.life ?? 3000,
      sticky: options?.sticky ?? false,
      closable: options?.closable ?? true,
    });
  }

  clear(): void {
    this.messageService.clear();
  }
}
