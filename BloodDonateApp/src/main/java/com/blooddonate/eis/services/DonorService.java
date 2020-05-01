package com.blooddonate.eis.services;

import com.blooddonate.eis.exceptions.DonorIdException;
import com.blooddonate.eis.model.Donor;
import com.blooddonate.eis.repository.DonorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonorService {
    private final DonorRepository donorRepo;

    //  CREATE
    public Donor saveOrUpdateDonor(Donor donor){
        return donorRepo.save(donor);
    }

    // FIND
    public Donor donorFindById(long id){
        Donor donor = donorRepo.findById(id).orElse(null);
        if (donor == null){
            throw new DonorIdException("Donor Id '" + id + "' does not exist.");
        }
        return donor;
    }

    // FIND ALL
    public Iterable<Donor> findAllDonors(){
        return donorRepo.findAll();
    }

    //DELTE
    public void deleteDonorById(long id){
        Donor donor = donorRepo.findById(id).orElse(null);
        if(donor == null){
            throw new DonorIdException("The Donor With ID '"+id+"' is not exist.");
        }

        donorRepo.delete(donor);
    }





}
