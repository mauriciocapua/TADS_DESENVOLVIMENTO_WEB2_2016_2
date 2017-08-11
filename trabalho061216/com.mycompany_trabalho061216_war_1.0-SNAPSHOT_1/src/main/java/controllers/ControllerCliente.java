package controllers;

import java.sql.Connection;
import java.util.List;
import javax.validation.Valid;
import model.Cliente;
import model.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ControllerCliente {

    private ClienteDAO clienteDAO;

    @Autowired
    ControllerCliente(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @RequestMapping("/")
    private String index() {
//        return "forward:login";
        return "listar";
    }

    @RequestMapping(value = "redirect")
    public String redirect(String url, Model model) {
        System.out.println(url);
        return "/clientes/" + url;
    }

    @RequestMapping(value = "listarClientes")
    public String carregarPagina(Model model) throws Exception {
        List<Cliente> vetCliente = clienteDAO.listarTodos();
        model.addAttribute("vetCliente", vetCliente);
        return "/clientes/listar";
    }

//    
    @RequestMapping(value = "adicionar")
    public String adicionarCliente(@Valid Cliente cliente, BindingResult resultado, Model model) throws Exception {
        if (!resultado.hasErrors()) {
            clienteDAO.inserir(cliente);
            model.addAttribute("cliente", cliente);
            return "redirect:listarClientes";
        } else {
            model.addAttribute("cliente", cliente);
            return "/clientes/inserir";
        }
    }

    @RequestMapping("/deletar")
    public String deletarCliente(Cliente cliente) throws Exception {
        clienteDAO.deletarCliente(cliente);
        return "redirect:listarClientes";
    }

    @RequestMapping("/alterar")
    public String alterarProduto(Cliente cliente, Model m) throws Exception {
        m.addAttribute("cliente", cliente);
        return "/clientes/alterar";
    }

    @RequestMapping("/update")
    public String atualizar(@Valid Cliente cliente, BindingResult resultado, Model model) throws Exception {
        if (!resultado.hasErrors()) {
            clienteDAO.alterarCliente(cliente);
            return "redirect:listarClientes";
        } else {
            model.addAttribute("cliente", cliente);
            return "/clientes/alterar";
        }

    }

//    @RequestMapping(value = "tabela")
//    public String tabela(Model model) throws Exception {
//
//        Connection con = new ConnectionFactory().getConnection();
//
//        List<Cliente> vetCliente = new ClienteDAO(con).listarTodos();
//
//        model.addAttribute("vetCliente", vetCliente);
//
//        return "listagem";
//    }
//@RequestMapping(value = "login")
//    public String login(Cliente cliente, HttpSession session) throws Exception {
//        Connection con = new ConnectionFactory().getConnection();
//
//        ClienteDAO clienteDAO = new ClienteDAO(con);
//        Cliente clientelogado = null;
//        try {
//            clientelogado = clienteDAO.verificaLogin(cliente);
//        } catch (Exception ex) {
//            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if (clientelogado != null) {
//            session.setAttribute("clienteLogado", clientelogado);
//            return "forward:listar";
//        }
//        return "login";
//    }
}
