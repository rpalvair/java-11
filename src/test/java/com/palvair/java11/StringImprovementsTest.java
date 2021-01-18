package com.palvair.java11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class StringImprovementsTest {

    private static final String HELLO_WORLD = "Hello \n \n World \n  \n";

    @Test
    @DisplayName("should_return_a_stream_of_strings_as_is_when_calling_method_string#lines")
    public void should_return_a_stream_of_strings_as_is_when_calling_method_string_lines() {
        final Stream<String> lines = HELLO_WORLD.lines();

        assertThat(lines).isNotNull()
                .containsExactly("Hello ", " ", " World ", "  ");
    }

    @Test
    public void should_return_strip_lines_including_empty_strings() {
        final List<String> stripLines = new StringImprovements().stripLines(HELLO_WORLD);

        assertThat(stripLines).isNotNull()
                .containsExactly("Hello", "", "World", "");
    }

    @Test
    public void should_return_strip_lines_removing_empty_strings() {
        final List<String> stripLines = new StringImprovements().stripLinesRemovingBlankLines(HELLO_WORLD);

        assertThat(stripLines).isNotNull()
                .containsExactly("Hello", "World");
    }

    @Test
    @DisplayName("should_remove_leading_space_when_calling_string#stripLeading")
    public void should_remove_leading_space_when_calling_string_stripLeading() {
        final String stripLeading = " Hello World ".stripLeading();

        assertThat(stripLeading).isNotNull()
                .isEqualTo("Hello World ");
    }

    @Test
    @DisplayName("should_remove_trailing_space_when_calling_string#stripTailing")
    public void should_remove_trailing_space_when_calling_string_stripTailing() {
        final String stripTrailing = " Hello World ".stripTrailing();

        assertThat(stripTrailing).isNotNull()
                .isEqualTo(" Hello World");
    }

    @Test
    @DisplayName("should_repeat_string_when_calling_string#repeat")
    public void should_repeat_string_when_calling_string_repeat() {
        final String repeat = ".".repeat(3);

        assertThat(repeat).isNotNull()
                .isEqualTo("...");
    }
}