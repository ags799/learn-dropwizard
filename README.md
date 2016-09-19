# Learn Dropwizard

Practice for learning [Dropwizard](www.dropwizard.io).

## Development

Build with

    ./gradlew build
    
Clean with

    ./gradlew clean
    
Build a Docker container named
`com.sharpandrew/learn-dropwizard:$VERSION` with

    ./gradlew dockerBuildImage
    
## TODO

1. Use auth tokens
1. Consider incorporating
[Dropwizard Tutorials](http://www.dropwizard.io/1.0.0/docs/getting-started.html)
1. CircleCI
1. Set up `dockerPushImage` gradle task, see
[help](https://github.com/bmuschko/gradle-docker-plugin) 