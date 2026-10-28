package com.example.project.Controllers;

import com.example.project.Models.Donation;
import com.example.project.Models.Donor;
import com.example.project.Services.DonorServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DonorControllers {
    private final DonorServices Dservices;
    public DonorControllers (DonorServices Dservices)
    {
        this.Dservices = Dservices;
    }
 @GetMapping("/sumdonor")
    public double sumdonor(@RequestBody String Phone)
 {
     return Dservices.sumdonor(Phone);
 }
 @PostMapping("/addDonor")
    public void _addDonor (@RequestBody Donor d)
 {
     Dservices.addDonor(d);
 }
  @GetMapping("/sumdonor1")
  public double _sumdonor1(@RequestBody Donor d)
  {
      return Dservices.sumdonor1(d);
  }
    @GetMapping("/AllDonation")
    public List<Donation> AllDonation(@RequestBody Donor d)
    {
        return Dservices.AllDonation(d);
    }
}
