package com.github.janisz.wsdl2java

import org.gradle.api.tasks.JavaExec
import org.gradle.api.tasks.TaskAction

class Wsdl2JavaTask extends JavaExec {
    String wsdlUrl
    String outputDir = project.buildDir.absolutePath
    Map<String, String> namespaceToPackage
    boolean verbose = true

    Wsdl2JavaTask() {
        super()
        setClasspath(project.buildscript.configurations.classpath)
        setMain('org.apache.axis.wsdl.WSDL2Java')
    }

    @Override
    @TaskAction
    void exec() {
        args(prepareArguments())
        outputs.dir(outputDir)
        super.exec()
    }

    private List<String> prepareArguments() {
        List<String> arguments = [wsdlUrl, "--output=$outputDir"]
        if (!namespaceToPackage.isEmpty()) {
            arguments.addAll(namespaceToPackage.collect { "--NStoPkg=${it.key}=${it.value}" })
        }
        if (verbose) {
            arguments.add('--verbose')
        }
        return arguments
    }
}
