package com.example.project.Controllers;

import com.example.project.Models.PotantialDonor;
import com.example.project.Services.PotantialDonorServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PotantialDonorControllers {
    private final PotantialDonorServices Pservices;
    public PotantialDonorControllers (PotantialDonorServices Pservices)
    {
        this.Pservices = Pservices;
    }

    @GetMapping("/getFirst")
    public String _getFirst()
    {
        return Pservices.getFirst();
    }


    @PostMapping("/add")
    public void _add(@RequestBody PotantialDonor donor)
    {
        Pservices.add(donor);
    }
}
