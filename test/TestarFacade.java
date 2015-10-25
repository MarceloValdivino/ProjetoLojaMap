/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.entidades.Produto;
import br.com.map.marcelo.enums.ComposicaoProduto;
import br.com.map.marcelo.enums.TipoProduto;
import br.com.map.marcelo.facade.Facade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcelo
 */
public class TestarFacade {
    
    public static void main(String[] args) {
        try {
            Facade facade = Facade.getInstance();
            List<Produto> produtos = facade.listarProdutos();
            Produto produto = new Produto();
            produto.setComposicao(ComposicaoProduto.AGUA);
            produto.setDescricao("Feijão Preto Chicó");
            produto.setTipoProduto(TipoProduto.ALIMENTICIO);
            facade.salvarOuAtualizarProduto(produto);
            
            for(Produto p : produtos){
                System.out.println("Produto: "+p);
            }
        } catch (BusinessException ex) {
            Logger.getLogger(TestarFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
