package mk.ukim.finki.emt.eshop.service;


import mk.ukim.finki.emt.eshop.model.enumerations.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();
}
