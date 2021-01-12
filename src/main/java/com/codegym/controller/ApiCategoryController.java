package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.ObjectUtils.isEmpty;


@RestController
public class ApiCategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/api/categories/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Category>> listAllCategory() {
        Iterable<Category> categories = (Iterable<Category>) categoryService.findAll();
        if (isEmpty(categories)) {
            return new ResponseEntity<Iterable<Category>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<Iterable<Category>>(categories, HttpStatus.OK);
    }


    @RequestMapping(value = "/api/categories/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getCustomer(@PathVariable("id") long id) {
        System.out.println("Fetching Category with id " + id);
        Category category = categoryService.findById(id);
        if (category == null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

}
