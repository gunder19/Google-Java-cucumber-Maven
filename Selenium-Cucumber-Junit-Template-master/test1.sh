#!/bin/bash

MAVEN_EXECUTABLE=/path/to/your/maven/bin/mvn

MAVEN_GOALS="clean test"
CUCUMBER_OPTIONS="--glue your.package.name.with.steps --plugin json:target/cucumber-report.json"

$MAVEN_EXECUTABLE $MAVEN_GOALS -Dcucumber.options="$CUCUMBER_OPTIONS"