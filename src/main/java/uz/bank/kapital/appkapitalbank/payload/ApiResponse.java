package uz.bank.kapital.appkapitalbank.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private String message;
    private Boolean success;
    private Object object;

    public ApiResponse(String message, Boolean success) {
        this.message = message;
        this.success = success;
    }

    public ApiResponse(Boolean success, Object object) {
        this.success = success;
        this.object = object;
    }
}
