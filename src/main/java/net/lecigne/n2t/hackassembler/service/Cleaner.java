package net.lecigne.n2t.hackassembler.service;

public class Cleaner {

    private static final String COMMENT = "//";

    public String cleanLine(final String line) {
        String cleanLine = line;
        if (cleanLine.contains(COMMENT)) {
            cleanLine = cleanLine.substring(0, line.indexOf(COMMENT));
        }
        return cleanLine.trim();
    }

    public boolean isComment(final String line) {
        return line.trim().startsWith(COMMENT);
    }

}
