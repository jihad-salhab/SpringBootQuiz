package com.example.springbootquiz.service;

import com.example.springbootquiz.data.SaleRepo;
import com.example.springbootquiz.models.Sale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class SaleService {

    Logger logger = LoggerFactory.getLogger(SaleService.class);
    private SaleRepo saleRepo;

    public SaleService(SaleRepo saleRepo) {
        this.saleRepo = saleRepo;
    }
    public List<Sale> getListOfSales() {
        List<Sale> sales = new ArrayList<>();
        saleRepo.findAll().forEach(sales::add);
        return sales;
    }
    public void saveSale(Sale sale) {
        logger.info("sale add"+sale.getId());
        saleRepo.save(sale);
    }
    public void editSale(Sale sale) {
        Sale existingSaleDetails = saleRepo.findById(sale.getId()).orElseThrow(
                () -> new ResourceNotFoundException("product Not Found"));
        if (sale.getSaleQuantities() != null){
            existingSaleDetails.setSaleQuantities(sale.getSaleQuantities());
        }
        if (sale.getSaleTotal()!= null){
            existingSaleDetails.setSaleTotal(sale.getSaleTotal());
        }
        logger.info("sale edit"+sale.getId());


        saleRepo.save(existingSaleDetails);
    }
}
