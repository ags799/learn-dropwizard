package com.sharpandrew.learndropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class LearnDropwizardApplication extends Application<LearnDropwizardConfiguration> {
    public static void main(String[] args) throws Exception {
        new LearnDropwizardApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<LearnDropwizardConfiguration> bootstrap) {
        // no initialization
    }

    @Override
    public void run(LearnDropwizardConfiguration configuration, Environment environment) {
        final GraphService graphService = new GraphResource();
        environment.jersey().register(graphService);
    }
}
