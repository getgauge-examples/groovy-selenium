# Gauge example in Groovy
[![Build Status](https://travis-ci.org/getgauge-examples/gauge-example-groovy.svg?branch=master)](https://travis-ci.org/getgauge-examples/groovy-selenium)

This is an example project for doing web automation testing with [Gauge](http://getgauge.io). This project tests some of the functionalities of the [active admin demo](https://github.com/getgauge/activeadmin-demo) app. This app is hosted as a Java WAR (with embedded Jetty).

## Running this example
The tests are run on Firefox by default. You can set environment to run on different browsers.

### Prerequisites

This example requires the following softwares to run.
  * Java
  * [Gauge](https://gauge.org/)
  * Gauge Java plugin
    * Gauge Java plugin can be installed using `gauge install java`

You can optionally install [Gauge-IntelliJ plugin](https://docs.gauge.org/latest/installation.html#ide-plugins).

### Setting up the System Under Test (SUT)

* Download [activeadmin-demo.war](https://github.com/getgauge-examples/activeadmin-demo/releases/tag/untagged-f0befd5494efa4baabd2)
* Bring up the SUT by executing the below command
```
java -jar activeadmin-demo.war
```
* The SUT should now be available at [http://localhost:8080/](http://localhost:8080)

### Execute specs

```
mvn clean test
```
This runs Gauge specs with [maven](https://maven.apache.org/).

Note:
  * Gauge can also be used with other [build tools](https://docs.gauge.org/latest/configuration.html#build-tools) like gradle and ant.
  * You can use Gauge even without a build script!

## Topics covered in the example

- Use [Webdriver](http://docs.seleniumhq.org/projects/webdriver/) as base of implementation
- [Concepts](https://docs.gauge.org/latest/writing-specifications.html#concept)
- [Specification](https://docs.gauge.org/latest/writing-specifications.html#specifications-spec), [Scenario](https://docs.gauge.org/latest/writing-specifications.html#longstart-scenarios) & [Step](https://docs.gauge.org/latest/writing-specifications.html#longstart-steps) usage
- [Table driven execution](https://docs.gauge.org/latest/execution.html#data-driven-execution)
- [External datasource (special param)](https://docs.gauge.org/latest/execution.html#external-csv-for-data-table)
- Using Gauge with [Selenium Webdriver](http://docs.seleniumhq.org/projects/webdriver/)
- Running Gauge specs with [maven](https://maven.apache.org/)
