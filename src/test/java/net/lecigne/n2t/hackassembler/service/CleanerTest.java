package net.lecigne.n2t.hackassembler.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CleanerTest {

    Cleaner cleaner = new Cleaner();

    @ParameterizedTest
    @CsvFileSource(resources = "/cleaner/DirtyLines.csv")
    void cleanLine(String lineWithComment, String cleanLine) {
        // When
        String actualLine = cleaner.cleanLine(lineWithComment);

        // Then
        assertThat(actualLine, is(equalTo(cleanLine)));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/cleaner/Comments.csv")
    void isComment(String comment) {
        assertTrue(cleaner.isComment(comment));
    }
}
