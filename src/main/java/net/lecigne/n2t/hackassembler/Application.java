package net.lecigne.n2t.hackassembler;

import net.lecigne.n2t.hackassembler.service.Cleaner;
import net.lecigne.n2t.hackassembler.service.Parser;
import net.lecigne.n2t.hackassembler.service.Converter;
import net.lecigne.n2t.hackassembler.service.Assembler;

public class Application {

    public static void main(String... args) {
        String sourcePath = "/home/alc/tmp/n2t-test/PongL.asm";
        String outputPath = "/home/alc/tmp/n2t-test/output.hack";
        Parser parser = new Parser();
        Converter converter = new Converter();
        Cleaner cleaner = new Cleaner();
        Assembler assembler = new Assembler(cleaner, parser, converter);
        assembler.assembleFile(sourcePath, outputPath);
    }

}
