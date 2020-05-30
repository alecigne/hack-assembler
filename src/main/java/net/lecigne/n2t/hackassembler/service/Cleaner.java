package net.lecigne.n2t.hackassembler.service;

import java.util.function.UnaryOperator;

public class Cleaner implements UnaryOperator<String> {

    private static final String COMMENT = "//";

    @Override
    public String apply(final String line) {
        String cleanLine = line;
        if (cleanLine.contains(COMMENT)) {
            cleanLine = cleanLine.substring(0, line.indexOf(COMMENT));
        }
        return cleanLine.trim();
    }

}
