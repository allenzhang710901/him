package com.him.herobrineclone.registry; // 包名：registry子包

import com.him.herobrineclone.HerobrineCloneMod; // 导入主类：为了用 MODID
import com.him.herobrineclone.entity.HerobrineCloneEntity; // 导入实体类：为了引用构造器
import net.minecraft.world.entity.EntityType; // EntityType：实体类型（注册表里存的就是它）
import net.minecraft.world.entity.MobCategory; // MobCategory：生物分类（MONSTER/CREATURE等）
import net.minecraftforge.eventbus.api.IEventBus; // IEventBus：事件总线
import net.minecraftforge.registries.DeferredRegister; // DeferredRegister：延迟注册器（推荐注册方式）:contentReference[oaicite:3]{index=3}
import net.minecraftforge.registries.ForgeRegistries; // ForgeRegistries：Forge封装的各类注册表入口
import net.minecraftforge.registries.RegistryObject; // RegistryObject：延迟对象句柄（注册后用get取真实对象）:contentReference[oaicite:4]{index=4}

public class ModEntities { // 实体注册集中管理类

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = // 声明一个“实体类型”的延迟注册器
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, HerobrineCloneMod.MODID); // 绑定到实体类型注册表+你的modid :contentReference[oaicite:5]{index=5}

    public static final RegistryObject<EntityType<HerobrineCloneEntity>> HEROBRINE_CLONE = // 声明一个注册句柄：未来会注册出一个EntityType
            ENTITY_TYPES.register("herobrine_clone", () -> // register：注册名是herobrine_clone，后面lambda是创建EntityType的工厂
                    EntityType.Builder // EntityType构建器：一步步设置属性
                            .of(HerobrineCloneEntity::new, MobCategory.MONSTER) // of：指定实体构造器 + 生物分类（建议怪物更符合分身）  
                            .sized(0.6F, 1.8F) // 碰撞箱宽高：0.6x1.8，接近玩家/僵尸
                            .build("herobrine_clone") // build：最终构建EntityType（一般填注册名字符串）
            ); // 注册句柄结束

    public static void register(IEventBus modEventBus) { // 工具方法：让主类调用更清晰
        ENTITY_TYPES.register(modEventBus); // 把延迟注册器挂到Mod事件总线，否则不会真正注册 :contentReference[oaicite:6]{index=6}
    } // 方法结束
} // 类结束
