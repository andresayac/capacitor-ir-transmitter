import { WebPlugin } from '@capacitor/core';

import type { IrTransmitterPlugin } from './definitions';

export class IrTransmitterWeb extends WebPlugin implements IrTransmitterPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
