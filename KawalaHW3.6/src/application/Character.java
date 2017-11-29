package application;

public class Character {
	private String name;
	private int age;
	private int height;
	private String profession;
	private String race;

	public Character(String name, int age, int height, String profession, String race) {
		this.name = name;
		this.setAge(age);
		this.height = height;
		this.profession = profession;
		this.race = race;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
