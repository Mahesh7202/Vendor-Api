package com.example.Vendor.model;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseBody {

    private int status;
    private String message;

}
