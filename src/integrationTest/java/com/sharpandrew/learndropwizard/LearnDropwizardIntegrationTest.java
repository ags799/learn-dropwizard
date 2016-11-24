package com.sharpandrew.learndropwizard;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;

public class LearnDropwizardIntegrationTest {
    @ClassRule
    public static final GenericContainer CONTAINER =
            // Run the `dockerBuild` gradle task to ensure you are testing against a Docker container that reflects
            // your work-in-progress-code.
            // If either the image name or the port change, update the README and Docker Hub page.
            new GenericContainer("ags799/learn-dropwizard:latest").withExposedPorts(8080);

    @Test
    public final void test() throws Exception {
        assertThat(true).isEqualTo(true);
    }
}
