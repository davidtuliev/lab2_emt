package mk.ukim.finki.emt.eshop.service.impl;

import mk.ukim.finki.emt.eshop.model.enumerations.Category;
import mk.ukim.finki.emt.eshop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Override
    public List<Category> findAll() {
        return Arrays.asList(Category.values());
    }
}
