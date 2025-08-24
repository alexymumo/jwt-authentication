package com.technobraintask.ecommerce_api.service;

import com.technobraintask.ecommerce_api.models.Product;
import com.technobraintask.ecommerce_api.repository.ProductRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }


    public Product updateProduct(Product updatedProduct) {
        return productRepository.save(updatedProduct);
    }

    // Jasper reports
    public String generateReports() {
        try {
            List<Product> products = productRepository.findAll();
            String reportPath = "C:\\Users\\alex.mumo\\Desktop";

            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath + "\\report.jrxml");
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(products);
            Map<String,Object> parameters = new HashMap<>();
            parameters.put("createdBy","alex.com");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,jrBeanCollectionDataSource);

            JasperExportManager.exportReportToPdfFile(jasperPrint,reportPath + "test.report");
            return "Report generated successfully" + reportPath;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }
}
