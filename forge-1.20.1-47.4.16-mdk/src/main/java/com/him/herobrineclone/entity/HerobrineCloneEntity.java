package com.him.herobrineclone.entity; // 包名：entity子包

import net.minecraft.world.entity.EntityType; // EntityType：实体类型
import net.minecraft.world.entity.ai.attributes.AttributeSupplier; // AttributeSupplier：属性集合（供注册）
import net.minecraft.world.entity.ai.attributes.Attributes; // Attributes：原版属性常量（血量/速度/伤害等）
import net.minecraft.world.entity.ai.goal.FloatGoal; // FloatGoal：水里漂浮防溺水
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal; // LookAtPlayerGoal：看向玩家
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal; // MeleeAttackGoal：近战攻击
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal; // RandomLookAroundGoal：随机张望
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal; // 随机走动（尽量避水）
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal; // 被谁打就反击的目标AI
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal; // 最近可攻击目标AI
import net.minecraft.world.entity.monster.Monster; // Monster：怪物基类（敌对生物常用）
import net.minecraft.world.entity.player.Player; // Player：玩家类
import net.minecraft.world.level.Level; // Level：世界对象

public class HerobrineCloneEntity extends Monster { // 继承Monster：自动获得怪物相关行为/接口

    public HerobrineCloneEntity(EntityType<? extends Monster> type, Level level) { // 构造器：创建实体时调用
        super(type, level); // 调用父类构造：完成基础初始化
    } // 构造器结束

    @Override // 表示重写父类方法（写错签名会报错）
    protected void registerGoals() { // 注册AI行为与目标
        this.goalSelector.addGoal(0, new FloatGoal(this)); // 0优先级最高：掉水里先浮上来
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, true)); // 近战攻击：速度1.2，持续追击
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D)); // 随机游走：速度1.0
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F)); // 看玩家：范围8格
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this)); // 随机张望：没事四处看
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this)); // 被打就把攻击者设为目标
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true)); // 主动寻找最近玩家做目标
    } // 方法结束

    public static AttributeSupplier.Builder createAttributes() { // 静态工厂：创建默认属性
        return Monster.createMonsterAttributes() // 以怪物默认属性为基础（更稳）
                .add(Attributes.MAX_HEALTH, 20.0D) // 最大生命：20（10颗心）
                .add(Attributes.MOVEMENT_SPEED, 0.25D) // 移速：0.25（接近僵尸）
                .add(Attributes.ATTACK_DAMAGE, 4.0D) // 伤害：4（2颗心）
                .add(Attributes.FOLLOW_RANGE, 32.0D); // 追踪范围：32格
    } // 方法结束
} // 类结束
