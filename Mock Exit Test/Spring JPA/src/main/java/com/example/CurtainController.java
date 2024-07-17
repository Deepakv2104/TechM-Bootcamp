package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/curtains")
public class CurtainController {

    @Autowired
    private CurtainService curtainService;

    @GetMapping("/price/{price}")
    public List<Curtain> getCurtainsByPrice(@PathVariable("price") int price) {
        return curtainService.getCurtainsByPrice(price);
    }

    @GetMapping("/brand/{brand}")
    public List<Curtain> getCurtainsByBrand(@PathVariable("brand") String brand) {
        return curtainService.getCurtainsByBrand(brand);
    }
}
