package com.blooddonate.eis.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {

    public ResponseEntity<?> MapValidationService(BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            result.getFieldErrors().forEach(error -> errorMap.put(error.getField(),error.getDefaultMessage()));
            return new ResponseEntity<Map<String,String >>(errorMap, HttpStatus.BAD_REQUEST);
           /* for (FieldError error : result.getFieldErrors()){
                errorMap.put(error.getField(),error.getDefaultMessage());
            }*/
            //return new ResponseEntity<Map<String,String >>(errorMap,HttpStatus.BAD_REQUEST);
            //return new ResponseEntity<List<FieldError>>(result.getFieldErrors(),HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
