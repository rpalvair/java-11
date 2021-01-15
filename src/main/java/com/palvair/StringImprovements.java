package com.palvair;

import java.util.List;
import java.util.stream.Collectors;

public class StringImprovements {

    public List<String> stripLines(final String multiLinesString) {
        return strip(multiLinesString, false);
    }

    public List<String> stripLinesRemovingBlankLines(final String multiLinesString) {
        return strip(multiLinesString, true);
    }

    private List<String> strip(final String multiLinesString, final boolean removeBlank) {
        return multiLinesString.lines()
                .filter(s -> removeBlank(removeBlank, s))
                .map(String::strip)
                .collect(Collectors.toList());
    }

    private boolean removeBlank(final boolean removeBlank, final String s) {
        if (removeBlank) {
            return !s.isBlank();
        }
        return true;
    }
}
