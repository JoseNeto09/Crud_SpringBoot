package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ProdutoReposiTory extends JpaRepository<Produto,Long>{

}
