package br.com.fiap.appprodutoteste.produto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.fiap.appprodutoteste.produto.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	
}
