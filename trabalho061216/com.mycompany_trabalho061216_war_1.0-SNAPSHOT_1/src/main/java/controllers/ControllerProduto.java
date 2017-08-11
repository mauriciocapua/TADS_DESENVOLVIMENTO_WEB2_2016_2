package controllers;

import java.util.List;
import javax.validation.Valid;
import model.Produto;
import model.ProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Mauricio Capua
 */
@Controller
@RequestMapping("/produto")
public class ControllerProduto {

    private ProdutoDAO produtoDAO;

    @Autowired
    ControllerProduto(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    @RequestMapping("/")
    private String index() {
        return "forward:listarProdutos";
//        return "listar";
    }

    @RequestMapping(value = "redirect")
    public String redirect(String url, Model model) {
        return "/produtos/" + url;
    }

    @RequestMapping(value = "listarProdutos")
    public String listarProdutos(Model model) throws Exception {
        List<Produto> vetProduto = produtoDAO.listarTodos();
        model.addAttribute("vetProduto", vetProduto);
        return "/produtos/listar";
    }

    @RequestMapping(value = "adicionar")
    public String adicionarProduto(@Valid Produto produto, BindingResult resultado, Model model) throws Exception {
//        , @RequestParam("file") MultipartFile file)

        if (!resultado.hasErrors()) {
            produtoDAO.inserir(produto);
//            ControllerUpload controllerUpload = new ControllerUpload();
//            controllerUpload.uploadFileHandler(file);
            model.addAttribute("produto", produto);
            return "redirect:listarProdutos";
        } else {
            model.addAttribute("produto", produto);
            return "/produtos/inserir";
        }
    }

    @RequestMapping("/deletar")
    public String deletarProduto(Produto produto) throws Exception {
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
        if (!resultado.hasErrors()) {
            produtoDAO.alterarProduto(produto);
            return "redirect:listarProdutos";
        } else {
            model.addAttribute("produto", produto);
            return "/produtos/alterar";
        }
    }
}
