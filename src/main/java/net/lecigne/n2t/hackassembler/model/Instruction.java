package net.lecigne.n2t.hackassembler.model;

import lombok.Getter;

@Getter
public abstract class Instruction {

    private InstructionType instructionType;

    public Instruction(InstructionType instructionType) {
        this.instructionType = instructionType;
    }

}
