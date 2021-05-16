package ru.itis.game.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Shot {
    private Long id;
    // кто стрелял
    private Player shooter;
    // в кого стрелял
    private Player target;
    private Game game;
}
