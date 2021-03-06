package com.aidmo.aidmod.items;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemBasicSword extends AidItem{

    public ItemBasicSword(){

        super("basicsword");
        this.setFull3D();
        this.setMaxStackSize(1);
        this.setMaxDamage(16);

    }

    public void setupTag(ItemStack stack){

        stack.setTagCompound(new NBTTagCompound());
        stack.getTagCompound().setDouble("strength",0);
        stack.getTagCompound().setDouble("maxstrength",100);
        stack.getTagCompound().setDouble("strengthpersecond", 2);
        stack.getTagCompound().setString("newsword", "none");
        stack.getTagCompound().setLong("strengthtime", System.currentTimeMillis());
    }

    @Override @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced){
        tooltip.clear();
        tooltip.add("A basic sword.");
        if(!stack.hasTagCompound()){
            setupTag(stack);
        }
    }
    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player){
        //player.addStat()
        if(!stack.hasTagCompound()){
            setupTag(stack);
        }
    }
    @Override
    public boolean onEntitySwing(EntityLivingBase ent, ItemStack stack){

        if(!stack.hasTagCompound()){
            setupTag(stack);
        }

        return false;
    }

}
