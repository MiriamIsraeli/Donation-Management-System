package com.example.project.Services;

import com.example.project.Models.Donation;
import com.example.project.Models.Donor;
import com.example.project.Repositories.DonationRepository;
import com.example.project.Repositories.DonorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DonorServices {
    private final DonationRepository repository;
    private final DonorRepository donorRepository;
    public DonorServices(DonationRepository repository, DonorRepository donorRepository)
    {
        this.repository=repository;
        this.donorRepository= donorRepository;
    }
    public double sumdonor(String d) {
        List<Donation> donations = repository.findAll().stream().filter(X -> X.getPhone() == d).toList();
        if (!donations.isEmpty())
        {
           return donations.stream().mapToDouble(x-> x.getSum()).sum();
        }
        else
            return -1;
    }
    public void addDonor(Donor d)
    {

        donorRepository.save(d);
    }
    public double sumdonor1(Donor d)
    {
        double sum = sumdonor(d.getPhone());
        return sum;
    }
    public List<Donation> AllDonation(Donor d)
    {
        List<Donation> list = repository.findAll().stream().filter(X -> X.getPhone() == d.getPhone()).toList();
        return list;
    }
}
