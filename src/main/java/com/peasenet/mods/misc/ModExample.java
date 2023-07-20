package com.peasenet.mod.misc;

import com.peasenet.mods.Mod;
import com.peasenet.mods.ModCategory;
import com.peasenet.util.PlayerUtils;
import org.lwjgl.glfw.GLFW;

/**
 * An example mod for the GavinsMod client.
 */

/*
    By extending the Mod class, we can use the Mod class's methods and variables, as well as hook into
    the GavinsMod client's events if needed.
 */
public class ModExample extends Mod {
    public ModExample() {
        /* The Mod class's constructor takes in the following parameters:
            name: The name of the mod. This is used for internal ordering and identification, and is not
                  displayed to the user.
            translationKey: The translation key for the mod, used for rendering the mod's name in the
                            client's GUI.
            chatCommand: The chat command for the mod. This is used for enabling and disabling the mod
                         from the chat. By typing in ".exampleMod" in the chat, the mod will be toggled.
            modCategory: The category of the mod. This is used for internal ordering and identification,
                         such as where the mod will be rendered in the client's GUI.
            keyBind: The keybinding used to toggle the mod. You usually would want this to be 
                "GLFW.GLFW_KEY_UNKNOWN", which is the default keybind for the mod (no keybind).
         */
        super(
                "mod_example",
                "gavinsmod.mod.example.example",
                "exampleMod",
                ModCategory.MISC,
                GLFW.GLFW_KEY_UNKNOWN
        );
    }

    @Override
    public void onEnable() {
        PlayerUtils.sendMessage("Hello Fabric world!", true);
        super.onEnable();
    }

    @Override
    public void onDisable() {
        PlayerUtils.sendMessage("Goodbye Fabric world!", true);
        super.onDisable();
    }
}
