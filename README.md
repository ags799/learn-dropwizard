# Learn Dropwizard
![Build Status](https://circleci.com/gh/ags799/learn-dropwizard.svg?style=shield&circle-token=beac835a1c461670d578e3016d6b85581721e19f)

Practice for learning [Dropwizard](http://dropwizard.io).

## Development

Build with

    ./gradlew build

Clean with

    ./gradlew clean

Build a Docker container named
`com.sharpandrew/learn-dropwizard:$VERSION` with

    ./gradlew dockerBuildImage

Run that Docker container with

    ./gradlew dockerRun

Issue requests against the running app with

    curl localhost:8080/$YOUR_PATH_HERE
    
## TODO

1. Use auth tokens
1. Consider incorporating
[Dropwizard Tutorials](http://www.dropwizard.io/1.0.0/docs/getting-started.html)
1. CircleCI
1. Set up `dockerPushImage` gradle task, see
[help](https://github.com/bmuschko/gradle-docker-plugin) 