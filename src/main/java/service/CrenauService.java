package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Crenau;
import beans.Salle;
import connexion.Connexion;
import dao.IDao;

public class CrenauService implements IDao<Crenau> {

	@Override
	public boolean create(Crenau o) {
		 String sql = "insert into crenau values (null, ?, ?)";
	        try {
	            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
	            ps.setTime(1, o.getHeureDeb());
	            ps.setTime(2, o.getHeureFin());
	           

	           // ps.setDate(2, new Date(o.getHeureFin().getTime()));
	       
	            if (ps.executeUpdate() == 1) {
	                return true;
	            }
	        } catch (SQLException e) {
	            System.out.println("create : erreur sql : " + e.getMessage());

	        }
	        return false;
		
	}

	@Override
	public boolean delete(Crenau o) {
	    String sql = "delete from crenau where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("delete : erreur sql : " + e.getMessage());

        }
        return false;
	}

	@Override
	public boolean update(Crenau o) {
		String sql = "update crenau set heureDeb  = ? , heureFin = ? where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setTime(1, o.getHeureDeb());
            ps.setTime(2, o.getHeureFin());
           
            ps.setInt(3, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("update : erreur sql : " + e.getMessage());

        }
        return false;
	}

	@Override
	public Crenau findById(int id) {
        String sql = "select * from crenau where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Crenau(rs.getInt("id"), rs.getTime("heureDeb"), rs.getTime("heureFin"));
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
	}

	@Override
	public List<Crenau> findAll() {
		List<Crenau> Crenaux = new ArrayList<Crenau>();

        String sql = "select * from crenau";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Crenaux.add(new Crenau(rs.getInt("id"),rs.getTime("heureDeb"), rs.getTime("heureFin")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return Crenaux;
	}

}
