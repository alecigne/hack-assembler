package net.lecigne.n2t.hackassembler.service;

import net.lecigne.n2t.hackassembler.model.AInstruction;
import net.lecigne.n2t.hackassembler.model.CInstruction;
import net.lecigne.n2t.hackassembler.model.Instruction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ParserTest {

    Parser parser = new Parser();

    @ParameterizedTest
    @CsvFileSource(resources = "/parser/AInstructions.csv")
    void parse_givenAInstructionLine_shouldParseIt(String aInstLine, String address) {
        // When
        Instruction instruction = parser.apply(aInstLine);

        // Then
        assertThat(instruction, instanceOf(AInstruction.class));
        AInstruction aInstruction = (AInstruction) instruction;
        assertThat(aInstruction.getAddress(), is(equalTo(address)));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/parser/CInstructions.csv")
    void parse_givenCInstructionLine_shouldParseIt(String cInstLine, String dest, String comp, String jump) {
        // When
        Instruction instruction = parser.apply(cInstLine);

        // Then
        assertThat(instruction, instanceOf(CInstruction.class));
        CInstruction cInstruction = (CInstruction) instruction;
        assertThat(cInstruction.getDest(), is(equalTo(dest)));
        assertThat(cInstruction.getComp(), is(equalTo(comp)));
        assertThat(cInstruction.getJump(), is(equalTo(jump)));
    }

}
