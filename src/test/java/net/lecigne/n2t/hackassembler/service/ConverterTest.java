package net.lecigne.n2t.hackassembler.service;

import net.lecigne.n2t.hackassembler.model.AInstruction;
import net.lecigne.n2t.hackassembler.model.CInstruction;
import net.lecigne.n2t.hackassembler.model.Instruction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ConverterTest {

    Converter converter = new Converter();

    @ParameterizedTest
    @CsvFileSource(resources = "/converter/Addresses.csv")
    void convert_givenAInst_shoultConvertItToBinaryInstruction(String address, String binary) {
        // Given
        AInstruction aInstruction = new AInstruction(address);
        Instruction instruction = new AInstruction(address);

        // When
        String binaryLine1 = converter.apply(aInstruction);
        String binaryLine2 = converter.apply(instruction);

        // Then
        assertThat(binaryLine1, is(equalTo(binary)));
        assertThat(binaryLine2, is(equalTo(binary)));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/converter/Computations.csv")
    void convert_givenCInst_shoultConvertItToBinaryInstruction(String dest, String comp, String jump, String binary) {
        // Given
        CInstruction cInstruction = new CInstruction(dest, comp, jump);
        Instruction instruction = new CInstruction(dest, comp, jump);

        // When
        String binaryLine1 = converter.apply(cInstruction);
        String binaryLine2 = converter.apply(instruction);

        // Then
        assertThat(binaryLine1, is(equalTo(binary)));
        assertThat(binaryLine2, is(equalTo(binary)));
    }

}
