/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.marcelo.principal;

import br.com.map.marcelo.commom.exception.BusinessException;
import br.com.map.marcelo.entidades.Cliente;
import br.com.map.marcelo.entidades.Contato;
import br.com.map.marcelo.entidades.Fornecedor;
import br.com.map.marcelo.entidades.Funcionario;
import br.com.map.marcelo.entidades.ItemProduto;
import br.com.map.marcelo.entidades.ItemVenda;
import br.com.map.marcelo.entidades.Produto;
import br.com.map.marcelo.entidades.Venda;
import br.com.map.marcelo.enums.ComposicaoProduto;
import br.com.map.marcelo.enums.EstadoCivil;
import br.com.map.marcelo.enums.Operadora;
import br.com.map.marcelo.enums.Sexo;
import br.com.map.marcelo.enums.TipoItemVenda;
import br.com.map.marcelo.enums.TipoPagamento;
import br.com.map.marcelo.enums.TipoProduto;
import br.com.map.marcelo.facade.Facade;
import br.com.map.marcelo.utils.DateUtil;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class Principal {

    public static void main(String[] args) throws BusinessException {
        
        Facade facade = Facade.getInstance();
        
        // TA FUNCIONANDO TUDO
        
        // 13. Retornar o total de descontos no mês. 
        /*
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 7);
        System.out.println("Data antes: "+DateUtil.getDate(calendar.getTime()));
        double valor = facade.totalDescontosMesVendas(calendar);
        System.out.println("Valor: "+valor);
        
        calendar.set(Calendar.MONTH, 8);
        valor = facade.totalDescontosMesVendas(calendar);
        System.out.println("Valor: "+valor);
        
        calendar.set(Calendar.MONTH, 9);
        valor = facade.totalDescontosMesVendas(calendar);
        System.out.println("Valor: "+valor);
        
        
        // 12. Retornar o "apurado" do mês, (Month = 0 quer dizer Janeiro)
        
        calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 7);
        System.out.println("Data antes: "+DateUtil.getDate(calendar.getTime()));
        valor = facade.apuradoVendasDoMes(calendar);
        System.out.println("Valor: "+valor);
        
        calendar.set(Calendar.MONTH, 8);
        valor = facade.apuradoVendasDoMes(calendar);
        System.out.println("Valor: "+valor);
        
        calendar.set(Calendar.MONTH, 9);
        valor = facade.apuradoVendasDoMes(calendar);
        System.out.println("Valor: "+valor);
        */
        
        // 11. Retornar todas as vendas que um funcionário ativo/desativo já realizaram;
        // Checado, tudo ok!
        /*
        List<Venda> vendas = facade.listarVendasPorFuncionarioPeloStatus(true);
        for(Venda v : vendas){
            System.out.println("Venda:" + v.getFuncionario().getNome());
        }
        */
        
        // 10. Retornar todas as vendas que tiveram, pelo menos, um dos seus itensVenda com desconto;
        // Checado, tudo ok!
        /*
        List<Venda> vendas = facade.listarVendasPorDesconto(true);
        for(Venda v : vendas){
            System.out.println("Venda:" + v.getCliente().getNome());
        }
        */
        
        // 9. Receber como parâmetro um ItemProduto e retornar todos os Clientes que já comprarão desse item;
        // Checado, tudo ok!
        /*
        ItemProduto itemProduto = facade.listarItemProdutos().get(0);
        List<Cliente> clientes = facade.listarCompraClientePorItemProduto(itemProduto);
        for(Cliente c : clientes){
            System.out.println("Cliente: "+c.getNome());
        }
        */
        
        // 8. Receber como parâmetro um ItemProduto e retornar todas as vendas em que esse itemProduto exista;
        // Checado, tudo ok!
        /*
        ItemProduto itemProduto = facade.listarItemProdutos().get(0);
        List<Venda> lista = facade.listarVendasPorItemProduto(itemProduto);
        for(Venda i : lista){
            System.out.println("Venda: "+DateUtil.getDate(i.getDataVenda().getTime()));
        }
        */
        // 7. Buscar todos os ItemVenda pelo tipo da venda, se foi atacado ou varejo;
        // Checado, tudo ok!
        /*
        List<ItemVenda> lista = facade.listarItemVendaPorTipoItemVenda(TipoItemVenda.VAREJO);
        for(ItemVenda v : lista){
            System.out.println("ItemVenda: "+v.getItemProduto().getProduto().getDescricao());
        }
        */
        
        // 6. Buscar todas as vendas, passando por parâmetro o tipo de pagamento;
        // Checado, tudo ok!
        /*
        List<Venda> lista = facade.listarVendasPorTipoPagamento(TipoPagamento.DINHEIRO);
        for(Venda v : lista){
            System.out.println("Venda: "+DateUtil.getDate(v.getDataVenda().getTime()));
        }
        */
        
        // 5. Retornar todas as Vendas em um determinado dia;
        // Checado, tudo ok!
        /*
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        
        List<Venda> lista = facade.listarVendasPorData(calendar);
        for(Venda v : lista){
            System.out.println("Venda: "+DateUtil.getDate(v.getDataVenda().getTime()));
        }
        */
        
        // 4. Retornar um valor total de todas as compras que um cliente realizou;
        // checado, tudo ok!
        /*
        Cliente cliente = facade.listarClientes().get(0);
        System.out.println("Valor total: "+facade.totalValorComprasCliente(cliente));
        */
        
        // 3. Retornar todos os ItemProdutos que um determinado Funcinário Vendeu;
        // checado, tudo ok!
        /*
        Funcionario funcionario = facade.listarFuncionarios().get(0);
        List<ItemProduto> lista = facade.listarItemProdutosVendidosPorFuncionario(funcionario);
        for(ItemProduto ip : lista){
            System.out.println("Item produto: "+ip.getProduto().getDescricao());
        }
        */
        
        // 2. Retornar todos os ItemProduto que um determinado Cliente Comprou;
        // chacado, tudo ok!
        /*
        Cliente cliente = facade.listarClientes().get(0);
        List<ItemProduto> lista = facade.listarItemProdutosCompradosPorCliente(cliente);
        for(ItemProduto ip : lista){
            System.out.println("Item produto: "+ip.getProduto().getDescricao());
        }
        */
        
        // 1. Método que receba um período de duas datas, inicial e final, e retorne todas as vendas realizadas entre esse perído;
        //Checado, tudo OK!
        /*
        Calendar dataInicial = Calendar.getInstance();
        dataInicial.set(Calendar.DAY_OF_MONTH, 1);
        Calendar dataFinal = Calendar.getInstance();
        dataFinal.set(Calendar.DAY_OF_MONTH, 10);
        List<Venda> vendas = facade.listarVendasEntreDatas(dataInicial, dataFinal);
        for(Venda v : vendas){
            System.out.println("Data: "+DateUtil.getDate(v.getDataVenda().getTime()));
        }
        *,/
        
        /*
        ItemProduto itemProduto = facade.listarItemProdutos().get(0);
        
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setDesconto(true);
        itemVenda.setDescontoPorcentagemItem(10);
        itemVenda.setItemProduto(itemProduto);
        itemVenda.setPrecoItem(itemProduto.getPrecoCompraUnidade()*1.1);
        itemVenda.setQuantidade(5);
        itemVenda.setTipoItemVenda(TipoItemVenda.VAREJO);
        
        Venda venda = new Venda();
        venda.getItens().add(itemVenda);
        itemProduto = facade.listarItemProdutos().get(2);
        
        itemVenda = new ItemVenda();
        itemVenda.setDesconto(false);
        itemVenda.setDescontoPorcentagemItem(20);
        itemVenda.setItemProduto(itemProduto);
        itemVenda.setPrecoItem(itemProduto.getPrecoCompraUnidade()*1.1);
        itemVenda.setQuantidade(2);
        itemVenda.setTipoItemVenda(TipoItemVenda.ATACADO);
        
        venda.getItens().add(itemVenda);
        venda.setCliente(facade.listarClientes().get(0));
        Calendar dataVenda = Calendar.getInstance();
        dataVenda.set(2015, 8, 1);
        venda.setDataVenda(dataVenda);
        venda.setFuncionario(facade.listarFuncionarios().get(1));
        double valor = 0;
        for(ItemVenda iv : venda.getItens()){
            valor+= iv.getPrecoItem();
        }
        venda.setPrecoTotal(valor);
        venda.setTipoPagamento(TipoPagamento.DINHEIRO);
        
        facade.salvarOuAtualizarVenda(venda);
        */
        
        /*
        Fornecedor fornecedor = facade.listarFornecedores().get(0);
        Produto produto = facade.listarProdutos().get(2);
        
        ItemProduto itemProduto = new ItemProduto();
        itemProduto.setDataEntrada(Calendar.getInstance());
        itemProduto.setFornecedor(fornecedor);
        itemProduto.setPorcentagemVendaUnidadeAtacado(8);
        itemProduto.setPorcentagemVendaUnidadeVarejo(0);
        itemProduto.setPrecoCompraUnidade(7.40);
        itemProduto.setProduto(produto);
        itemProduto.setQuantidade(50);
        
        facade.salvarOuAtualizarItemProduto(itemProduto);
        */
        
        /*
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCnpj("4444");
        fornecedor.getEndereco().setBairro("Centro");
        fornecedor.getEndereco().setCep("123333-000");
        fornecedor.getEndereco().setCidade("Patos");
        fornecedor.getEndereco().setEstado("PB");
        fornecedor.getEndereco().setNumero("24");
        fornecedor.getEndereco().setRua("Chablaum");
        
        facade.salvarOuAtualizarFornecedor(fornecedor);
        */
        
        /*
        Produto produto = new Produto();
        produto.setComposicao(ComposicaoProduto.AGUA);
        produto.setDescricao("Água Mineral");
        produto.setTipoProduto(TipoProduto.ALIMENTICIO);
        
        facade.salvarOuAtualizarProduto(produto);
        
        produto = new Produto();
        produto.setComposicao(ComposicaoProduto.MADEIRA);
        produto.setDescricao("Pau pra da em doido");
        produto.setTipoProduto(TipoProduto.CASA);
        
        facade.salvarOuAtualizarProduto(produto);
        
        produto = new Produto();
        produto.setComposicao(ComposicaoProduto.METAL);
        produto.setDescricao("Torneira inox");
        produto.setTipoProduto(TipoProduto.CASA);
        
        facade.salvarOuAtualizarProduto(produto);
        */
        
        /*
        Funcionario funcionario = new Funcionario();
        Contato contato  = new Contato();
        contato.setNumero("111");
        contato.setObservacao("adnealdbla");
        contato.setOperadora(Operadora.OI);
        funcionario.getContatos().add(contato);
        funcionario.setCpf("111");
        funcionario.setDataCadastro(Calendar.getInstance());
        funcionario.setDataNascimento(Calendar.getInstance());
        funcionario.setDesconto(false);
        funcionario.getEndereco().setBairro("aedneaild");
        funcionario.getEndereco().setCep("deadad");
        funcionario.getEndereco().setCidade("deadeadea");
        funcionario.getEndereco().setEstado("deadeadae");
        funcionario.getEndereco().setNumero("123");
        funcionario.getEndereco().setRua("aendaida");
        funcionario.setEstadoCivil(EstadoCivil.SOLTEIRO);
        funcionario.setInscricao("2013.1.007.044");
        funcionario.setNome("Matheus Azevedo");
        funcionario.getRg().setDataExpedicao(Calendar.getInstance());
        funcionario.getRg().setNumero("123");
        funcionario.getRg().setOrgaoExpedidor("adeead");
        funcionario.setValorDesconto(10);
        funcionario.setSexo(Sexo.MASCULINO);
        funcionario.setStatus(true);
        
        facade.salvarOuAtualizarFuncionario(funcionario);
        */
        /*
        // 1. Método que receba um período de duas datas, inicial e final, e retorne todas as vendas realizadas entre esse perído;
        facade.listarVendasEntreDatas(null, null);
        // 2. Retornar todos os ItemProduto que um determinado Cliente Comprou;
        facade.listarItemProdutosCompradosPorCliente(null);
        // 3. Retornar todos os ItemProdutos que um determinado Funcinário Vendeu;
        facade.listarItemProdutosVendidosPorFuncionario(null);
        // 4. Retornar um valor total de todas as compras que um cliente realizou;
        facade.totalValorComprasCliente(null);
        // 5. Retornar todas as Vendas em um determinado dia;
        facade.listarVendasPorData(null);
        // 6. Buscar todas as vendas, passando por parâmetro o tipo de pagamento;
        facade.listarVendasPorTipoPagamento(null);
        // 7. Buscar todos os ItemVenda pelo tipo da venda, se foi atacado ou varejo;
        facade.listarVendasPorTipoItemVenda(null);
        // 8. Receber como parâmetro um ItemProduto e retornar todas as vendas em que esse itemProduto exista;
        facade.listarVendasPorItemProduto(null);
        // 9. Receber como parâmetro um ItemProduto e retornar todos os Clientes que já comprarão desse item;
        facade.listarCompraClientePorItemProduto(null);
        // 10. Retornar todas as vendas que tiveram, pelo menos, um dos seus itensVenda com desconto;
        facade.listarVendasPorTipoItemVenda(null);
        // 11. Retornar todas as vendas que um funcionário ativo/desativo já realizaram;
        facade.listarVendasPorFuncionarioPeloStatus(null);
        // 12. Retornar o "apurado" do mês,
        facade.apuradoVendasDoMes(null);
        // 13. Retornar o total de descontos no mês. 
        facade.totalDescontosMesVendas(null);
        */
        
        
        /*
        Cliente cliente = new Cliente();
        Contato contato  = new Contato();
        contato.setNumero("111");
        contato.setObservacao("adnealdbla");
        contato.setOperadora(Operadora.OI);
        cliente.getContatos().add(contato);
        cliente.setCpf("111");
        cliente.setDataCadastro(Calendar.getInstance());
        cliente.setDataNascimento(Calendar.getInstance());
        cliente.getEndereco().setBairro("aedneaild");
        cliente.getEndereco().setCep("deadad");
        cliente.getEndereco().setCidade("deadeadea");
        cliente.getEndereco().setEstado("deadeadae");
        cliente.getEndereco().setNumero("123");
        cliente.getEndereco().setRua("aendaida");
        cliente.setEstadoCivil(EstadoCivil.SOLTEIRO);
        cliente.setNome("Marcelo Santos");
        cliente.getRg().setDataExpedicao(Calendar.getInstance());
        cliente.getRg().setNumero("123");
        cliente.getRg().setOrgaoExpedidor("adeead");
        cliente.setSexo(Sexo.MASCULINO);
        cliente.setStatus(true);
        
        facade.salvarOuAtualizarCliente(cliente);
        */
        
        
        /*
        Produto produto1 = new Produto();
        produto1.setComposicao(ComposicaoProduto.AGUA);
        produto1.setDescricao("Água Mineral");
        produto1.setTipoProduto(TipoProduto.ALIMENTICIO);
        
        
        Produto produto2 = new Produto();
        produto2.setComposicao(ComposicaoProduto.METAL);
        produto2.setDescricao("Torneiro Inox");
        produto2.setTipoProduto(TipoProduto.CASA);
        
        
        facade.salvarOuAtualizarProduto(produto1);
        facade.salvarOuAtualizarProduto(produto2);
        */
        
        
        System.exit(0);
    }
}
