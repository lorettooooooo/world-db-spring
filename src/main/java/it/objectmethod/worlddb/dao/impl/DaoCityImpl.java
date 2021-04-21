package it.objectmethod.worlddb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.objectmethod.worlddb.dao.IDaoCity;
import it.objectmethod.worlddb.domain.City;

@Component
public class DaoCityImpl implements IDaoCity{

	@Autowired
	DataSource dataSource;
	
	@Override
	public List<City> getCityByName(String cityName) {
		List<City> citiesList = new ArrayList<City>();
		City city = new City();
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement statement= conn.prepareStatement("SELECT * FROM city WHERE Name = ?");
			statement.setString(1, cityName);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("ID");
				String name = resultSet.getString("Name");
				String countryCode = resultSet.getString("CountryCode");
				String district = resultSet.getString("District");
				Integer population = resultSet.getInt("Population");
				city.setId(id);
				city.setName(name);
				city.setCountryCode(countryCode);
				city.setDistrict(district);
				city.setPopulation(population);
				citiesList.add(city);
				
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return citiesList;
	}

	@Override
	public List<City> getCitiesByCountryCode(String readCountryCode) {
		List<City> citiesList = new ArrayList<City>();
		City city = null;
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement statement= conn.prepareStatement("SELECT * FROM city c WHERE CountryCode = ?");
			statement.setString(1, readCountryCode);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				city = new City();
				Integer id = resultSet.getInt("ID");
				String name = resultSet.getString("Name");
				String countryCode = resultSet.getString("CountryCode");
				String district = resultSet.getString("District");
				Integer population = resultSet.getInt("Population");
				city.setId(id);
				city.setName(name);
				city.setCountryCode(countryCode);
				city.setDistrict(district);
				city.setPopulation(population);
				citiesList.add(city);
				
			}
			resultSet.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return citiesList;
	}

}
