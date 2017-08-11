package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.*;

import java.util.List;

/**
 * Servlet implementation class ListarDependentes
 */
@WebServlet("/ListarDependentes")
public class ListarDependentes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarDependentes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCliente = -1;
		if (request.getParameter("idCliente") != null){
			idCliente = Integer.parseInt(request.getParameter("idCliente"));
		}
		
		String nomeDependente = request.getParameter("nomedependente");		
		
		if(!nomeDependente.isEmpty()){
			try {
				Cliente.adicionarDependente(nomeDependente, idCliente);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
        List<Cliente> vetCliente = null;
        List<Dependente> vetDependente = null;
		try {
			vetCliente = Cliente.listarTodos();
	        vetDependente = Cliente.listarTodosDependentes();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("vetCliente", vetCliente);
		request.setAttribute("vetDependente", vetDependente);
		RequestDispatcher rd = request.getRequestDispatcher("/paginadependentes.jsp");
		rd.forward(request, response);
	
    }
}
