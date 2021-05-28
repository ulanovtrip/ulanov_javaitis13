package ru.itis.game.sockets.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

// DTO - DataTransferObject - это классы, объекты которых используются для передчи данных между системами
// он будет конвертироваться в JSON
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MessageDto {
    private String text;
    private String from;
    private LocalDateTime dispatchDateTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<String> tags;
}
