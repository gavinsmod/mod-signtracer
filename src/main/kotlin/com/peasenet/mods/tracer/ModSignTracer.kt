package com.peasenet.mods.tracer

import com.peasenet.config.Config
import com.peasenet.config.TracerConfig
import com.peasenet.main.Settings
import com.peasenet.settings.SettingBuilder
import com.peasenet.util.RenderUtils.renderSingleLine
import com.peasenet.util.event.data.BlockEntityRender
import com.peasenet.util.event.data.EntityRender
import net.minecraft.block.entity.SignBlockEntity
import org.lwjgl.glfw.GLFW

class ModSignTracer : TracerMod(
    "Sign Tracer",
    "gavinsmod.mod.tracer.signtracer",
    "signtracer",
    GLFW.GLFW_KEY_UNKNOWN
) {
    init {
        val colorSetting = SettingBuilder()
            .setTitle("gavinsmod.settings.tracer.signtracer.color")
            .setColor(cfg.signColor)
            .buildColorSetting()
        colorSetting.setCallback {
            cfg.signColor = colorSetting.color
        }
        addSetting(colorSetting)
    }
    override fun onRenderBlockEntity(er: BlockEntityRender) {
        if (er.entity !is SignBlockEntity) return
        renderSingleLine(
            er.stack!!,
            er.buffer!!,
            er.playerPos!!,
            er.center!!,
            cfg.signColor,
            cfg.alpha
        )
    }
    
    companion object {
        var cfg: TracerConfig = Settings.getConfig("tracer")
    }

    override fun onEntityRender(er: EntityRender) {}
}
