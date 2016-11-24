package com.sharpandrew.learndropwizard;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

public class EdgeTest {
    private static final ObjectMapper MAPPER =
            Jackson.newObjectMapper().registerModules(new Jdk8Module(), new GuavaModule());

    @Test
    public final void serializesToJson() throws Exception {
        Edge edge = ImmutableEdge.of(1, 2, 3);
        String expected = "{\"vertex1\":1,\"vertex2\":2,\"weight\":3}";
        assertThat(MAPPER.writeValueAsString(edge)).isEqualTo(expected);
    }

    @Test
    public final void deserializesFromJson() throws Exception {
        String edge = "{\"vertex1\":1,\"vertex2\":2,\"weight\":3}";
        Edge expected = ImmutableEdge.of(1, 2, 3);
        assertThat(MAPPER.readValue(edge, ImmutableEdge.class)).isEqualTo(expected);
    }
}
