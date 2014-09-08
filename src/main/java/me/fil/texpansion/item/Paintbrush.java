package me.fil.texpansion.item;

import java.util.List;

import me.fil.texpansion.Manager;
import me.fil.texpansion.TExpansion;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class Paintbrush extends Item
{
	//public static String[] unlocalized_names = {"brushRed", "brushLime", "brushBlue", "brushYellow"};
	//public static String[] names = {"Red Paintbrush", "Lime Paintbrush", "Blue Paintbrush", "Yellow Paintbrush"};
	
	public static Icon[] icons;
	
	//public static String[] ICON = {"brushRed", "brushLime", "brushBlue", "brushYellow"};
	
	public Paintbrush(int id)
	{
		super(id);
		setHasSubtypes(true);
		setCreativeTab(TExpansion.tab);
		maxStackSize = 1;
		Manager.Names.item_unlocalized_names.put(this, new String[]{"brushRed", "brushLime", "brushBlue", "brushYellow"});
		Manager.Names.item_names.put(this, new String[]{"Red Paintbrush", "Lime Paintbrush", "Blue Paintbrush", "Yellow Paintbrush"});
		Manager.Icons.item_icons.put(this, new String[]{"brushRed", "brushLime", "brushBlue", "brushYellow"});
	}
	
	public String getUnlocalizedName(ItemStack stack)
	{
		//return names[stack.getItemDamage()];
		return Manager.Names.item_unlocalized_names.get(this)[stack.getItemDamage()];
	}
	
	public Icon getIconFromDamage(int damage)
	{
		return icons[damage];
	}
	
	public void registerIcons(IconRegister icon)
	{
		icons = new Icon[Manager.Icons.item_icons.get(this).length];
	
		for(int i = 0; i < icons.length; i++)
		{
			icons[i] = icon.registerIcon("texpansion:" + Manager.Icons.item_icons.get(this)[i]);
		}
	}
	
	public void getSubItems(int id, CreativeTabs tab, List list)
	{
		for(int i = 0; i < icons.length; i++)
		{
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}
}
