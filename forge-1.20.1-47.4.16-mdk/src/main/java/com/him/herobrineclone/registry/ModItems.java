package com.him.herobrineclone.registry; // 包名：registry子包

import com.him.herobrineclone.HerobrineCloneMod; // 导入主类：为了用MODID
import net.minecraft.world.item.CreativeModeTabs; // 创造模式标签页常量
import net.minecraft.world.item.Item; // Item：物品基类
import net.minecraft.world.item.SpawnEggItem; // SpawnEggItem：刷怪蛋物品
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent; // 创造栏填充事件：把物品塞进某个tab :contentReference[oaicite:7]{index=7}
import net.minecraftforge.eventbus.api.IEventBus; // IEventBus：事件总线
import net.minecraftforge.registries.DeferredRegister; // DeferredRegister：延迟注册器 :contentReference[oaicite:8]{index=8}
import net.minecraftforge.registries.ForgeRegistries; // ForgeRegistries：物品注册表入口
import net.minecraftforge.registries.RegistryObject; // RegistryObject：注册句柄

public class ModItems { // 物品注册集中管理类

    public static final DeferredRegister<Item> ITEMS = // 创建物品延迟注册器
            DeferredRegister.create(ForgeRegistries.ITEMS, HerobrineCloneMod.MODID); // 绑定到物品注册表+你的MODID :contentReference[oaicite:9]{index=9}

    public static final RegistryObject<Item> HEROBRINE_CLONE_SPAWN_EGG = // 刷怪蛋注册句柄
            ITEMS.register("herobrine_clone_spawn_egg", () -> // 注册名：herobrine_clone_spawn_egg
                    new SpawnEggItem( // 创建刷怪蛋实例
                            ModEntities.HEROBRINE_CLONE.get(), // ✅关键：必须是EntityType，所以要.get()取出真实对象（修复你报错）:contentReference[oaicite:10]{index=10}
                            0x1E1E1E, // 底色：深灰（RGB十六进制）
                            0xFFFFFF, // 斑点色：白色（RGB十六进制）
                            new Item.Properties() // 物品属性：这里用默认属性
                    ) // SpawnEggItem构造结束
            ); // register结束

    public static void register(IEventBus modEventBus) { // 工具方法：主类调用
        ITEMS.register(modEventBus); // 把物品延迟注册器挂到Mod事件总线 :contentReference[oaicite:11]{index=11}
        modEventBus.addListener(ModItems::addToCreativeTab); // 监听创造栏填充事件：往刷怪蛋tab里塞入本刷怪蛋 :contentReference[oaicite:12]{index=12}
    } // 方法结束

    private static void addToCreativeTab(BuildCreativeModeTabContentsEvent event) { // 事件回调：Forge构建创造栏内容时调用
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) { // 判断当前是不是“刷怪蛋”tab
            event.accept(HEROBRINE_CLONE_SPAWN_EGG.get()); // 把我们的刷怪蛋加入该tab
        } // if结束
    } // 方法结束
} // 类结束
