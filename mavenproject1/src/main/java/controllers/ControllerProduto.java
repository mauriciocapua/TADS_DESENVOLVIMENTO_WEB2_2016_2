/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.Connection;
import java.util.List;
import javax.validation.Valid;
import model.Cliente;
import model.ClienteDAO;
import model.Produto;
import model.ProdutoDAO;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import persistencia.ConnectionFactory;

/**
 *
 * @author Mauricio Capua
 */
@Controller
@RequestMapping("/produto")
public class ControllerProduto {

    @RequestMapping("/")
    private String index() {
        return "forward:listarProdutos";
//        return "listar";
    }

    @RequestMapping(value = "redirect")
    public String redirect(String url, Model model) {
        System.out.println(url);
        return "/produtos/" + url;
    }

    @RequestMapping(value = "listarProdutos")
    public String listarProdutos(Model model) throws Exception {
        Connection con = new ConnectionFactory().getConnection();
        List<Produto> vetProduto = new ProdutoDAO(con).listarTodos();
        model.addAttribute("vetProduto", vetProduto);
        return "/produtos/listarProdutos";
    }

    @RequestMapping(value = "adicionar")
    public String adicionarCliente(@Valid Produto produto, BindingResult resultado, Model model) throws Exception {
        Connection con = new ConnectionFactory().getConnection();
        if (!resultado.hasErrors()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(con);
            produtoDAO.inserir(produto);
            model.addAttribute("produto", produto);
            return "redirect:listarProdutos";
//            return "paginainicial";
        } else {
            System.out.println("errou");
            model.addAttribute("produto", produto);

            return "/produtos/inserirProduto";
        }
    }

    @RequestMapping("/deletar")
    public String deletarProduto(int idProduto) throws Exception {
        Connection con = new ConnectionFactory().getConnection();
        ProdutoDAO produtoDAO = new ProdutoDAO(con);
        Produto produto = new Produto();
        produto.setId(idProduto);
        produtoDAO.deletarProduto(produto);
        return "redirect:listarProdutos";
    }
}
