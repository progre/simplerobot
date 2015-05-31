package net.prgrssv.simplerobot;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemUpgradePerpetualGenerator extends Item {
	public static final String ITEM_NAME = "perpetualGeneratorUpgrade";
	private static ItemUpgradePerpetualGenerator instance;
	private static ItemStack itemStack;

	public static ItemUpgradePerpetualGenerator getInstance() {
		if (instance == null) {
			instance = new ItemUpgradePerpetualGenerator();
		}
		return instance;
	}

	public static ItemStack getItemStack() {
		if (itemStack == null) {
			itemStack = new ItemStack(getInstance(), 1);
		}
		return itemStack;
	}

	public ItemUpgradePerpetualGenerator() {
		setUnlocalizedName(ITEM_NAME);
		setCreativeTab(CreativeTabs.tabAllSearch);
	}
}
