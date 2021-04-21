package it.objectmethod.worlddb.dao;

import java.util.List;

import it.objectmethod.worlddb.domain.Country;


public interface IDaoCountry {
	public List<Country> getCountriesByNameAndContinent(String countryName, String continentName);
	public List<String> getContinents();
	public List<Country> getCountriesByContinent(String continentName);
	public Country getCountryByCode(String countryCode);

}
