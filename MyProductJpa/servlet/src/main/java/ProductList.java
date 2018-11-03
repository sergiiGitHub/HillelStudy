import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sergii on 27.10.18.
 */
@WebServlet(urlPatterns = { "/productList" })
public class ProductList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String errorString = null;
        List<ProductJpa> list = new ProductService().getAll();
        if (list == null) {
            errorString = "getAll() return null";
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("productList", list);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/productListView.jsp");
        dispatcher.forward(request, response);
    }
}
