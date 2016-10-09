package com.sharpandrew.learndropwizard;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize
@JsonDeserialize
public abstract class Saying {
    public abstract long getId();
    public abstract String getContent();
}
