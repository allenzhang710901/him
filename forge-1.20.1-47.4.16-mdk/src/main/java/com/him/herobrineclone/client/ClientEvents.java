package com.him.herobrineclone.client; // 包名：client子包（客户端专用）

import com.him.herobrineclone.HerobrineCloneMod; // 导入MODID
import com.him.herobrineclone.client.render.HerobrineCloneRenderer; // 导入渲染器类
import com.him.herobrineclone.registry.ModEntities; // 导入实体类型
import net.minecraftforge.api.distmarker.Dist; // Dist：区分客户端/服务端
import net.minecraftforge.client.event.EntityRenderersEvent; // 渲染器注册事件
import net.minecraftforge.eventbus.api.SubscribeEvent; // 订阅事件注解
import net.minecraftforge.fml.common.Mod; // 事件订阅者注解

@Mod.EventBusSubscriber(modid = HerobrineCloneMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT) // 仅客户端订阅
public class ClientEvents { // 客户端事件类

    @SubscribeEvent // 标记监听方法
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) { // 注册渲染器的正确时机 :contentReference[oaicite:16]{index=16}
        event.registerEntityRenderer(ModEntities.HEROBRINE_CLONE.get(), HerobrineCloneRenderer::new); // 绑定实体类型 -> 渲染器构造器
    } // 方法结束
} // 类结束
