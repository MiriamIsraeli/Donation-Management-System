package com.example.project.Services;

import com.example.project.Models.Donor;
import com.example.project.Models.PotantialDonor;
import com.example.project.Repositories.PotantialDonorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PotantialDonorServices {
    private final PotantialDonorRepository repository;

    public PotantialDonorServices(PotantialDonorRepository repository)
    {
        this.repository = repository;
    }
    public String getFirst()
    {
        if(!repository.findAll().isEmpty())
            return repository.findAll().get(0).getPhone();
        return "000";
    }
    public void add(PotantialDonor donor)
    {
        repository.save(donor);
    }
}
