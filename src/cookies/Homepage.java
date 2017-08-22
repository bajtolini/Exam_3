package cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Homepage
 */
@WebServlet("/homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Homepage() {
        super();
        // TODO Auto-generated constructor stub
    }
    private boolean init;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		//warunek do testow - bo sesja nie chciala sie przeladowac
		if (!init) {
			sess.setAttribute("cookiesAccepted", false);
			init = true;
		}
		try {
			String accepted = request.getParameter("accepted");
			if (accepted != null) {
				boolean cookiesAccepted = Boolean.parseBoolean(accepted);
				sess.setAttribute("cookiesAccepted", cookiesAccepted);
			}
		} catch (Exception e) {}
		
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/accept_cookies.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
