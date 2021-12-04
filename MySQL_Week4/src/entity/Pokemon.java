package entity;

public class Pokemon {
	
	private int id;
	private String name;
	private int level;
	private String type;
	private String gender;
	
	public Pokemon(int id, String name, int level, String type, String gender) {
		this.setId(id);
		this.setName(name);
		this.setLevel(level);
		this.setType(type);
		this.setGender(gender);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
