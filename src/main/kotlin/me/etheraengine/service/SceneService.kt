package me.etheraengine.service

import me.etheraengine.logger
import me.etheraengine.scene.Scene
import org.springframework.stereotype.Service
import java.awt.Graphics

/**
 * Service to manage the currently active scene, and switch between different scenes
 */
@Service
class SceneService {
    private val log = logger<SceneService>()
    var currentScene: Scene? = null
        set(value) {
            if (currentScene != null) {
                log.info("Disabling scene {}", currentScene!!::class.java.simpleName)
                currentScene!!.onDisable()
            }

            field = value

            if (currentScene != null) {
                log.info("Enabling scene {}", currentScene!!::class.java.simpleName)
                currentScene!!.onEnable()
            }
        }

    fun update(deltaTime: Long) {
        currentScene?.update(deltaTime)
    }

    fun render(g: Graphics, deltaTime: Long) {
        currentScene?.render(g, deltaTime)
    }
}