package su.hil.enchantfixer;

import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MyListener(), this);

//        System.out.println("HIIIIIIIIIIIIIII, IMA PLUGINNNNN!N!N!NN!!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}



