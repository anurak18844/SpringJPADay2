package nvc.bcit.soi5shopstart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import nvc.bcit.soi5shopstart.model.Category;
import nvc.bcit.soi5shopstart.model.Product;
import nvc.bcit.soi5shopstart.repository.CategoryRepository;
import nvc.bcit.soi5shopstart.service.ProductService;

@Controller
public class MainController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepository categoryRepository;


    @GetMapping("/")
    public String index () {
        return "index";
    }
   
    @GetMapping("/product")
    public ModelAndView product () {
        List<Product> products = productService.findAll();
        return new ModelAndView("product", "products", products);
    }

    @GetMapping("/product/new")
    public String newProduct () {
        return "newproduct";
    }

    @GetMapping("/product/edit")
    public String editProduct () {
        return "editproduct";
    }

    @GetMapping("/category/product")
    public ModelAndView category () {
        List<Category> gategories = categoryRepository.findAll();
        return new ModelAndView("category", "categories", gategories);
    }

    @GetMapping("/product/name/{name}")
    public ModelAndView getProdutByName (@PathVariable("name") String name) {
        List<Product> products = productService.findByName(name);
        return new ModelAndView("product", "products", products);
    }

    @GetMapping("/product/price/{price}")
    public ModelAndView getProdutByPrice (@PathVariable("price") double price) {
        List<Product> products = productService.findByPrice(price);
        return new ModelAndView("product", "products", products);
    }

    @GetMapping("/product/unitinstock/{unit_in_stock}")
    public ModelAndView getProdutUnitInStock (@PathVariable("unit_in_stock") int unit_in_stock) {
        List<Product> products = productService.findByUnitInStock(unit_in_stock);
        return new ModelAndView("product", "products", products);
    }

}
