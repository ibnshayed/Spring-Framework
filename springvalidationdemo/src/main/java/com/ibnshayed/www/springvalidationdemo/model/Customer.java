package com.ibnshayed.www.springvalidationdemo.model;

import com.ibnshayed.www.springvalidationdemo.validation.CourseCode;
import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0,message = "Must be greater than or equal to zero")
    @Max(value = 100,message = "Must be lower than 100")
    private Integer freePasses;

    @NotNull(message = "is required")
    @Pattern(regexp = "^[a-zA-Z0-9 ]{5}",message = "only 5 chars/digits")
    private String postalCode;

    @NotNull(message = "is required")
    @CourseCode(value = "TOPS",message = "must be start with TOPS")
    private String courseCode;

}
