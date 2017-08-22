package zad5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Pages
 */
@WebServlet("/pages")
public class Pages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pages() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    private final String PAGE_ADDRESS = "/WEB-INF/jsp/zad5_page";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//init
		HttpSession sess = request.getSession();
		
		List<String> pages = (List<String>) sess.getAttribute("pages");
		if (pages == null) {
			pages = new ArrayList<>();
		}
		
		String currPage = request.getParameter("page");
		
		if (pageOutOfBounds(currPage)) {
			currPage = "1";
		}
		sess.setAttribute("currPage", currPage);
		
		pages.add("Strona " + currPage);
		sess.setAttribute("pages", pages);
		getServletContext().getRequestDispatcher(PAGE_ADDRESS + currPage + ".jsp").forward(request, response);
	}

	private boolean pageOutOfBounds(String currPage) {
		try {
			int indexPage = Integer.parseInt(currPage);
			if (indexPage < 1 || indexPage > 4) {
				return true;
			}
		} catch (Exception e) {
			return true;
		}
		
		return false;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
