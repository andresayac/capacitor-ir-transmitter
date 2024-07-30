package io.github.andresayac.irtransmitter;

import android.content.Context;
import android.hardware.ConsumerIrManager;
import android.util.Log;
import java.util.List;

public class IrTransmitter {

    private ConsumerIrManager irManager;

    public IrTransmitter(Context context) {
        this.irManager = (ConsumerIrManager) context.getSystemService(Context.CONSUMER_IR_SERVICE);
    }

    public boolean hasIrEmitter() {
        return irManager != null && irManager.hasIrEmitter();
    }

    public void transmit(int frequency, int address, int command) {
        if (hasIrEmitter()) {
            NecTransformer transformer = new NecTransformer();
            List<Integer> pulses = transformer.transformMessage(address, command);
            
            int[] pattern = new int[pulses.size()];
            for (int i = 0; i < pulses.size(); i++) {
                pattern[i] = pulses.get(i);
            }
            irManager.transmit(frequency, pattern);
        } else {
            Log.e("IrTransmitter", "No IR emitter found on this device");
        }
    }
}
