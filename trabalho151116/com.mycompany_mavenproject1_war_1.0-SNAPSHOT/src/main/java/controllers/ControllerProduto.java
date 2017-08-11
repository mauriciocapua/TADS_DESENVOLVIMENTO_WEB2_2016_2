/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.validation.Valid;
import model.Produto;
import model.ProdutoDAO;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
        return "/produtos/listar";
    }

    @RequestMapping(value = "adicionar")
    public String adicionarProduto(@Valid Produto produto, BindingResult resultado, Model model, @RequestParam("file") MultipartFile file) throws Exception {
        Connection con = new ConnectionFactory().getConnection();
        if (!resultado.hasErrors()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(con);
            produtoDAO.inserir(produto);
            ControllerUpload controllerUpload = new ControllerUpload();
            controllerUpload.uploadFileHandler(file);
            model.addAttribute("produto", produto);
            return "redirect:listarProdutos";
        } else {
            model.addAttribute("produto", produto);
            return "/produtos/inserir";
        }
    }

    @RequestMapping("/deletar")
    public String deletarProduto(Produto produto) throws Exception {
        Connection con = new ConnectionFactory().getConnection();
        ProdutoDAO produtoDAO = new ProdutoDAO(con);
//        Produto produto = new Produto();
//        produto.setId(idProduto);
        produtoDAO.deletarProduto(produto);
        return "redirect:listarProdutos";
    }

    @RequestMapping("/alterar")
    public String alterarProduto(Produto produto, Model m) throws Exception {
        m.addAttribute("Produto", produto);
        return "/produtos/alterar";
    }

    @RequestMapping("/update")
    public String atualizar(@Valid Produto produto, BindingResult resultado, Model model) throws Exception {
        Connection con = new ConnectionFactory().getConnection();
        if (!resultado.hasErrors()) {
            ProdutoDAO produtoDAO = new ProdutoDAO(con);
            produtoDAO.alterarProduto(produto);
            return "redirect:listarProdutos";

        } else {
            model.addAttribute("produto", produto);
            return "/produtos/alterar";
        }

    }
}
