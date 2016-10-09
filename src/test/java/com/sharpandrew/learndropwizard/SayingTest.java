package com.sharpandrew.learndropwizard;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

public final class SayingTest {

    private static final ObjectMapper MAPPER =
            Jackson.newObjectMapper().registerModules(new Jdk8Module(), new GuavaModule());

    @Test
    public void serializesToJson() throws Exception {
        Saying saying = ImmutableSaying.builder().id(1L).content("some-content").build();
        String expected = "{\"id\":1,\"content\":\"some-content\"}";
        assertThat(MAPPER.writeValueAsString(saying), is(expected));
    }

    @Test
    public void deserializesFromJson() throws Exception {
        String saying = "{\"id\":1,\"content\":\"some-content\"}";
        Saying expected = ImmutableSaying.builder().id(1L).content("some-content").build();
        assertThat(MAPPER.readValue(saying, ImmutableSaying.class), is(expected));
    }
}