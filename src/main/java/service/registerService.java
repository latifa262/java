package service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import beans.Salle;
import beans.register;
import connexion.Connexion;
import dao.IDao;

public class registerService implements IDao<register> {

	@Override
	public boolean create(register o) {
		String sql = "insert into register values (null, ?, ?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getEmail());
            ps.setString(2, o.getPassword());

            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());

        }
        return false;
	}

	@Override
	public boolean delete(register o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(register o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public register findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<register> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String insertUser(register o) {
		String sql = "insert into register values (null, ?, ?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getEmail());
            ps.setString(2, o.getPassword());

            if (ps.executeUpdate() == 1) {
                return "data inserted";
            }
        } catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());

        }
        return "noooooooooooooooo";
	}

}
