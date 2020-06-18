package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoReposiTory repo;

    public List<Produto> listAll(){
        return repo.findAll();
    }
    public void save(Produto produto ){
        repo.save(produto);
    }
    public Produto get(Long id){
        return repo.findById(id).get();
    }
    public  void delete(Long id){
        repo.deleteById(id);
    }
}
