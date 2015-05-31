package net.prgrssv.simplerobot;

import li.cil.oc.api.driver.EnvironmentHost;
import li.cil.oc.api.driver.item.Slot;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.prefab.DriverItem;

import net.minecraft.item.ItemStack;

public class DriverUpgradePerpetualGenerator extends DriverItem {
	public DriverUpgradePerpetualGenerator() {
		super(ItemUpgradePerpetualGenerator.getItemStack());
;	}

	@Override
	public ManagedEnvironment createEnvironment(ItemStack stack, EnvironmentHost host) {
		return new UpgradePerpetualGenerator();
	}

	@Override
	public String slot(ItemStack stack) {
		return Slot.Upgrade;
	}

	@Override
	public int tier(ItemStack stack) {
		return 3; // Tier.Four
	}
}
