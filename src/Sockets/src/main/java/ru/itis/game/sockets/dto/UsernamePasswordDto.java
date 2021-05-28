package ru.itis.game.sockets.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO - DataTransferObject - это классы, объекты которых используются для передчи данных между системами
// он будет конвертироваться в JSON
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsernamePasswordDto {
    private String nickname;
    private String password;
}
