package ru.itis.game.services;

/**
 * 14.05.2021
 * GameIntroMaven
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface GameLogicService {
    boolean isHitTarget(Long shooterId, Long targetId);
}
