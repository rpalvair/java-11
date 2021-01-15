package com.palvair;

import java.util.List;
import java.util.function.Predicate;
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
                .filter(predicateRemoveBlank(removeBlank))
                .map(String::strip)
                .collect(Collectors.toList());
    }

    private Predicate<String> predicateRemoveBlank(final boolean removeBlank) {
        return removeBlank ? Predicate.not(String::isBlank) : s -> true;
    }
}
