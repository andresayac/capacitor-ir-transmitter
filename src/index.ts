import { registerPlugin } from '@capacitor/core';

import type { IrTransmitterPlugin } from './definitions';

const IrTransmitter = registerPlugin<IrTransmitterPlugin>('IrTransmitter', {
  web: () => import('./web').then(m => new m.IrTransmitterWeb()),
});

export * from './definitions';
export { IrTransmitter };
