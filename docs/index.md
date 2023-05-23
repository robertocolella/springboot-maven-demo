# Spring Boot Maven

This app contains source code for a Java ([Spring](https://spring.io)) application that can be built and deployed automatically by the Tanzu Application Platform. The app includes a web page created using [Thymeleaf](https://www.thymeleaf.org/) and a basic REST API. It also includes Spring Boot Actuators and can be observed with LiveView in the TAP Portal. This application was initially created using an Accelerator for Spring Boot applications.

Features at a glance:

* A Spring Boot application using Maven as the build and packaging system
* Thymeleaf to provide web page templating and a landing page for the site
* A REST API that allows you to GET `/messages` (returns a JSON string built in `HelloController.java`)
* Backstage TechDocs using Markdown (see `mkdocs.yml` and `docs/index.md`)

Navigating your broswer to **http(s)://&lt;your.hosting.url&gt;:&lt;port&gt;** should show the following screen:

![supply chain diagram](https://github.com/benwilcock/springboot-maven/raw/main/src/main/resources/static/tap-into-prod.png "Composable and Modular - TAP Supply Chains")

[Watch it deploy on Tanzu Application Platform.](https://via.vmw.com/tap-java-sc)

## Running on the VMware Tanzu Application Platform

[Watch it deploy on Tanzu Application Platform.](https://via.vmw.com/tap-node-sc)

The application can be deployed via the `tanzu` cli using a command line similar to the one shown below. You may need to modify this command depending needs of the supply chain you're using.

```bash
tanzu apps workload create springboot-maven \
  --git-repo https://github.com/benwilcock/springboot-maven \
  --git-branch main \
  --type web \
  --label apps.tanzu.vmware.com/has-tests=true \
  --label app.kubernetes.io/part-of=springboot-maven \
  --param-yaml testing_pipeline_matching_labels="{'apps.tanzu.vmware.com/pipeline':'test', 'apps.tanzu.vmware.com/language':'java'}" \
  --annotation autoscaling.knative.dev/minScale=1
```

## Customisations

For a simple customisation, in the application code (in the `src/main/resources/application.yml` file) change the name of the `client` property from "VMware" to something else and then commit/redeploy/restart.

```yaml
client: "VMware"
```

The homepage will then use the new name of the client in the text at the bottom of the page.

## Generating API Documentation

This project features [SpringDoc](https://springdoc.org/). This means that the `/messages` REST API can be documented using OpenAPI.

To generate the documentation:

```bash
./mvnw clean verify
```

The documentation will be generated into the file `./openapi/openapi.json`. This file should be checked in with the source code so that it can be referenced by Backstage catalog API entities.