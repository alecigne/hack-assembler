package net.lecigne.n2t.hackassembler.service;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWriter {

    private final String sourcePath;

    private final String outputPath;

    private final UnaryOperator<String> unaryOperator;

    public FileWriter(String sourcePath, String outputPath, UnaryOperator<String> unaryOperator) {
        this.sourcePath = sourcePath;
        this.outputPath = outputPath;
        this.unaryOperator = unaryOperator;
    }

    public void write() {
        List<String> commands = new ArrayList<>();

        try (Stream<String> s = Files.lines(Paths.get(sourcePath))) {
            commands = s.map(unaryOperator)
                    .filter(StringUtils::isNotBlank)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!commands.isEmpty()) {
            try {
                Files.write(Paths.get(outputPath), commands);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
