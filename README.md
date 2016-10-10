# Learn Dropwizard
[![Build Status](https://circleci.com/gh/ags799/learn-dropwizard.svg?style=shield&circle-token=beac835a1c461670d578e3016d6b85581721e19f)](https://circleci.com/gh/ags799/learn-dropwizard)
[![Code Climate](https://codeclimate.com/github/ags799/learn-dropwizard/badges/gpa.svg)](https://codeclimate.com/github/ags799/learn-dropwizard)

Practice for learning [Dropwizard](http://dropwizard.io).

## Usage

Visit our [Docker Hub page](https://hub.docker.com/r/ags799/learn-dropwizard/) for
download and usage instructions.

## Development

Build with

    ./gradlew build

Clean with

    ./gradlew clean

Build a Docker container named
`ags799/learn-dropwizard:$VERSION` with

    ./gradlew dockerBuildImage

Run that Docker container with

    ./gradlew dockerRun

Issue requests against the running app with

    curl localhost:8080/$YOUR_PATH_HERE
