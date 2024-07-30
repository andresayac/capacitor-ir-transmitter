package io.github.andresayac.irtransmitter;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.json.JSONException;

@CapacitorPlugin(name = "IrTransmitter")
public class IrTransmitterPlugin extends Plugin {

    private IrTransmitter implementation;

    @Override
    public void load() {
        super.load();
        implementation = new IrTransmitter(getContext());
    }

    @PluginMethod
    public void transmitIR(PluginCall call) throws JSONException {
        Integer frequency = call.getInt("frequency");
        Integer address = call.getInt("address");
        Integer command = call.getInt("command");
    
        if (frequency == null || address == null || command == null) {
            call.reject("Frequency and address or  are required");
            return;
        }

        if (implementation.hasIrEmitter()) {
            implementation.transmit(frequency, address, command);
            call.resolve();
        } else {
            call.reject("No IR emitter found on this device");
        }
    }
}
