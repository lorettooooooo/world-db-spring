package it.objectmethod.worlddb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.objectmethod.worlddb.dao.IDaoCountry;
import it.objectmethod.worlddb.domain.Country;

@Component
public class DaoCountryImpl implements IDaoCountry{
	
	@Autowired
	DataSource dataSource;

	@Override
	public List<Country> getCountriesByNameAndContinent(String countryName, String continentName) {
		List<Country> countriesList = new ArrayList<Country>();
		Country country = new Country();
		Connection conn;
		try {
			conn = dataSource.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(
				"SELECT * FROM country c " + "WHERE ('' LIKE ? OR Name LIKE ?) AND ('' LIKE ? OR Continent LIKE ? )");
		statement.setString(1, countryName);
		statement.setString(2, countryName);
		statement.setString(3, continentName);
		statement.setString(4, continentName);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			country = new Country();
			country.setCode(resultSet.getString("Code"));
			country.setName(resultSet.getString("Name"));
			country.setContinent(resultSet.getString("Continent"));
			country.setPopulation(resultSet.getInt("Population"));
			country.setArea(resultSet.getInt("SurfaceArea"));
			countriesList.add(country);
		}
		resultSet.close();
		statement.close();
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countriesList;
	}

	@Override
	public List<String> getContinents() {
		List<String> continentsList = new ArrayList<String>();
		String continentName;
		Connection conn;
		try {
			conn = dataSource.getConnection();
			PreparedStatement statement = conn.prepareStatement( "SELECT DISTINCT Continent FROM country c");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				continentName=resultSet.getString("Continent");
				continentsList.add(continentName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return continentsList;
	}

	@Override
	public List<Country> getCountriesByContinent(String continentName) {
		List<Country> countriesList = new ArrayList<Country>();
		Country country = new Country();
		Connection conn;
		try {
			conn = dataSource.getConnection();
			PreparedStatement statement = conn.prepareStatement( "SELECT * FROM country c WHERE Continent = ?");
			statement.setString(1, continentName);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				country = new Country();
				country.setName(resultSet.getString("Name"));
				country.setCode(resultSet.getString("Code"));
				country.setArea(resultSet.getInt("SurfaceArea"));
				country.setContinent("Continent");
				country.setPopulation(resultSet.getInt("Population"));
				countriesList.add(country);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countriesList;
	}

	@Override
	public Country getCountryByCode(String countryCode) {
		Country country = new Country();
		Connection conn;
		try {
			conn = dataSource.getConnection();
			PreparedStatement statement = conn.prepareStatement( "SELECT * FROM country c WHERE CountryCode = ?");
			statement.setString(1, countryCode);
			ResultSet resultSet = statement.executeQuery();
				country = new Country();
				country.setName(resultSet.getString("Name"));
				country.setCode(resultSet.getString("Code"));
				country.setArea(resultSet.getInt("SurfaceArea"));
				country.setContinent("Continent");
				country.setPopulation(resultSet.getInt("Population"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return country;
	}

}
