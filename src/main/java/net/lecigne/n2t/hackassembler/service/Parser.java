package net.lecigne.n2t.hackassembler.service;

import net.lecigne.n2t.hackassembler.exception.ParsingException;
import net.lecigne.n2t.hackassembler.model.AInstruction;
import net.lecigne.n2t.hackassembler.model.CInstruction;
import net.lecigne.n2t.hackassembler.model.Instruction;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements Function<String, Instruction> {

    private static final String AT = "@";

    private static final String CINSTRUCTION_REGEX = "(?:([^=]+)=)?([^;]+)(?:;([A-Z]{3}))?";

    @Override
    public Instruction apply(String line) {
        if (isAInstruction(line)) {
            return parseAInstruction(line);
        } else {
            return parseCInstruction(line);
        }
    }

    private AInstruction parseAInstruction(String line) {
        return new AInstruction(line.substring(1));
    }

    private CInstruction parseCInstruction(String line) {
        Pattern p = Pattern.compile(CINSTRUCTION_REGEX);
        Matcher m = p.matcher(line);
        if (m.matches()) {
            return new CInstruction(m.group(1), m.group(2), m.group(3));
        } else {
            throw new ParsingException("No match during parsing of C-Instruction");
        }
    }

    private boolean isAInstruction(String cleanLine) {
        return cleanLine.startsWith(AT);
    }

}
