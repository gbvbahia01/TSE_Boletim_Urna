package com.gbvbahia.tre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gbvbahia.tre.model.BoletimUrna;

@Repository
public interface BoletimUrnaRepository extends JpaRepository<BoletimUrna, Long> {

}
