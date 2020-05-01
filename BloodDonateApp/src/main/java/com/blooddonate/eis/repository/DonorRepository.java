package com.blooddonate.eis.repository;

import com.blooddonate.eis.model.Donor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends CrudRepository<Donor,Long> {
}
