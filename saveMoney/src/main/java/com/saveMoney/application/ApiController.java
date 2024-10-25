package com.saveMoney.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class ApiController {
    @Autowired
    private ApiService apiService;

    @GetMapping("/savemoney")
    @ApiOperation(value = "Get Home", notes = "Returns a welcome message.")
    public String getHome() {
        return "Welcome to SaveMoney server";
    }

    @PostMapping("/registersupermarket")
    @ApiOperation(value = "Register SuperMarket", notes = "Registers a SuperMarket.")
    public RegisterSuperMarket registersupermarket(@RequestBody RegisterSuperMarket rsm) {
        apiService.handleRegisterSuperMarket(rsm);
        return rsm;
    }

    @PostMapping("/registergasstation")
    @ApiOperation(value = "Register GasStation", notes = "Registers a GasStation.")
    public RegisterGasStation registergasstation(@RequestBody RegisterGasStation rgs) {
        apiService.handleRegisterGasStation(rgs);
        return rgs;
    }

    @GetMapping(value = "/supermarket/username={username}/count={count}", produces = { "application/json" })
    @ApiOperation(value = "Update Person Count at SuperMarket", notes = "Updates the count of persons at a SuperMarket.")
    public void updatePersonCountSuperMarket(@ApiParam(value = "Username", required = true) @PathVariable String username,
                                             @ApiParam(value = "Count", required = true) @PathVariable String count) {
        apiService.updatePersonCountSuperMarket(username, Integer.parseInt(count));
        //Return type should be Error/Success code...!!!!
    }

    // Add similar annotations for other methods
}