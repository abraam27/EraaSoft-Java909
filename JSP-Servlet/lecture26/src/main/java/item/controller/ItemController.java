package item.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.sql.DataSource;

import item.model.Item;
import item.service.ItemService;
import item.service.impl.ItemServiceImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ItemController")
public class ItemController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Action constants
    private static final String ACTION_SHOW_ITEMS = "show-items";
    private static final String ACTION_SHOW_ITEM  = "show-item";
    private static final String ACTION_ADD_ITEM   = "add-item";
    private static final String ACTION_UPDATE_ITEM = "update-item";
    private static final String ACTION_DELETE_ITEM = "delete-item";

    @Resource(name = "jdbc/connection")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (Objects.isNull(action)) {
            action = ACTION_SHOW_ITEMS;
        }

        switch (action) {
            case ACTION_ADD_ITEM:    // Show add form
                request.getRequestDispatcher("/item/add-item.jsp").forward(request, response);
                break;
            case ACTION_SHOW_ITEM:   // Show update form
                showItem(request, response);
                break;
            case ACTION_SHOW_ITEMS:  // List all items
                showItems(request, response);
                break;
            case ACTION_UPDATE_ITEM:
                updateItem(request, response);
                break;
            case ACTION_DELETE_ITEM:
                deleteItem(request, response);
                break;
            default:                 // Default to listing items
                showItems(request, response);
        }
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

    private void showItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ItemService service = new ItemServiceImpl(dataSource);
            List<Item> items = service.getItems();
            request.setAttribute("allItems", items);
            request.getRequestDispatcher("/item/show-items.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching items.");
        }
    }

    private void showItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            ItemService service = new ItemServiceImpl(dataSource);
            Item item = service.getItem(id);
            if (item == null) {
                response.sendRedirect("ItemController?action=show-items");
                return;
            }
            request.setAttribute("item", item);
            request.getRequestDispatcher("/item/update-item.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("ItemController?action=show-items");
        }
    }

    private void addItem(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String name = request.getParameter("name").trim();
            double price = Double.parseDouble(request.getParameter("price"));
            int totalNumber = Integer.parseInt(request.getParameter("totalNumber"));

            ItemService service = new ItemServiceImpl(dataSource);

            // Check if name exists
            Item existing = service.getItemByName(name);
            if (existing != null) {
                request.setAttribute("error", "Item with name '" + name + "' already exists!");
                request.getRequestDispatcher("/item/add-item.jsp").forward(request, response);
                return;
            }

            Item item = new Item(name, price, totalNumber);
            service.createItem(item);

            // Redirect to avoid form resubmission
            response.sendRedirect("ItemController?action=show-items");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error adding item: " + e.getMessage());
            request.getRequestDispatcher("/item/add-item.jsp").forward(request, response);
        }
    }

    private void updateItem(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            String name = request.getParameter("name").trim();
            double price = Double.parseDouble(request.getParameter("price"));
            int totalNumber = Integer.parseInt(request.getParameter("totalNumber"));

            ItemService service = new ItemServiceImpl(dataSource);

            Item item = new Item(id, name, price, totalNumber);
            service.updateItem(item);

            response.sendRedirect("ItemController?action=show-items");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error updating item: " + e.getMessage());
            showItem(request, response);
        }
    }

    private void deleteItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            ItemService service = new ItemServiceImpl(dataSource);
            service.removeItem(id);
            response.sendRedirect("ItemController?action=show-items");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error deleting item.");
        }
    }

}
