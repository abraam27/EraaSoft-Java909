import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ItemService")
public class ItemService extends HttpServlet {

	@Resource(name = "jdbc/connection")
	private DataSource dataSource;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");

		try (Connection con = dataSource.getConnection()) {
			ItemUtilService itemService = new ItemUtilService(con);

			if (action == null || action.equals("all")) {
				showAllItems(itemService, out);
			} else if (action.equals("byIds")) {
				showItemsByIds(itemService, out);
			} else if (action.equals("containsI")) {
				showItemsContainingChar(itemService, out);
			} else if (action.equals("priceRange")) {
				showItemsByPriceRange(itemService, out);
			}else if (action.equals("saveItems")) {
				saveMultipleItems(itemService, out);
			} else {
				showAllItems(itemService, out);
			}

		} catch (Exception e) {
			out.println("<h3 style='color:red'>Error: " + e.getMessage() + "</h3>");
			e.printStackTrace();
		}
	}

	private void showAllItems(ItemUtilService service, PrintWriter out) throws SQLException {
		out.println("<h1>All Items from Oracle DB</h1>");
		out.println("<a href='ItemService?action=byIds'>Show Items with ID 1,2</a> | ");
		out.println("<a href='ItemService?action=containsI'>Items containing 'i'</a> | ");
		out.println("<a href='ItemService?action=priceRange'>Items (price > 50 or < 20)</a>");
		out.println("<a href='ItemService?action=saveItems'>Save Items</a>");
		out.println("<hr>");

		List<Item> items = service.getAllItems();
		printItemsTable(items, out);
	}

	private void showItemsByIds(ItemUtilService service, PrintWriter out) throws SQLException {
		out.println("<h1>Items with ID 1 or 2</h1>");
		out.println("<a href='ItemService'>Back to All Items</a><hr>");

		List<Item> items = service.getItemsByIds(1, 2);
		printItemsTable(items, out);
	}

	private void showItemsContainingChar(ItemUtilService service, PrintWriter out) throws SQLException {
		out.println("<h1>Items containing 'i' in name</h1>");
		out.println("<a href='ItemService'>Back to All Items</a><hr>");

		List<Item> items = service.getItemsByNameContaining("i");
		printItemsTable(items, out);
	}

	private void showItemsByPriceRange(ItemUtilService service, PrintWriter out) throws SQLException {
		out.println("<h1>Items with price > 50 or price < 20</h1>");
		out.println("<a href='ItemService'>Back to All Items</a><hr>");

		List<Item> items = service.getItemsByPriceRange();
		printItemsTable(items, out);
	}

	private void saveMultipleItems(ItemUtilService service, PrintWriter out) throws SQLException {
		// Example: saving multiple items
		List<Item> newItems = new ArrayList<>();
		newItems.add(new Item(0, "Laptop", 800.0));
		newItems.add(new Item(0, "Mouse", 15.0));
		newItems.add(new Item(0, "Keyboard", 45.0));

		service.saveItems(newItems);

		out.println("<h1>Items Saved Successfully!</h1>");
		out.println("<p>Saved " + newItems.size() + " items to database.</p>");
		out.println("<a href='ItemService'>View All Items</a>");
	}

	private void printItemsTable(List<Item> items, PrintWriter out) {
		out.println("<table border='1' cellpadding='10'>");
		out.println("<tr><th>ID</th><th>Name</th><th>Price</th></tr>");

		if (items.isEmpty()) {
			out.println("<tr><td colspan='3'>No items found</td></tr>");
		} else {
			for (Item item : items) {
				out.println("<tr>");
				out.println("<td>" + item.getId() + "</td>");
				out.println("<td>" + item.getName() + "</td>");
				out.println("<td>" + item.getPrice() + "</td>");
				out.println("</tr>");
			}
		}

		out.println("</table>");
		out.println("<p>Total items: " + items.size() + "</p>");
	}
}