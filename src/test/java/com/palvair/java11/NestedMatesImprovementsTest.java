package com.palvair.java11;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NestedMatesImprovementsTest {

    @Test
    public void should_return_true_when_nested_classes() {
        final Outer outer = new Outer();
        final Outer.Nested nested = outer.new Nested();

        assertThat(outer.getClass().isNestmateOf(nested.getClass())).isTrue();
    }

    @Test
    public void should_return_name_of_outer_class_when_calling_get_nest_host_on_nested_class() {
        final Outer outer = new Outer();
        final Outer.Nested nested = outer.new Nested();

        assertThat(nested.getClass().getNestHost()).isEqualTo(Outer.class);
    }

    @Test
    public void should_return_name_of_outer_class_and_nested_class_when_calling_get_nest_members_on_nested_class() {
        final Outer.Nested nested = new Outer().new Nested();

        assertThat(nested.getClass().getNestMembers())
                .containsExactly(Outer.class, Outer.Nested.class);
    }
}
