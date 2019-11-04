package tesis.controllers.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesis.entities.dtos.item.Category;
import tesis.services.item.CategoryService;

import java.util.Map;

@RestController
@CrossOrigin(allowedHeaders = "*", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/catalog/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping()
    public String createCategory(@RequestBody Category category) throws JsonProcessingException {
        return categoryService.createCategory(category);
    }

    @GetMapping()
    public Category getCategory(@RequestParam Map<String, String> category_id) throws JsonProcessingException {
        return categoryService.getCategory(category_id);
    }

    @GetMapping("/get_all")
    public Category[] getAllCategory() throws JsonProcessingException {
        return categoryService.getAllCategory();
    }

    @GetMapping("/search")
    public Category[] searchCategory(@RequestParam Map<String, String> param) throws JsonProcessingException {
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
