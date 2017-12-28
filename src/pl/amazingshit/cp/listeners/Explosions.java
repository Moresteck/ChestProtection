package pl.amazingshit.cp.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityListener;

import pl.amazingshit.cp.managers.DatabaseManager;

public class Explosions extends EntityListener {
	
    public void onEntityExplode(EntityExplodeEvent event) {
    	if (event.isCancelled()) {
    		return;
    	}
    	int count = event.blockList().size();
    	for (int x = 0; x < count; x++) {
	        Block block = (Block)event.blockList().get(x);
	        if (!DatabaseManager.isContainerProtected(block.getLocation())) {
	        	return;
	        }
	        if (block.getTypeId() == Material.CHEST.getId() || block.getTypeId() == Material.DISPENSER.getId() || 
	            block.getTypeId() == Material.FURNACE.getId() || block.getTypeId() == Material.BURNING_FURNACE.getId() ||
	            block.getTypeId() == Material.JUKEBOX.getId()) {
	        	
	            event.setCancelled(true);
	            return;
	        }
    	}
    }
}