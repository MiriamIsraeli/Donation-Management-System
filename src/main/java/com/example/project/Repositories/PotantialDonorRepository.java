package com.example.project.Repositories;

import com.example.project.Models.PotantialDonor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotantialDonorRepository extends JpaRepository<PotantialDonor,String> {


}
