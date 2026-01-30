package com.him.herobrineclone.event; // 包名：event子包

import com.him.herobrineclone.HerobrineCloneMod; // 导入MODID
import com.him.herobrineclone.entity.HerobrineCloneEntity; // 导入实体类：拿属性工厂
import com.him.herobrineclone.registry.ModEntities; // 导入实体类型：用于绑定属性
import net.minecraftforge.event.entity.EntityAttributeCreationEvent; // 实体属性创建事件
import net.minecraftforge.eventbus.api.SubscribeEvent; // @SubscribeEvent：订阅事件注解
import net.minecraftforge.fml.common.Mod; // Mod事件订阅者注解

@Mod.EventBusSubscriber(modid = HerobrineCloneMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD) // 订阅“Mod总线”上的事件
public class ModCommonEvents { // 事件处理类

    @SubscribeEvent // 标记：下面方法是事件监听器
    public static void onEntityAttributes(EntityAttributeCreationEvent event) { // Forge要求在这里给实体类型绑定属性
        event.put(ModEntities.HEROBRINE_CLONE.get(), HerobrineCloneEntity.createAttributes().build()); // 把实体类型 -> 属性集合绑定进去 :contentReference[oaicite:14]{index=14}
    } // 方法结束
} // 类结束
