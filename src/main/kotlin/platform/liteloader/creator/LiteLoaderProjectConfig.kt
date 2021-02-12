/*
 * Minecraft Dev for IntelliJ
 *
 * https://minecraftdev.org
 *
 * Copyright (c) 2021 minecraft-dev
 *
 * MIT License
 */

package com.demonwav.mcdev.platform.liteloader.creator

import com.demonwav.mcdev.creator.ProjectConfig
import com.demonwav.mcdev.creator.ProjectCreator
import com.demonwav.mcdev.creator.buildsystem.BuildSystemType
import com.demonwav.mcdev.creator.buildsystem.gradle.GradleBuildSystem
import com.demonwav.mcdev.creator.buildsystem.gradle.GradleCreator
import com.demonwav.mcdev.platform.PlatformType
import com.demonwav.mcdev.platform.forge.creator.Fg2ProjectCreator
import com.demonwav.mcdev.platform.mcp.McpVersionPair
import com.demonwav.mcdev.util.SemanticVersion
import com.intellij.openapi.module.Module
import java.nio.file.Path

class LiteLoaderProjectConfig : ProjectConfig(), GradleCreator {

    lateinit var mainClass: String

    var mcpVersion = McpVersionPair("", SemanticVersion.release())
    var mcVersion: SemanticVersion = SemanticVersion.release()

    override var type = PlatformType.LITELOADER

    override val preferredBuildSystem = BuildSystemType.GRADLE

    override fun buildGradleCreator(
        rootDirectory: Path,
        module: Module,
        buildSystem: GradleBuildSystem
    ): ProjectCreator {
        return LiteLoaderProjectCreator(rootDirectory, module, buildSystem, this)
    }

    override fun configureRootGradle(
        rootDirectory: Path,
        buildSystem: GradleBuildSystem
    ) {
        buildSystem.gradleVersion = Fg2ProjectCreator.FG_WRAPPER_VERSION
    }
}
