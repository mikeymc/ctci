package com.ctci;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StringReverserTest {

    @Test
    public void reversesStrings() {
        StringReverser reverser = new StringReverser();

        assertThat(reverser.reverse(null), nullValue());
        assertThat(reverser.reverse("o"), is("o"));
        assertThat(reverser.reverse("oi"), is("io"));
        assertThat(reverser.reverse("abc"), is("cba"));
    }
}