package net.prgrssv.simplerobot;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import net.minecraftforge.oredict.ShapedOreRecipe;

public class Tortoise {
	public static ShapedOreRecipe getRecipe() {
		return new ShapedOreRecipe(
				li.cil.oc.api.Items.get("robot").createItemStack(1),
				"ICI",
				"IRI",
				"IGI",
				'I', Items.iron_ingot,
				'C', Blocks.coal_block,
				'R', Blocks.redstone_block,
				'G', Blocks.glass_pane) {
			@Override
			public ItemStack getCraftingResult(InventoryCrafting var1) {
				ItemStack itemStack = super.getCraftingResult(var1);
				itemStack.setTagCompound(Tortoise.getTortoiseNBT());
				return itemStack;
			}
		};
	}

	private static NBTTagCompound getTortoiseNBT() {
		NBTTagCompound nbt = new NBTTagCompound();
		if (!nbt.hasKey("display")) {
			nbt.setTag("display", new NBTTagCompound());
		}
		nbt.getCompoundTag("display").setString("Name", "Tortoise");
		nbt.setInteger("oc:storedEnergy", 0);
		nbt.setInteger("oc:robotEnergy", 0);
		nbt.setInteger("oc:tier", 2);
		setNewTagList(nbt, "oc:components", new NBTBase[]{
				getNbt("screen1"),
				getNbt("keyboard"),
				getNbt("inventoryUpgrade"),
				getNbt("inventoryControllerUpgrade"),
				getNbt("tankUpgrade"),
				getNbt("tankControllerUpgrade"),
				getNbt("craftingUpgrade"),
				getNbt("chunkloaderUpgrade"),
				getNbt("hoverUpgrade2"),
				getNbt("angelUpgrade"),
				toNbt(ItemUpgradePerpetualGenerator.getItemStack()),
				getNbt("geolyzer"),

				getNbt("graphicsCard3"),
				getNbt("redstoneCard2"),
				getNbt("wlanCard"),
				getNbt("internetCard"),

				getNbt("cpu3"),
				getNbt("ram6"),
				getNbt("ram6"),

				getNbt("luaBios"),
				getNbt("openOS"),
				getNbt("hdd3")
		});
		setNewTagList(nbt, "oc:containers", new NBTBase[]{
				getNbt("cardContainer3"),
				getNbt("upgradeContainer3"),
				getNbt("diskDrive")
		});
		nbt.setInteger("oc:lightColor", 0xF23030);
		return nbt;
	}

	private static NBTTagCompound getNbt(String name) {
		return toNbt(li.cil.oc.api.Items.get(name).createItemStack(1));
	}

	private static NBTTagCompound toNbt(ItemStack value) {
		NBTTagCompound nbt = new NBTTagCompound();
		if (value != null) {
			value.writeToNBT(nbt);
		}
		return nbt;
	}

	private static void setNewTagList(NBTTagCompound nbt, String name, NBTBase[] values) {
		NBTTagList t = new NBTTagList();
		append(t, values);
		nbt.setTag(name, t);
	}

	private static void append(NBTTagList nbt, NBTBase[] values) {
		for (NBTBase value : values) {
			nbt.appendTag(value);
		}
	}
}
