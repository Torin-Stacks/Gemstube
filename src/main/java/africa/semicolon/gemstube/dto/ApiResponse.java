package africa.semicolon.gemstube.dto;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private String message;
    private T data;
}
