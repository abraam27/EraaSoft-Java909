import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ItemUtilService {

	private Connection connection;

	public ItemUtilService(Connection connection) {
		this.connection = connection;
	}

	public List<Item> getAllItems() throws SQLException {
		List<Item> items = new ArrayList<>();
		String sql = "SELECT id, name, price FROM Item";

		try (var stmt = connection.createStatement();
		     var rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				items.add(mapResultSetToItem(rs));
			}
		}
		return items;
	}

	public List<Item> getItemsByIds(int... ids) throws SQLException {
		List<Item> items = new ArrayList<>();

		if (ids == null || ids.length == 0) {
			return items;
		}

		String placeholders = String.join(",", "?".repeat(ids.length).split(""));
		String sql = "SELECT id, name, price FROM Item WHERE id IN (" + placeholders + ")";

		try (var stmt = connection.prepareStatement(sql)) {
			for (int i = 0; i < ids.length; i++) {
				stmt.setInt(i + 1, ids[i]);
			}

			var rs = stmt.executeQuery();
			while (rs.next()) {
				items.add(mapResultSetToItem(rs));
			}
		}

		return items;
	}

	public List<Item> getItemsByNameContaining(String searchChar) throws SQLException {
		List<Item> items = new ArrayList<>();
		String sql = "SELECT id, name, price FROM Item WHERE name LIKE ?";

		try (var stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, "%" + searchChar + "%");

			var rs = stmt.executeQuery();
			while (rs.next()) {
				items.add(mapResultSetToItem(rs));
			}
		}

		return items;
	}

	public List<Item> getItemsByPriceRange() throws SQLException {
		List<Item> items = new ArrayList<>();
		String sql = "SELECT id, name, price FROM Item WHERE price > 50 OR price < 20";

		try (var stmt = connection.prepareStatement(sql)) {
			var rs = stmt.executeQuery();
			while (rs.next()) {
				items.add(mapResultSetToItem(rs));
			}
		}

		return items;
	}

	public void saveItems(List<Item> items) throws SQLException {
		String sql = "INSERT INTO Item (name, price) VALUES (?, ?)";

		try (var stmt = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);

			for (Item item : items) {
				stmt.setString(1, item.getName());
				stmt.setDouble(2, item.getPrice());
				stmt.addBatch();
			}

			stmt.executeBatch();
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		} finally {
			connection.setAutoCommit(true);
		}
	}

	private Item mapResultSetToItem(java.sql.ResultSet rs) throws SQLException {
		Item item = new Item();
		item.setId(rs.getInt("id"));
		item.setName(rs.getString("name"));
		item.setPrice(rs.getDouble("price"));
		return item;
	}
}