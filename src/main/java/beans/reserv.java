package beans;

import java.sql.Time;
import java.util.Date;

public class reserv {
	private int id;
	private String nom;
    private String code;
	private Time heureDeb;
	private Time heureFin;
    private String status;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Time getHeureDeb() {
		return heureDeb;
	}
	public void setHeureDeb(Time heureDeb) {
		this.heureDeb = heureDeb;
	}
	public Time getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(Time heureFin) {
		this.heureFin = heureFin;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public reserv(int id,  String nom, String code,Time heureDeb, Time heureFin, Date date,String status) {
		super();
		this.id = id;
		this.nom = nom;
		this.code = code;
		this.heureDeb = heureDeb;
		this.heureFin = heureFin;
		this.status = status;
		this.date = date;
	}
	
}
