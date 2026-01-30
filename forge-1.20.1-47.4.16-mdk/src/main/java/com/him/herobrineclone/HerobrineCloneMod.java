package com.him.herobrineclone; // 声明包名：必须和文件夹路径一致（com/him/herobrineclone）

import com.him.herobrineclone.registry.ModEntities; // 导入实体注册类：让本文件能直接用 ModEntities
import com.him.herobrineclone.registry.ModItems; // 导入物品注册类：让本文件能直接用 ModItems
import net.minecraftforge.eventbus.api.IEventBus; // 导入IEventBus：Forge的事件总线接口
import net.minecraftforge.fml.common.Mod; // 导入@Mod：标记“模组入口类”
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext; // 导入加载上下文：拿到Mod事件总线

@Mod(HerobrineCloneMod.MODID) // @Mod：告诉Forge“这是一个模组”，参数是modid
public class HerobrineCloneMod { // 定义类：模组主类（入口）

    public static final String MODID = "herobrineclone"; // 常量：你的modid（必须与mods.toml里的modId完全一致）

    public HerobrineCloneMod() { // 构造方法：Forge加载模组时会new这个类并执行这里
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus(); // 获取“Mod事件总线”，用于注册实体/物品等（常见做法）:contentReference[oaicite:2]{index=2}
        ModEntities.register(modEventBus); // 调用实体注册：把DeferredRegister挂到Mod总线上
        ModItems.register(modEventBus); // 调用物品注册：把DeferredRegister挂到Mod总线上
    } // 构造方法结束
} // 类结束
