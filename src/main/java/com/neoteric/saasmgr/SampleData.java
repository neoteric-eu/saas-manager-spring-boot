package com.neoteric.saasmgr;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Builder(toBuilder = true)
@JsonDeserialize(builder = SampleData.SampleDataBuilder.class)
public class SampleData {

    public static final String FOO = "foo";
    public static final String BAR = "startDate";

    @JsonProperty(FOO)
    @NotNull
    String foo;

    @JsonProperty(BAR)
    @NotNull
    String bar;

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SampleDataBuilder {

        @JsonProperty(FOO)
        String foo;

        @JsonProperty(BAR)
        String bar;
    }

}

