package tesis.controllers.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.item.Category;
import tesis.services.item.CategoryService;

import java.util.Map;

@RestController
@RequestMapping("/catalog/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping()
    public String createCategory(@RequestBody Category category) throws JsonProcessingException {
        return categoryService.createCategory(category);
    }

    @GetMapping()
    public Category getCategory(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return categoryService.getCategory(param);
    }

    @GetMapping("/search")
    public Category[] searchCategory(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return categoryService.searchCategories(param);
    }

    @PutMapping()
    public String updateCategory(@RequestBody Category category) throws JsonProcessingException {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping()
    public String deleteCategory(@RequestBody Map<String, String> param) throws JsonProcessingException {
        return categoryService.deleteCategory(param);
    }
}
