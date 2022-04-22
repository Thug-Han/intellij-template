package com.github.thughan.intellijtemplate.services

import com.intellij.openapi.project.Project
import com.github.thughan.intellijtemplate.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
