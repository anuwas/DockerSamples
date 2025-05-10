package pack.anu.pam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pack.anu.pam.dao.Product;
import pack.anu.pam.dao.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class AppController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/test")
    public String testController(){
        return "Hello from test controller";
    }

    @GetMapping("getproduct/{id}")
    public Product getProductByID(@PathVariable Long id){
        Optional<Product> prd = productRepository.findById(id);
        return prd.get();
    }

    @GetMapping("list")
    public List<Product> getProductList(){
        return productRepository.findAll();
    }

    @GetMapping("add")
    public String addProductList(){
       Product p = new Product();

        p.setName("Name ");
        p.setDescription("Description ");
        p.setPrice(100);
        productRepository.save(p);
        return "added";
    }
}
