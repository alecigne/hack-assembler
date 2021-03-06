package net.lecigne.n2t.hackassembler.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assembler {

    private final Cleaner cleaner;

    private final Parser parser;

    private final Converter converter;

    private static final String HACK_EXTENSION = ".hack";

    public Assembler(Cleaner cleaner, Parser parser, Converter converter) {
        this.cleaner = cleaner;
        this.parser = parser;
        this.converter = converter;
    }

    @SuppressWarnings("squid:S106") // System.err.println is OK for this CLI app
    public void assembleFile(String sourcePath) {
        try (Stream<String> s = Files.lines(Paths.get(sourcePath))) {
            List<String> binaryInstructions = s
                    .map(cleaner)
                    .filter(StringUtils::isNotBlank)
                    .map(parser)
                    .map(converter)
                    .collect(Collectors.toList());
            if (!binaryInstructions.isEmpty()) {
                Files.write(Paths.get(FilenameUtils.removeExtension(sourcePath) + HACK_EXTENSION), binaryInstructions);
            }
        } catch (IOException e) {
            System.err.println("I/O error while assembling file.");
        }
    }

}
