package it.objectmethod.worlddb.dao;

import java.util.List;

import it.objectmethod.worlddb.domain.City;

public interface IDaoCity {
	public List<City> getCityByName(String cityName);
	public List<City> getCitiesByCountryCode(String countryCode);
}
