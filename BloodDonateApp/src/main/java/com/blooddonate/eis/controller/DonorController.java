package com.blooddonate.eis.controller;

import com.blooddonate.eis.model.Donor;
import com.blooddonate.eis.services.DonorService;
import com.blooddonate.eis.services.MapValidationErrorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/donor")
@RequiredArgsConstructor
public class DonorController {
    private final DonorService donorService;
    private final MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createADonor(@Valid @RequestBody Donor donor , BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        Donor donor1 = donorService.saveOrUpdateDonor(donor);
        return new ResponseEntity<Donor>(donor,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDonorById(@PathVariable long id){
        Donor donor = donorService.donorFindById(id);
        return new ResponseEntity<Donor>(donor, HttpStatus.OK);
    }
}
