package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import beans.Crenau;
import beans.Salle;
import beans.reserv;
import beans.Client;
import beans.reservation;
import connexion.Connexion;
import dao.IDao;

public class ReservationService implements IDao<reservation> {

	private SalleService ss = new SalleService();
	private CrenauService crs = new CrenauService();
	private ClientService cls = new ClientService();
	

	
	@Override
	public boolean create(reservation o) {
		
//		Salle salle = new SalleService().findById(o.getIdSalle().getId());
//		Client client = new ClientService().findById(o.getIdClient().getId());
//		Crenau crenau = new CrenauService().findById(o.getIdCrenau().getId());

	
			/*String sql = "insert into reservation values (null,?, ?, ? ,?)";
			try {
				PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
				ps.setInt(1, o.getIdSalle().getId());
				ps.setInt(2, o.getIdCrenau().getId());
				ps.setInt(3, o.getIdClient().getId());
	            ps.setDate(4,new Date(o.getDate().getTime()));


				if (ps.executeUpdate() == 1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return false;*/
		String sql = "insert into reservation values (null,?, ?, ?,?,?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, o.getNom());
            ps.setInt(2, o.getCode());
            ps.setInt(3, o.getHeureDeb());
            ps.setDate(4,new Date(o.getDate().getTime()));
            ps.setString(5, o.getStatus());
            //ps.setString(5, o.getStatut());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("create occupation : erreur sql : " + e.getMessage());

        }
        return false;
	}

	@Override
	public boolean delete(reservation o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(reservation o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public reservation findById(int id) {
		/*String sql = "select * from reservation where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	return new reservation(rs.getInt("id"),rs.getInt("code"),
            			rs.getInt("nom"),rs.getInt("heureDeb"),rs.getDate("date"));
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }*/
        return null;
	}


	public List<reservation> findAll() {
		List<reservation> machines = new ArrayList<reservation>();

       /* String sql = "SELECT o.id,o.date,s.code,c.heureDeb,c.heureFin,cl.nom,o.statut FROM reservation o INNER join salle s on o.code=s.id INNER JOIN crenau c on c.id=o.heureDeb INNER JOIN client cl on cl.id=o.nom";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new reserv(rs.getInt("id"), rs.getString("code"),rs.getString("nom"),rs.getTime("heureDeb"),rs.getTime("heureFin"),rs.getDate("date"),rs.getString("statut")));
            }

        } catch (SQLException e) {
            System.out.println("findAlll " + e.getMessage());
        }*/
        return machines;
	}
	
	public List<reserv> findAll2() {
		List<reserv> machines = new ArrayList<reserv>();

        String sql = "SELECT o.id,o.date,s.code,c.heureDeb,c.heureFin,cl.nom,o.status FROM reservation o INNER join salle s on o.code=s.id INNER JOIN crenau c on c.id=o.heureDeb INNER JOIN client cl on cl.id=o.nom";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new reserv(rs.getInt("id"), rs.getString("nom"),rs.getString("code"),rs.getTime("heureDeb"),rs.getTime("heureFin"),rs.getDate("date"),rs.getString("status")));
            }

        } catch (SQLException e) {
            System.out.println("findAlll " + e.getMessage());
        }
        return machines;
	}
	
	public Map<String, Integer> plusresrv() {
		Map<String, Integer> map = new LinkedHashMap<>();
		ss = new SalleService();
		String sql = "select  code ,count(*) from reservation GROUP BY  code ORDER BY count(*) DESC";

		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				map.put(ss.findById(rs.getInt("code")).getCode(), rs.getInt("count(*)"));
			}

		} catch (SQLException e) {
			System.out.println("findAll " + e.getMessage());
		}

		return map;
	}

	public Map<LocalDate, Integer> parmois() {
		Map<LocalDate, Integer> map = new LinkedHashMap<>();

		String sql = "select YEAR (date), MONTH(date),COUNT(*) FROM reservation WHERE ( date BETWEEN DATE_SUB( CURRENT_DATE() , INTERVAL 1 YEAR) AND CURRENT_DATE() ) GROUP BY YEAR (date),MONTH(date) ORDER BY YEAR (date),MONTH(date) DESC ";

		try {
			PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				map.put( LocalDate.of(rs.getInt(1), rs.getInt(2) , 0) , rs.getInt("count(*)"));
			}

		} catch (SQLException e) {
			System.out.println("findAll " + e.getMessage());
		}

		return map;
	}

}
