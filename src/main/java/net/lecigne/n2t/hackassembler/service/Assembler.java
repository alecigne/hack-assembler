package net.lecigne.n2t.hackassembler.service;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class Assembler {

    private final Cleaner cleaner;

    private final Parser parser;

    private final Converter converter;

    public Assembler(Cleaner cleaner, Parser parser, Converter converter) {
        this.cleaner = cleaner;
        this.parser = parser;
        this.converter = converter;
    }

    public void assembleFile(String sourcePath, String outputPath) {
        try (Stream<String> s = Files.lines(Paths.get(sourcePath))) {
            List<String> binaryInstructions = s
                    .filter(l -> !cleaner.isComment(l))
                    .map(cleaner::cleanLine)
                    .map(parser)
                    .map(converter)
                    .collect(Collectors.toList());
            if (!binaryInstructions.isEmpty()) {
                Files.write(Paths.get(outputPath), binaryInstructions);
            }
        } catch (IOException e) {
            log.error("Error while assembling file!", e);
        }
    }

}
