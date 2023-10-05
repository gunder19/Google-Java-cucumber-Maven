@echo off

set CHROMEDRIVER_PATH=C:\path\to\chromedriver.exe

set CUCUMBER_OPTIONS=--glue your.package.name.with.steps --plugin json:target/cucumber-report.json

mvn clean test -Dwebdriver.chrome.driver="%CHROMEDRIVER_PATH%" -Dcucumber.options="%CUCUMBER_OPTIONS%"