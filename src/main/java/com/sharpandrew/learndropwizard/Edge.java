package com.sharpandrew.learndropwizard;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableEdge.class)
@JsonDeserialize(as = ImmutableEdge.class)
public abstract class Edge {
    @Value.Parameter
    public abstract int getVertex1();
    @Value.Parameter
    public abstract int getVertex2();
    @Value.Parameter
    public abstract int getWeight();
}
