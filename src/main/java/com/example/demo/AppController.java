package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private ProdutoService service;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Produto> listProduto = service.listAll();
        model.addAttribute("listProduto",listProduto);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProdutoForm(Model model){
        Produto produto = new Produto();
        model.addAttribute("Produto",produto);
        return "new_produto";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveProduto(@ModelAttribute("produto") Produto produto){
        service.save(produto);
        return "redirect:/";
    }

    @RequestMapping("edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_produto");

        Produto produto = service.get(id);
        mav.addObject("produto",produto);

        return mav;
    }

    @RequestMapping("delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
            service.delete(id);

            return "redirect:/";
    }

}
