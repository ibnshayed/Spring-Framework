package com.ibnshayed.www.exceptions;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ProjectIdExceptionResponse {
    private String projectIddentifier;
}
