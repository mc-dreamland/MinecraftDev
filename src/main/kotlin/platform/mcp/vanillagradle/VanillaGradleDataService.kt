/*
 * Minecraft Dev for IntelliJ
 *
 * https://minecraftdev.org
 *
 * Copyright (c) 2023 minecraft-dev
 *
 * MIT License
 */

package com.demonwav.mcdev.platform.mcp.vanillagradle

import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.Key
import com.intellij.openapi.externalSystem.model.project.ProjectData
import com.intellij.openapi.externalSystem.service.project.IdeModifiableModelsProvider
import com.intellij.openapi.externalSystem.service.project.manage.AbstractProjectDataService
import com.intellij.openapi.module.Module
import com.intellij.openapi.project.Project

class VanillaGradleDataService : AbstractProjectDataService<VanillaGradleData, Module>() {

    override fun getTargetDataKey(): Key<VanillaGradleData> = VanillaGradleData.KEY

    override fun importData(
        toImport: Collection<DataNode<VanillaGradleData>>,
        projectData: ProjectData?,
        project: Project,
        modelsProvider: IdeModifiableModelsProvider,
    ) {
        // Dummy service to enable platform-side DataNodes cache
    }
}
