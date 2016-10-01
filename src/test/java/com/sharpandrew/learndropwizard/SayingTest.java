package com.sharpandrew.learndropwizard;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public final class SayingTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializesToJson() throws Exception {
        Saying saying = new Saying(1L, "some-content");
        String expected = "{\"id\":1,\"content\":\"some-content\"}";
        assertThat(MAPPER.writeValueAsString(saying), is(expected));
    }

    @Test
    public void deserializesFromJson() throws Exception {
        String saying = "{\"id\":1,\"content\":\"some-content\"}";
        Saying expected = new Saying(1L, "some-content");
        assertThat(MAPPER.readValue(saying, Saying.class), is(expected));
    }
}