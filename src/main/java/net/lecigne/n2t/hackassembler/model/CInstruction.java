package net.lecigne.n2t.hackassembler.model;

import lombok.Getter;

@Getter
public class CInstruction extends Instruction {

    private String dest;

    private String comp;

    private String jump;

    public CInstruction(String dest, String comp, String jump) {
        super(InstructionType.C);
        this.dest = dest;
        this.comp = comp;
        this.jump = jump;
    }

}
