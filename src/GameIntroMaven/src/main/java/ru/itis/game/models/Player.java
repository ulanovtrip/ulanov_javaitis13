package ru.itis.game.models;

// класс - модель, тут только поля

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {
    private Long id;
    private String nickname;
    // score - кол-во попаданий в противника
    private Integer score;
    private Integer winsCount;
    private Integer losesCount;
}
