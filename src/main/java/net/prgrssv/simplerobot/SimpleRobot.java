package net.prgrssv.simplerobot;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "SimpleRobot", name = "Simple Robot", version = "0.0.0",
		dependencies = "required-after:OpenComputers@[1.4.0,)")
public class SimpleRobot {
	@Mod.Instance
	private static SimpleRobot instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerItem(
				ItemUpgradePerpetualGenerator.getInstance(),
				ItemUpgradePerpetualGenerator.ITEM_NAME);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		li.cil.oc.api.Driver.add(new DriverUpgradePerpetualGenerator());
		GameRegistry.addRecipe(Tortoise.getRecipe());
	}
}
