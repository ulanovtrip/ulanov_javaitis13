package ru.itis.game.services;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 14.05.2021
 * GameIntroMaven
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component(value = "simpleLogic")
public class GameLogicServiceRandomImpl implements GameLogicService {

    private Random random;

    public GameLogicServiceRandomImpl() {
        this.random = new Random();
    }

    @Override
    public boolean isHitTarget(Long shooterId, Long targetId) {
        return random.nextInt(10) > 4;
    }
}
