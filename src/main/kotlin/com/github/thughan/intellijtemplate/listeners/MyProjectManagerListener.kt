package com.github.thughan.intellijtemplate.listeners

import com.github.thughan.intellijtemplate.services.MyProjectService
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener

internal class MyProjectManagerListener : ProjectManagerListener {

    override fun projectOpened(project: Project) {
        projectInstance = project
        project.service<MyProjectService>()
    }

    override fun projectClosing(project: Project) {
        projectInstance = null;
        super.projectClosing(project)
    }

    companion object {
        var projectInstance: Project? = null
    }

}
