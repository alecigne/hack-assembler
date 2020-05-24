package net.lecigne.n2t.hackassembler.model;

import lombok.Getter;

@Getter
public class AInstruction extends Instruction {

    private String address;

    public AInstruction(String address) {
        super(InstructionType.A);
        this.address = address;
    }

}
