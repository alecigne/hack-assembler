package net.lecigne.n2t.hackassembler;

import net.lecigne.n2t.hackassembler.service.Cleaner;
import net.lecigne.n2t.hackassembler.service.Parser;
import net.lecigne.n2t.hackassembler.service.Converter;
import net.lecigne.n2t.hackassembler.service.Assembler;

public class Application {

    @SuppressWarnings("squid:S106") // System.out.println is OK for this CLI app
    public static void main(String... args) {
        if (args.length == 0) {
            System.out.println("Please provide a filename.");
            return;
        }
        String sourcePath = args[0];
        Parser parser = new Parser();
        Converter converter = new Converter();
        Cleaner cleaner = new Cleaner();
        Assembler assembler = new Assembler(cleaner, parser, converter);
        assembler.assembleFile(sourcePath);
    }

}
