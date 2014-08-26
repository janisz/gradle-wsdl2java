gradle-wsdl2java [![Build Status](https://travis-ci.org/janisz/gradle-wsdl2java.svg?branch=master)](https://travis-ci.org/janisz/gradle-wsdl2java)
================

Gradle plugin takes a WSDL document and generates fully annotated Java code from which to implement a service

##Usage

Add the following to your build file to setup where the plugin should be downloaded from:

```groovy
buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        classpath 'com.github.janisz:wsdl2java:0.0.1'
    }
}

apply plugin: 'wsdl2java'
```

### Configuration

```groovy
wsdl2java {
    wsdlUrl = 'https://webapi.allegro.pl/service.php?wsdl'
    outputDir = 'generated'
    namespaceToPackage = [
            'urn:AllegroWebApi' : 'pl.allegro.webapi.uploader',
            'https://webapi.allegro.pl/service.php' : 'pl.allegro.webapi.service',
    ]
    verbose = false
}
```

|Option            | Type                  | Description                                                                                     |
-------------------|-----------------------|-------------------------------------------------------------------------------------------------|
|wsdlUrl           | `String`              | WSDL address, could be URL or local file path                                                   |
|outputDir         | `String`              | Directory path where generated sources should be places, by default it's project build directory|
|namespaceToPackage| `Map<String, String>` | Dictionary that will translate namespaces from WSDL to taret class packages                     |
|verbose           | `boolean`             | Indicate if comments during the code generation process will be displayed                       |

### TODO

* add support for multiple WSDLs (for now you can use [this file](https://gist.github.com/96e3bcb07c8d6f3d5ae5.git))
* add AXIS dependecies to compile scope
* fix Gradle 2.0 issues


## License

Code released under [the Apache License v. 2](https://raw.githubusercontent.com/janisz/gradle-wsdl2java/master/LICENSE)
