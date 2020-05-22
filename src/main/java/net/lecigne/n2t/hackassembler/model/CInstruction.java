package net.lecigne.n2t.hackassembler.model;

import lombok.Getter;
import net.lecigne.n2t.hackassembler.service.BinaryConverter;

@Getter
public class CInstruction implements Instruction {

    private String dest;

    private String comp;

    private String jmp;

    public CInstruction(String dest, String comp, String jmp) {
        this.dest = dest;
        this.comp = comp;
        this.jmp = jmp;
    }

    @Override
    public String accept(BinaryConverter converter) {
        return converter.convert(this);
    }

}
