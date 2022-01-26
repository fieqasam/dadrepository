package demo.ftmk.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import demo.ftmk.product.Product;

/**
 * Servlet implementation class OrderRedirectServlet
 */
@WebServlet("/demo/orderRedirectServlet")
public class OrderRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderRedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		// Get orderedProducts from session
		//Cast to List of OrderedProduct
		HttpSession session = request.getSession();
		List<OrderedProduct> orderedProducts = (List<OrderedProduct>)session.getAttribute("orderedProducts");
		// Forward servlet to zeroOrder.html if orderedProducts does not exist
		if(orderedProducts == null) {
			
			orderedProducts = new ArrayList<OrderedProduct>();
			
		}
		//Get data from web form
		 String selectedProduct = request.getParameter("product");
		 String specifiedQuantity = request.getParameter("quantity");
		 
		 int productId= Integer.parseInt(selectedProduct);
		 int quantity = Integer.parseInt(specifiedQuantity);
		 
		 Product product= new Product();
		 product.setProductId(productId);
		 
		 //wrap data into object of orderedProduct
		 OrderedProduct orderedProduct = new OrderedProduct();
		 orderedProduct.setOrderedProduct(product);
		 orderedProduct.setQuantity(quantity);
		 
		 //Add object of OrderedProduct into list
		 orderedProducts.add(orderedProduct);
		 
		 //Add list to session
		 session.setAttribute("orderedProducts",orderedProducts);
		 
		 //Redirect to the same page
		 response.sendRedirect("orderRedirectForm.html");
		 
		 
	}

}
