package ru.itis.game.services;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class GameLogicServiceRandomImpl implements GameLogicService {

    private SecureRandom random;

    public GameLogicServiceRandomImpl() {
        this.random = new SecureRandom();
    }

    @Override
    public boolean isHitTarget(Long shooterId, Long targetId) {
        return random.nextInt(10) > 4;
    }
}
