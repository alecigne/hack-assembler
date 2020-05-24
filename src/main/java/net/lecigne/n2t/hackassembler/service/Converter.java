package net.lecigne.n2t.hackassembler.service;

import net.lecigne.n2t.hackassembler.model.AInstruction;
import net.lecigne.n2t.hackassembler.model.CInstruction;
import net.lecigne.n2t.hackassembler.model.Instruction;

import java.util.HashMap;
import java.util.function.Function;

public class Converter implements Function<Instruction, String> {

    private static final HashMap<String, String> DEST_MAP = new HashMap<>();

    private static final HashMap<String, String> COMP_MAP = new HashMap<>();

    private static final HashMap<String, String> JUMP_MAP = new HashMap<>();

    private static final String CINST_PREFIX = "111";

    public Converter() {
        initMaps();
    }

    @Override
    public String apply(Instruction instruction) {
        switch (instruction.getInstructionType()) {
            case A:
                return convertAInstruction((AInstruction) instruction);
            case C:
                return convertCInstruction((CInstruction) instruction);
            default:
                return null;
        }
    }

    private String convertAInstruction(AInstruction aInstruction) {
        String binaryAddress = Integer.toBinaryString(Integer.parseInt(aInstruction.getAddress()));
        return String.format("%16s", binaryAddress).replace(' ', '0');
    }

    private String convertCInstruction(CInstruction cInstruction) {
        return String.join("",
                CINST_PREFIX,
                COMP_MAP.get(cInstruction.getComp()),
                DEST_MAP.get(cInstruction.getDest()),
                JUMP_MAP.get(cInstruction.getJump()));
    }

    private void initMaps() {
        DEST_MAP.put(null, "000");
        DEST_MAP.put("M", "001");
        DEST_MAP.put("D", "010");
        DEST_MAP.put("MD", "011");
        DEST_MAP.put("A", "100");
        DEST_MAP.put("AM", "101");
        DEST_MAP.put("AD", "110");
        DEST_MAP.put("AMD", "111");

        COMP_MAP.put("0", "0101010");
        COMP_MAP.put("1", "0111111");
        COMP_MAP.put("-1", "0111010");
        COMP_MAP.put("D", "0001100");
        COMP_MAP.put("A", "0110000");
        COMP_MAP.put("!D", "0001101");
        COMP_MAP.put("!A", "0110001");
        COMP_MAP.put("-D", "0001111");
        COMP_MAP.put("-A", "0110011");
        COMP_MAP.put("D+1", "0011111");
        COMP_MAP.put("A+1", "0110111");
        COMP_MAP.put("D-1", "0001110");
        COMP_MAP.put("A-1", "0110010");
        COMP_MAP.put("D+A", "0000010");
        COMP_MAP.put("D-A", "0010011");
        COMP_MAP.put("A-D", "0000111");
        COMP_MAP.put("D&A", "0000000");
        COMP_MAP.put("D|A", "0010101");
        COMP_MAP.put("M", "1110000");
        COMP_MAP.put("!M", "1110001");
        COMP_MAP.put("-M", "1110011");
        COMP_MAP.put("M+1", "1110111");
        COMP_MAP.put("M-1", "1110010");
        COMP_MAP.put("D+M", "1000010");
        COMP_MAP.put("D-M", "1010011");
        COMP_MAP.put("M-D", "1000111");
        COMP_MAP.put("D&M", "1000000");
        COMP_MAP.put("D|M", "1010101");

        JUMP_MAP.put(null, "000");
        JUMP_MAP.put("JGT", "001");
        JUMP_MAP.put("JEQ", "010");
        JUMP_MAP.put("JGE", "011");
        JUMP_MAP.put("JLT", "100");
        JUMP_MAP.put("JNE", "101");
        JUMP_MAP.put("JLE", "110");
        JUMP_MAP.put("JMP", "111");
    }

}
