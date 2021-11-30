package com.example.springbootquiz.controllers;

import com.example.springbootquiz.models.Client;
import com.example.springbootquiz.models.Sale;
import com.example.springbootquiz.service.SaleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaleController {
    public SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }
    @GetMapping(path = "/api/v1/sales")
    List<Sale> getSales()  {
        return saleService.getListOfSales();
    }
    @PostMapping(path = "api/v1/add_sale")
    void addNewSale(@RequestBody(required = true) Sale sale) {
        saleService.saveSale(sale);
    }
    @PostMapping(path = "api/v1/edit_sale")
    void editExistSale(@RequestBody(required = true) Sale sale) {
        saleService.editSale(sale);
    }
}
