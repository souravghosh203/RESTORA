/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RESTORA.DAO;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Dao {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    public boolean insertProduct(Product p) {
        String sql = "insert into product (ProductName, Price, Images) values (?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setBytes(3, p.getImage());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public void getFoods(JTable table) {
        String sql = "SELECT * FROM product";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();

            Object[] row;

            while (rs.next()) {
                row = new Object[4];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getDouble(3);
                row[3] = rs.getBytes(4);

                model.addRow(row);
            }
        } catch (SQLException e) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public boolean update(Product product) {
        String sql = "update product set ProductName = ?,Price = ? where ProductID = ? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getId());
//            ps.setBytes(4, product.getImage());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {

            return false;
        }
    }
    
    public boolean deleteProduct(int productId) {
    String sql = "DELETE FROM product WHERE ProductID = ?";

    try (Connection con = MyConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, productId);
        int rowsAffected = ps.executeUpdate();

        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    

    public int getOrderTable() {
        int row = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(CartID) from cart");
            while (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (Exception e) {

            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, e);
        }
        return row + 1;
    }

    public boolean isProductExist(int cartId, int productId) {
        boolean exists = false;
        String query = "SELECT * FROM cart WHERE CartID = ? AND ProductID = ?";

        try (Connection con = MyConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, cartId);
            ps.setInt(2, productId);

            ResultSet rs = ps.executeQuery();
            exists = rs.next();  // true if a row is found

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exists;
    }

    public boolean insertCart(CartDao cart) {
        String query = "INSERT INTO cart (CartID, ProductID, ProductName, Quantity, Price, Total) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = MyConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, cart.getcId());
            ps.setInt(2, cart.getpId());
            ps.setString(3, cart.getpName());
            ps.setInt(4, cart.getQuantity());
            ps.setDouble(5, cart.getPrice());
            ps.setDouble(6, cart.getTotal());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getCartTable() {
        int row = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(CartID) from cart");
            while (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (Exception e) {

            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, e);
        }
        return row;
    }

    public int getPaymentTable() {
        int row = 0;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT MAX(PaymentID) FROM payment");

            while (rs.next()) {
                row = rs.getInt(1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public double subTotal() {
        double subtotal = 0.0;
        int cid = getCartTable();

        try {

            st = con.createStatement();
            rs = st.executeQuery("SELECT SUM(Total) as 'total' FROM cart where CartID = '" + cid + "'");

            if (rs.next()) {
                subtotal = rs.getDouble(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subtotal;
    }

    public void getProductsFromCart(JTable table) {
        String sql = "SELECT * FROM cart WHERE CartID = ?";

        int cid = getCartTable();

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cid);
            rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();

            Object[] row;

            while (rs.next()) {
                row = new Object[6];
                row[0] = rs.getInt(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getString(3);
                row[3] = rs.getInt(4);
                row[4] = rs.getDouble(5);
                row[5] = rs.getDouble(6);

                model.addRow(row);
            }
        } catch (SQLException e) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public boolean insertPayment(Payment payment) {
        String sql = "INSERT INTO payment (PaymentID,CName,ProductID,ProductName,Total,Date) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = MyConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, payment.getPid());
            ps.setString(2, payment.getcName());
            ps.setString(3, payment.getProId());
            ps.setString(4, payment.getProName());
            ps.setDouble(5, payment.getTotal());
            ps.setString(6, payment.getDate());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCart(int cid) {
        try {
            ps = con.prepareStatement("delete from cart where CartID = ?");
            ps.setInt(1, cid);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    public void getPaymentDetails(JTable table) {
        String sql = "SELECT * FROM payment order by PaymentID desc";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();

            Object[] row;

            while (rs.next()) {
                row = new Object[6];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getDouble(5);
                row[5] = rs.getString(6);

                model.addRow(row);
            }
        } catch (SQLException e) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public int totalProducts() {
        int total = 0;

        try {
            st = con.createStatement();
            rs = st.executeQuery("select count(*) as 'total' from product");

            if (rs.next()) {
                total = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public double todayRevenue(String date) {
        double total = 0.0;

        try {
            st = con.createStatement();
            rs = st.executeQuery("select sum(Total) as 'total' from payment where Date = '" + date + "'");

            if (rs.next()) {
                total = rs.getDouble(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;

    }

    public double totalRevenue() {
        double total = 0.0;

        try {
            st = con.createStatement();
            rs = st.executeQuery("select sum(Total) as 'total' from payment");

            if (rs.next()) {
                total = rs.getDouble(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;

    }

}
