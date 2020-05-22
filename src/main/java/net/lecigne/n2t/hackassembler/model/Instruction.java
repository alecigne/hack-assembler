package net.lecigne.n2t.hackassembler.model;

import net.lecigne.n2t.hackassembler.service.BinaryConverter;

public interface Instruction {

    String accept(BinaryConverter converter);

}
