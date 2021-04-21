package it.objectmethod.worlddb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.worlddb.dao.IDaoCity;
import it.objectmethod.worlddb.dao.IDaoCountry;
import it.objectmethod.worlddb.dao.utils.DependencyInjectionEx;
import it.objectmethod.worlddb.domain.City;
import it.objectmethod.worlddb.domain.Country;

@Controller
public class HomeController {

	@Autowired
	IDaoCity iDaoCity;

	@Autowired
	IDaoCountry iDaoCountry;

	DependencyInjectionEx esempio;

	@GetMapping("/login")
	public String prepareLogin(HttpServletResponse resp) throws IOException {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("username") String username,
			HttpSession session, ModelMap map) {

		String nextPage = null;
		if (username.isBlank() || username.isEmpty()) {
			nextPage = "login";
			map.addAttribute("loginErrorMessage", "Username Non Valido");
		} else {
			nextPage = "home";
			session.setAttribute("username", username);
		}
		return nextPage;
	}

	@GetMapping("/home")
	public String getBackToHome() {
		return "home";
	}

	@GetMapping("/cityInfo")
	public String cityInfo() {
		return "cityInfo";
	}

	@PostMapping("/cityInfo")
	public String citySearch(@RequestParam("cityName") String cityName, ModelMap map) {
		List<City> citiesList = null;
		citiesList = iDaoCity.getCityByName(cityName);
		if (citiesList.isEmpty()) {
			map.addAttribute("errorMessage", "Errore, città non trovata");
		} else {
			map.addAttribute("citiesList", citiesList);
		}
		return "cityInfo";
	}

	@GetMapping("/countryInfo")
	public String countryInfo() {
		return "countryInfo";
	}

	@PostMapping("/countryInfo")
	public String countrySearch(@RequestParam("countryName") String countryName,
			@RequestParam("continentName") String continentName, ModelMap map) {
		List<Country> countriesList = null;
		if (countryName.isBlank())
			countryName = "";
		if (continentName.isBlank())
			continentName = "";
		countriesList = iDaoCountry.getCountriesByNameAndContinent('%' + countryName + '%', '%' + continentName + '%');
		if (countriesList.isEmpty()) {
			map.addAttribute("errorMessage", "Nessuna nazione trovata");
		} else {
			map.addAttribute("countriesList", countriesList);
		}
		return "countryInfo";

	}

	@GetMapping("/searchByContinents")
	public String searchByContinents(ModelMap map) {
		List<String> continentsList = new ArrayList<String>();
		continentsList = iDaoCountry.getContinents();
		map.addAttribute("continentsList", continentsList);
		return "searchByContinents";
	}

	@GetMapping("/{selectedContinent}/countries")
	public String searchByContinents(@PathVariable("selectedContinent") String selectedContinent, HttpSession session, ModelMap map) {
		List<Country> countriesList = iDaoCountry.getCountriesByContinent(selectedContinent);
		session.setAttribute("selectedContinent", selectedContinent);
		map.addAttribute("countriesList", countriesList);
		return "searchByCountry";
	}

	@GetMapping("/{country.code}/cities")
	public String searchByCountry(@PathVariable("country.code") String selectedCountryCode, HttpSession session, ModelMap map) {
		
		List<City> citiesList = iDaoCity.getCitiesByCountryCode(selectedCountryCode);
		session.setAttribute("selectedCountryCode", selectedCountryCode);
		map.addAttribute("citiesList", citiesList);
		return "citiesInfo";
	}
}