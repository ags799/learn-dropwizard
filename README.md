# Learn Dropwizard
[![Build Status](https://circleci.com/gh/ags799/learn-dropwizard.svg?style=shield&circle-token=beac835a1c461670d578e3016d6b85581721e19f)](https://circleci.com/gh/ags799/learn-dropwizard)
[![Docker Automated buil](https://img.shields.io/docker/status/jrottenberg/ffmpeg.svg)](https://hub.docker.com/r/ags799/learn-dropwizard/)

Practice for learning [Dropwizard](http://dropwizard.io). We implement answers to interview questions as a REST service.

## Usage

Visit the [Docker Hub page](https://hub.docker.com/r/ags799/learn-dropwizard/) for
download and usage instructions.

## Development

Prepare static analysis tools with

    ./gradlew customBaselineUpdateConfig

Prepare your IDE with

    ./gradlew idea

You may now open the project with Intellij IDEA.

Build with

    ./gradlew build

Clean with

    ./gradlew clean

Build a Docker container named `ags799/learn-dropwizard` with

    ./gradlew dockerBuild

Run that Docker container with

    ./gradlew dockerRun

Issue requests against the running app with

    curl -i -X $METHOD -H 'Content-Type: application/json' localhost:8080/$YOUR_PATH_HERE

This project follows [GitHub Flow](https://guides.github.com/introduction/flow/)
and [Semantic Versioning 2.0.0](http://semver.org/).
