declare module '@capacitor/core' {
  interface PluginRegistry {
    IrTransmitter: IrTransmitterPlugin;
  }
}

export interface IrTransmitterPlugin {
  transmitIR(options: { frequency: number, address: number, command: number }): Promise<void>;
}
