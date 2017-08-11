package controllers;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import model.Cliente;
import model.ClienteDAO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import persistencia.ConnectionFactory;

@Controller
@RequestMapping("/cliente")
public class ControllerCliente {

    @RequestMapping(value = "login")
    public String login(Cliente cliente, HttpSession session) throws Exception {
        Connection con = new ConnectionFactory().getConnection();

        ClienteDAO clienteDAO = new ClienteDAO(con);
        Cliente clientelogado = null;
        try {
            clientelogado = clienteDAO.verificaLogin(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (clientelogado != null) {
            session.setAttribute("clienteLogado", clientelogado);
            return "forward:listar";
        }
        return "login";
    }

    @RequestMapping("/")
    private String index() {
//        return "forward:login";
        return "listar";
    }
    
    
    @RequestMapping(value = "listar")
    public String carregarPagina(Model model) throws Exception {
        Connection con = new ConnectionFactory().getConnection();
        List<Cliente> vetCliente = new ClienteDAO(con).listarTodos();
        model.addAttribute("vetCliente", vetCliente);
        return "paginainicial";
    }

    @RequestMapping(value = "tabela")
    public String tabela(Model model) throws Exception {

        Connection con = new ConnectionFactory().getConnection();

        List<Cliente> vetCliente = new ClienteDAO(con).listarTodos();

        model.addAttribute("vetCliente", vetCliente);

        return "listagem";
    }

    @RequestMapping(value = "adicionar")
    public String adicionarCliente(@Valid Cliente cliente, BindingResult resultado, Model model) throws Exception {
        Connection con = new ConnectionFactory().getConnection();
        System.out.println(resultado.getFieldError("nome"));
        if (!resultado.hasErrors()) {
            ClienteDAO clienteDAO = new ClienteDAO(con);
            clienteDAO.inserir(cliente);
            model.addAttribute("cliente", cliente);
            return "forward:tabela";
//            return "paginainicial";
        } else {
            System.out.println("errou");
            model.addAttribute("cliente", cliente);

            return "paginainicial";
        }
    }

    @RequestMapping("/deletar")
    public String deletarCliente(int idCliente) throws Exception {
        Connection con = new ConnectionFactory().getConnection();
        ClienteDAO clienteDAO = new ClienteDAO(con);
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        clienteDAO.deletarCliente(cliente);
        return "forward:tabela";
    }

    @RequestMapping("/alterar")
    public String alterarCliente(int idCliente, Model m) throws Exception {
        m.addAttribute("idCliente", idCliente);
        return "alterar";
    }

    @RequestMapping("/update")
    public String atualizar(int idCliente, String novonome, Model m) throws Exception {
        Connection con = new ConnectionFactory().getConnection();
        ClienteDAO clienteDAO = new ClienteDAO(con);
        Cliente cliente = new Cliente(idCliente, novonome);
        clienteDAO.alterarCliente(cliente);
        return "forward:tabela";
    }

}
