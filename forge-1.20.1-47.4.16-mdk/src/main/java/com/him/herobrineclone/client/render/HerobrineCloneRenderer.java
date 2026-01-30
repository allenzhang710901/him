package com.him.herobrineclone.client.render; // 包名：client.render子包

import com.him.herobrineclone.HerobrineCloneMod; // 导入MODID
import com.him.herobrineclone.entity.HerobrineCloneEntity; // 导入实体类
import net.minecraft.client.model.HumanoidModel; // HumanoidModel：类人模型（手脚头身体）
import net.minecraft.client.model.geom.ModelLayers; // ModelLayers：原版模型层（含PLAYER/盔甲层）
import net.minecraft.client.renderer.entity.EntityRendererProvider; // 渲染上下文
import net.minecraft.client.renderer.entity.HumanoidMobRenderer; // 类人怪物渲染器
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer; // 盔甲渲染层（可选）
import net.minecraft.resources.ResourceLocation; // 资源定位符（namespace:path -> 映射到assets里）

public class HerobrineCloneRenderer extends HumanoidMobRenderer<HerobrineCloneEntity, HumanoidModel<HerobrineCloneEntity>> { // 渲染器类：渲染我们的实体

    private static final ResourceLocation TEXTURE = new ResourceLocation(HerobrineCloneMod.MODID, "textures/entity/herobrine_clone.png"); // 贴图路径：assets/<modid>/textures/entity/xxx.png

    public HerobrineCloneRenderer(EntityRendererProvider.Context context) { // 构造器：Forge创建渲染器时调用
        super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER)), 0.5F); // 使用PLAYER模型层，阴影0.5
        this.addLayer(new HumanoidArmorLayer<>( // 添加盔甲层：让它穿装备时显示盔甲
                this, // 绑定到当前渲染器
                new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), // 内层盔甲模型
                new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), // 外层盔甲模型
                context.getModelManager() // 模型管理器
        )); // addLayer结束
    } // 构造器结束

    @Override // 重写：返回本实体使用的贴图
    public ResourceLocation getTextureLocation(HerobrineCloneEntity entity) { // 渲染时会调用这个方法问“贴图是哪张”
        return TEXTURE; // 返回贴图ResourceLocation
    } // 方法结束
} // 类结束
