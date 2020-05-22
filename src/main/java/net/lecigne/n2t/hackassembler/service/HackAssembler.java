package net.lecigne.n2t.hackassembler.service;

import net.lecigne.n2t.hackassembler.model.Instruction;

import java.util.Optional;
import java.util.function.UnaryOperator;

public class HackAssembler implements UnaryOperator<String> {

    private final Parser parser;

    private final BinaryConverter converter;

    public HackAssembler(Parser parser, BinaryConverter converter) {
        this.parser = parser;
        this.converter = converter;
    }

    @Override
    public String apply(String line) {
        Optional<Instruction> optionalInstruction = parser.parse(line);
        return optionalInstruction.map(converter::convert).orElse("");
    }
}
