package me.animaengine.example.entity

import me.animaengine.entity.Entity
import me.animaengine.entity.component.State
import me.animaengine.g2d.entity.component.Animations2D
import me.animaengine.g2d.entity.component.Movement2D
import me.animaengine.example.entity.component.*
import me.animaengine.example.graphics.entity.*

class Enemy(
    x: Float,
    y: Float
) : Entity() {
    init {
        addComponents(
            State(EntityState.IDLE),
            Movement2D(300f),
            Position(x, y, 50, 50),
            Attack(1f, 40f, 400, 40f),
            Health(5f, 1_000),
            EnemyAI(null),
            Collideable(),
            Animations2D(
                EntityAnimation.IDLE_LEFT,
                mapOf(
                    EntityAnimation.IDLE_LEFT to PlayerIdleLeftAnimation(),
                    EntityAnimation.IDLE_RIGHT to PlayerIdleRightAnimation(),
                    EntityAnimation.WALK_LEFT to PlayerWalkLeftAnimation(),
                    EntityAnimation.WALK_RIGHT to PlayerWalkRightAnimation(),
                    EntityAnimation.ATTACK_LEFT to PlayerAttackLeftAnimation(),
                    EntityAnimation.ATTACK_RIGHT to PlayerAttackRightAnimation(),
                    EntityAnimation.DAMAGE_LEFT to PlayerDamageLeftAnimation(),
                    EntityAnimation.DAMAGE_RIGHT to PlayerDamageRightAnimation(),
                    EntityAnimation.DIE_LEFT to PlayerDieLeftAnimation(),
                    EntityAnimation.DIE_RIGHT to PlayerDieRightAnimation()
                ),
                100,
                100,
                -25
            )
        )
    }
}