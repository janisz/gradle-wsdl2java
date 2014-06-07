package com.github.janisz.wsdl2java

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.junit.Assert.assertTrue

class Wsdl2JavaPluginTest {
    @Test
    public void greeterPluginAddsGreetingTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        project.apply plugin: 'wsdl2java'

        assertTrue(project.tasks.wsdl2java instanceof Wsdl2JavaTask)
    }
}
