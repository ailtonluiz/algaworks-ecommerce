package com.algaworks.ecommerce.iniciandocomjpa;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest {

    @Test
    public void inserirOPrimeiroObjeto() {
        Produto produto = new Produto();
        produto.setId(2);
        produto.setNome("Camera Canon");
        produto.setDescricao("A melhor definicao para suas fotos");
        produto.setPreco(new BigDecimal(5000));

        entityManager.getTransaction().begin();


        entityManager.persist(produto);


        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificao);


    }

    @Test
    public void abrirEFecharATransacao() {

        // Produto produto = new Produto();

        entityManager.getTransaction().begin();

//        entityManager.persist(produto);
//        entityManager.merge(produto);
//
//        entityManager.remove(produto);

        entityManager.getTransaction().commit();

    }

}
