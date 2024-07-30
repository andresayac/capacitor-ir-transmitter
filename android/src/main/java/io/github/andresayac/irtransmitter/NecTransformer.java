package io.github.andresayac.irtransmitter;

import java.util.ArrayList;
import java.util.List;

class NecTransformer {

    public List<Integer> transformMessage(int address, int command) {
        List<Integer> pulses = new ArrayList<>();
        pulses.addAll(initMessage());
        pulses.addAll(transformByte(address & 0xff));
        pulses.addAll(transformByte((address & 0xff00) >> 8));
        pulses.addAll(transformByte(command));
        pulses.addAll(transformByte(~command));
        pulses.addAll(finishMessage());
        pulses.add(560);
        return pulses;
    }

    private List<Integer> initMessage() {
        List<Integer> list = new ArrayList<>();
        list.add(9000);
        list.add(4500);
        return list;
    }

    private List<Integer> transformByte(int value) {
        List<Integer> pulses = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if ((value & 1) == 1) {
                pulses.addAll(mark());
            } else {
                pulses.addAll(space());
            }
            value >>= 1;
        }
        return pulses;
    }

    private List<Integer> finishMessage() {
        List<Integer> list = new ArrayList<>();
        list.add(560);
        return list;
    }

    private List<Integer> mark() {
        List<Integer> list = new ArrayList<>();
        list.add(560);
        list.add(1680);
        return list;
    }

    private List<Integer> space() {
        List<Integer> list = new ArrayList<>();
        list.add(560);
        list.add(560);
        return list;
    }
}
