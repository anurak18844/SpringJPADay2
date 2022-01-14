package nvc.bcit.soi5shopstart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvc.bcit.soi5shopstart.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findByNameContaining(String name);

    public List<Product> findByPriceLessThanEqual(double price);

    public List<Product> findByUnitInStockGreaterThanEqual(int unit_in_stock);
}
