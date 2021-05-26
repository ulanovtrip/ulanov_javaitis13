package ru.itis.game.sockets.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 23.05.2021
 * 33. Sockets
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// DTO - DataTransferObject - это классы, объекты которых используются для передчи данных между системами
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
