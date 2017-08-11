package controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import model.Atendente;
import model.AtendenteDAO;
import model.Cliente;
import model.ClienteDAO;
import model.Compra;
import model.CompraDAO;
import model.Item;
import model.Produto;
import model.ProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Mauricio Capua
 */
@Controller
@RequestMapping("/atendente")
public class ControllerAtendente {

    private AtendenteDAO atendenteDAO;
    private ClienteDAO clienteDAO;
    private ProdutoDAO produtoDAO;
    private CompraDAO compraDAO;

//    @Autowired
//    ControllerAtendente(AtendenteDAO atendenteDAO) {
//        this.atendenteDAO = atendenteDAO;
//    }
    @Autowired
    public ControllerAtendente(AtendenteDAO atendenteDAO, ClienteDAO clienteDAO, ProdutoDAO produtoDAO, CompraDAO compraDAO) {
        this.atendenteDAO = atendenteDAO;
        this.clienteDAO = clienteDAO;
        this.produtoDAO = produtoDAO;
        this.compraDAO = compraDAO;
    }

    @RequestMapping(value = "cadastroAtendente")
    public String redirect(String url, Model model) {
        System.out.println(url);
        return "atendentes/cadastroAtendente";
    }

    @RequestMapping("loginForm")
    public String loginForm() {
        return "formulario-login";
    }

    @RequestMapping("efetuaLogin")
    public String efetuaLogin(Atendente atendente, HttpSession session) {
        try {
            if (atendenteDAO.verificaLogin(atendente) != null) {
                atendente = atendenteDAO.verificaLogin(atendente);
                session.setAttribute("atendenteLogado", atendente);
                return "redirect:/";

            } else {
                return "formulario-login";
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("efetuarCompra")
    public String compra(Model model, Cliente cliente, @RequestParam("List") ArrayList<String> lista) {
        cliente = clienteDAO.listarCliente(cliente);
        if (lista != null) {
            Compra compra = new Compra();
            compra.setCliente(cliente);
            compra = compraDAO.inserir(compra);
            Produto produto = null;
            Item item = null;
            for (String idProduto : lista) {
                produto = new Produto();
                produto.setId(Integer.parseInt(idProduto));
                produto = produtoDAO.listarProduto(produto);
                item = new Item();
                item.setProduto(produto);
                item.setQuantidadeCompra(1);
                compraDAO.inserirItem(compra, item);
            }
        }
        try {
            model.addAttribute("Cliente", cliente);
            return historicoCompras(cliente, model);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("selecionarCliente")
    public String selecionarClientes(Model model) throws Exception {
        List<Cliente> vetCliente = clienteDAO.listarTodos();
        model.addAttribute("vetCliente", vetCliente);
        return "/compras/selecionarCliente";
    }

    @RequestMapping("selecionarProdutos")
    public String selecionarProdutos(Cliente cliente, Model model) throws Exception {
        List<Produto> vetProduto = produtoDAO.listarTodosDisponiveis();
        model.addAttribute("Cliente", cliente);
        model.addAttribute("vetProduto", vetProduto);
        return "/compras/selecionarProdutos";
    }

    @RequestMapping("historicoCompras")
    public String historicoCompras(Cliente cliente, Model model) throws Exception {
        cliente = clienteDAO.listarCliente(cliente);
        List<Compra> vetCompra = compraDAO.listarCompras(cliente);
        for (int i = 0; i < vetCompra.size(); i++) {
            vetCompra.get(i).setItens(compraDAO.listarItens(vetCompra.get(i)));
            vetCompra.get(i).setCliente(cliente);
        }
//        model.addAttribute("Cliente", cliente);
        model.addAttribute("vetCompra", vetCompra);
        return "/compras/historicoCompras";
    }

    @RequestMapping(value = "adicionar")
    public String adicionarCliente(@Valid Atendente atendente, BindingResult resultado, Model model) throws Exception {
        if (!resultado.hasErrors()) {
            atendenteDAO.inserir(atendente);
            model.addAttribute("atendenet", atendente);
            return "redirect:/";
        } else {
            model.addAttribute("atendente", atendente);
            return "/cadastroAtendente";
        }
    }

}
