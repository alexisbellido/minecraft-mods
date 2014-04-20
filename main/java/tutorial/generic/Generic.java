package tutorial.generic;

//This Import list will grow longer with each additional tutorial.
//It's not pruned between full class postings, unlike other tutorial code.
//import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
//import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;  //1.6.X
//import cpw.mods.fml.common.Mod.PostInit;
//import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
//import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;


@Mod(modid = "Generic", name = "Generic", version = "0.0.0")
//@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = { "GenericRandom" })
public class Generic {

 @Instance("Generic")
 public static Generic instance;

 @SidedProxy(clientSide = "tutorial.generic.client.ClientProxy", serverSide = "tutorial.generic.CommonProxy")
 public static CommonProxy proxy;

 @EventHandler
 public void preInit (FMLPreInitializationEvent event) {
     // Stub Method
 }

 @EventHandler
 public void load (FMLInitializationEvent event) {
     proxy.registerRenderers();

     ItemStack sandStack            = new ItemStack(Blocks.sand);
     ItemStack dirtStack            = new ItemStack(Blocks.dirt);
     ItemStack diamondStack  = new ItemStack(Items.diamond);
     ItemStack diamondsStack  = new ItemStack(Items.diamond, 64);
     ItemStack blackWoolStack  = new ItemStack(Blocks.wool, 42, 15);
     ItemStack gravelStack        = new ItemStack(Blocks.gravel);
     ItemStack cobbleStack       = new ItemStack(Blocks.cobblestone);
     ItemStack diamondPickAxe  = new ItemStack(Items.diamond_pickaxe, 16);
     

     GameRegistry.addShapelessRecipe(diamondsStack, dirtStack);
     GameRegistry.addShapelessRecipe(diamondsStack, sandStack);
     GameRegistry.addShapelessRecipe(diamondPickAxe, diamondStack);

     GameRegistry.addShapelessRecipe(diamondsStack, dirtStack, dirtStack,
             dirtStack, dirtStack, dirtStack, dirtStack, new ItemStack(
                     Blocks.sand), gravelStack, cobbleStack);

     GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone), "xy", "yx",
             'x', dirtStack, 'y', gravelStack);

     GameRegistry.addRecipe(new ItemStack(Blocks.stone), "xyx", "y y", "xyx",
             'x', dirtStack, 'y', gravelStack);

     GameRegistry.addSmelting(Blocks.stone, new ItemStack(
             Blocks.stonebrick), 0.1f);

//     FurnaceRecipes.smelting().addSmelting(Blocks.wool, 15,
//             new ItemStack(Blocks.wool, 1, 0), 0.1f);
 }

 @EventHandler
 public void postInit (FMLPostInitializationEvent event) {
     // Stub Method
 }
}