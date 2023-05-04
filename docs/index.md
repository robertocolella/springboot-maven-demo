# SpringBoot Maven

This app contains source code for a Java ([Spring](https://spring.io)) application that can be built and deployed automatically by the Tanzu Application Platform. The app includes a web page created using [Thymeleaf](https://www.thymeleaf.org/) and a basic REST API. It also includes Spring Boot Actuators and can be observed with LiveView in the TAP Portal. This application was initially created using an Accelerator for Spring Boot applications.

Features at a glance:

* A Spring Boot application using Maven as the build and packaging system
* Thymeleaf to provide web page templating and a landing page for the site
* A REST API that allows you to GET `/messages` (a JSON spring built in `HelloController.java`)
* Backstage TechDocs using Markdown (see `mkdocs.yml`)

Navigating your broswer to http(s)://&lt;your.hosting.url&gt;:&lt;port&gt; should show the following screen:

![supply chain diagram](https://github.com/benwilcock/springboot-maven/raw/main/src/main/resources/static/tap-into-prod.png "Composable and Modular - TAP Supply Chains")

[Watch it deploy on Tanzu Application Platform.](https://via.vmw.com/tap-java-sc)