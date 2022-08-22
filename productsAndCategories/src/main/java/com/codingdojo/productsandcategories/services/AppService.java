package com.codingdojo.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productsandcategories.models.Category;
import com.codingdojo.productsandcategories.models.Product;
import com.codingdojo.productsandcategories.repositories.CategoryRepository;
import com.codingdojo.productsandcategories.repositories.ProductRepository;

@Service
public class AppService {
	
	//Create repositories
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	//All
    public List<Product> allProducts() {
        return (List<Product>) productRepository.findAll();
    }
    public List<Category> allCategories() {
        return (List<Category>) categoryRepository.findAll();
    }
	
    
	//Create
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
	//Read
    public Product findProductById(Long id) {
    	return productRepository.findById(id).orElse(null);
    }
	//Update
	public Product updateProduct(Product product) {
        return productRepository.save(product);
	}
	//Delete
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
    
    
    //Create
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
    //Read
    public Category findCategoryById(Long id) {
    	return categoryRepository.findById(id).orElse(null);
    }
    //Update
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}
	//Delete
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
	
	//Add relationship between product and category
	public void categorizeProduct(Long productId, Long categoryId) {
		Category thisCategory = findCategoryById(categoryId);
	
		Product thisProduct = findProductById(productId);
	
		thisCategory.getProducts().add(thisProduct);
	
		categoryRepository.save(thisCategory);
	}
	
	//Returns a list of categories to which the given product does not belong
	public List<Category> getCategoryOptionsByProduct(Product product) {
		return categoryRepository.findByProductsNotContains(product);
	}

	//Returns a list of products that do not belong to the given category.
	public List<Product> getProductsNotInCategory(Category category) {
		return productRepository.findByCategoriesNotContains((category));
	}
}
