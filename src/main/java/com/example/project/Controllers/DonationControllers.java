package com.example.project.Controllers;

import com.example.project.Models.Donation;
import com.example.project.Services.DonationServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DonationControllers {
    private final DonationServices services;
    public DonationControllers (DonationServices services)
    {
        this.services = services;
    }
    @PostMapping("/insertDonation")
    public String post_insert(@RequestBody Donation d)
    {
        return services.insertDonation(d);
    }
    @GetMapping("/GetSumDonation")
    public double get_all_sum()
    {
        return services.GetSumDonation();
    }

    @GetMapping("/sortdate")
    public List<Donation> sort()
    {
        return services.sortdate();
    }
}
