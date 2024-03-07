package codegym.vn.service.impl;

import codegym.vn.entity.Product;
import codegym.vn.repository.ProductRepository;
import codegym.vn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Override
    public boolean create(Product product) {
        repository.save(product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        repository.save(product);
        return true;
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
         repository.deleteById(id);
        return true;
    }

    @Override
    public List<Product> findAllByName(String name) {
        return repository.findAllByNameContaining(name);
    }

    @Override
    public List<Product> search(String name) {
        return repository.search(name);
    }
}
