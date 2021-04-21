package it.objectmethod.worlddb.domain;

public class Country {
	private String code;
	private String name;
	private String continent;
	private Integer population;
	private Integer area;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
}
