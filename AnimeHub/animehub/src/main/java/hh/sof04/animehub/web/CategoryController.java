package hh.sof04.animehub.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof04.animehub.domain.Category;
import hh.sof04.animehub.domain.CategoryRepository;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categoryList")
    public String GetCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categoryList";
    }

    @GetMapping("/addCategory")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/categorylist";
    }

    @PostMapping("/deleteCategory/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) {
        categoryRepository.deleteById(categoryId);
        return "redirect:/categorylist";
    }    

    @GetMapping("/editCategory/{categoryId}")
    public String showEditCategoryForm(@PathVariable Long categoryId, Model model) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + categoryId));
        model.addAttribute("category", category);
        return "editcategory";
    }
}
