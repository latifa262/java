package beans;


public class Salle {

    private int id;
    private String code;
    private int capacite;
    private String type;

    public Salle(int id, String code, int capacite, String type) {
        this.id = id;
        this.code = code;
        this.capacite = capacite;
        this.type = type;
    }

    public Salle(String code, int capacite, String type) {
        this.code = code;
        this.capacite = capacite;
        this.type = type;
    }

    public int getId() {
        return id;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Salle [code=" + code + ", capacite=" + capacite + ", type=" + type + "]";
	}

    
}
