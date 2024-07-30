import { WebPlugin } from '@capacitor/core';

import type { IrTransmitterPlugin } from './definitions';

export class IrTransmitterWeb extends WebPlugin implements IrTransmitterPlugin {
  async transmitIR(options: { frequency: number, address: number, command: number}): Promise<void> {
    console.log('Transmit IR', options);
  }
}
