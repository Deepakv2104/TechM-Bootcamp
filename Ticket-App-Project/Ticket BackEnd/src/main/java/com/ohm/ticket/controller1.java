package com.ohm.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class controller1 {

    @RequestMapping("/greet")
    public String Greet(){
        return "<h2>Wellcome to Spring boot!!</h2>";
    }

    @RequestMapping("/search2")
    public  String getMovies(){

          return "<h2>Wait for sometime...coming soon</h2>";

    }

//    this controller is just for checking



}
