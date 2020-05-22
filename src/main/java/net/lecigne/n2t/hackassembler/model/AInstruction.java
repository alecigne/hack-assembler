package net.lecigne.n2t.hackassembler.model;

import lombok.Getter;
import net.lecigne.n2t.hackassembler.service.BinaryConverter;

@Getter
public class AInstruction implements Instruction {

    private String address;

    public AInstruction(String address) {
        this.address = address;
    }

    @Override
    public String accept(BinaryConverter converter) {
        return converter.convert(this);
    }
}
