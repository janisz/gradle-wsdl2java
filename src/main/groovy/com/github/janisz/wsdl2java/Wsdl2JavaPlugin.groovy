package com.github.janisz.wsdl2java

import org.gradle.api.Plugin
import org.gradle.api.Project

class Wsdl2JavaPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.task('wsdl2java',
                group: 'wsdl2java',
                type: Wsdl2JavaTask,
                description: 'Generates Java classes from provided WSDL')
    }
}
