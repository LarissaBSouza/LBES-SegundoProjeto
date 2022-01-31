package br.proj.rd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProjetoFinal
 */
@WebServlet("/ProjetoFinal")
public class ProjetoFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Container c = new Container();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjetoFinal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String alterar = request.getParameter("alterar");
		String id = request.getParameter("id");
		String remover = request.getParameter("remover");
		
		if (id != null) {
			if (remover.equals("0")) {
				c.deletar(Integer.parseInt(id));
			} else if (alterar.equals("1")) {
				User u = c.consultaUsuarios(Integer.parseInt(id));
				request.setAttribute("id", u.getId());
				request.setAttribute("nome", u.getNome());
				request.setAttribute("email", u.getEmail());
				request.setAttribute("pais", u.getPais());
				
				request.getRequestDispatcher("/formulario.jsp").forward(request, response);
			}
			
		}
		
		request.setAttribute("user", c.consultaUsuarios());
		
		request.getRequestDispatcher("/").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		if ((request.getParameter("nome") != null) && (request.getParameter("email") != null) && (request.getParameter("pais") != null) ){
			
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String pais = request.getParameter("pais");
			String id = request.getParameter("id");
			
			
			if (id != null && !id.isEmpty()) {
				c.alterarUsuario(Integer.parseInt(id), email, nome, pais);
				
			} else {
				User u = new User(email, nome, pais);
				c.inserir(u);
				
			}
			
			request.setAttribute("user", c.consultaUsuarios());
			
		}
		request.getRequestDispatcher("/").forward(request, response); //Rediciona para ele mesmo)
	}

}
