package in.co.rays.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductListCtl")
public class ProductListCtl extends HttpServlet {


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	ProductDTO dto = new ProductDTO();
	ProductModel model = new ProductModel();
	List list = model.search(dto);
	req.setAttribute("list", list);
	
	RequestDispatcher rd = req.getRequestDispatcher("ProductListView.jsp");
	      rd.forward(req, resp);
}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		String[] ids = req.getParameterValues("ids");
		ProductDTO dto = new ProductDTO();
		ProductModel model = new ProductModel();
		if (op.equalsIgnoreCase("delete")) {
			if(ids!=null) {
				for(String id:ids) {
					ProductDTO deletedto = new ProductDTO();
					deletedto.setId(Integer.parseInt(id));
					model.delete(deletedto);
					req.setAttribute("msg","Record delete sucessfully");
//					RequestDispatcher rd = req.getRequestDispatcher("OrderListView.jsp");
//					rd.forward(req, resp);
				}
			}else {
				req.setAttribute("msg","Select Atleast one record");
			}
		}
		if(op.equalsIgnoreCase("new")){
			resp.sendRedirect("ProductCtl");
			return;
		}
		if(op.equals("search")){
	
			dto.setName(req.getParameter("name"));
		}
		if(op.equals("Search")){
			
			dto.setId(Integer.parseInt(req.getParameter("id")));
		}
		List list=model.search(dto);
		req.setAttribute("list",list);
		RequestDispatcher rd = req.getRequestDispatcher("ProductListView.jsp");
		rd.forward(req, resp);
	}
	



}
