package net.lecigne.n2t.hackassembler;

import net.lecigne.n2t.hackassembler.service.BinaryConverter;
import net.lecigne.n2t.hackassembler.service.FileWriter;
import net.lecigne.n2t.hackassembler.service.HackAssembler;
import net.lecigne.n2t.hackassembler.service.Parser;

public class Application {

    public static void main(String... args) {
        String sourcePath = "/home/alc/tmp/n2t-test/source.asm";
        String outputPath = "/home/alc/tmp/n2t-test/output.asm";
        Parser parser = new Parser();
        BinaryConverter converter = new BinaryConverter();
        HackAssembler assembler = new HackAssembler(parser, converter);
        FileWriter writer = new FileWriter(sourcePath, outputPath, assembler);
        writer.write();
    }

}
