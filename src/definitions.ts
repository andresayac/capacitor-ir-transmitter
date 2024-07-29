export interface IrTransmitterPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
