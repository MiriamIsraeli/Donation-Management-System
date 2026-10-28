package com.example.project.Services;

import com.example.project.Models.Donation;
import com.example.project.Models.Donor;
import com.example.project.Repositories.DonationRepository;
import com.example.project.Repositories.DonorRepository;
import com.example.project.Repositories.PotantialDonorRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationServices {
    private final DonationRepository repository;
    private final DonorRepository donorRepository;
    private final PotantialDonorRepository potantialDonorRepository;

    public DonationServices(DonationRepository repository, DonorRepository donorRepository, PotantialDonorRepository potantialDonorRepository) {
        this.repository = repository;
        this.donorRepository = donorRepository;
        this.potantialDonorRepository = potantialDonorRepository;
    }
    public String insertDonation(Donation donation)
    {
        if(donation.getSum() != 0)
        {
            if(!donorRepository.existsById(donation.getPhone()))
                donorRepository.save(new Donor(donation.getPhone()));
            repository.save(donation);
            if(potantialDonorRepository.existsById(donation.getPhone()))
                potantialDonorRepository.deleteById(donation.getPhone());
            return "ADD";

        }
        return "not money";
    }
    public double GetSumDonation()
    {
        double sum = 0;
        for(int i=0 ; i<repository.count() ; i++)
          sum+= repository.findAll().get(i).getNumPayment();
        return sum;
    }
    public List<Donation> sortdate(){
        List <Donation> list = repository.findAll(Sort.by("date").descending());
        return list;
    }
}
