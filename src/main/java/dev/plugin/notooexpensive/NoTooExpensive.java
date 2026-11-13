package dev.plugin.notooexpensive;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.view.AnvilView;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Removes ONLY the vanilla "Too Expensive!" limit (40 levels) in the anvil.
 * The real cost and the item's prior-work penalty are left untouched,
 * so the vanilla cost progression stays exactly as it is.
 */
public class NoTooExpensive extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("NoTooExpensive enabled: anvil 40-level limit removed.");
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPrepareAnvil(PrepareAnvilEvent event) {
        AnvilView view = event.getView();
        view.setMaximumRepairCost(Integer.MAX_VALUE);
    }
}
