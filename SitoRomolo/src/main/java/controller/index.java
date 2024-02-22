package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Film;
import model.FilmDAO;

/**
 * Servlet implementation class index
 */
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
        super();

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		org.hibernate.SessionFactory filLista =  FilmDAO.getFactory();

		filLista.openSession();
		FilmDAO fd=new FilmDAO(filLista);
		List <Film>  listaFilm= fd.findAll();
		request.setAttribute("listFilm", listaFilm);
		RequestDispatcher dispatcher=request.getRequestDispatcher("listaFilm.jsp");
		dispatcher.forward(request, response);
	}

}
