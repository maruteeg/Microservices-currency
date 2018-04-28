package com.vegas.currency.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vegas.currency.entity.CurrencyRate;

public interface CurrencyRepository extends JpaRepository<CurrencyRate, Integer> {

	List<CurrencyRate> findAllByCountryCodeFrom(String countryCodeFrom);
	
	CurrencyRate findAllByCountryCodeFromAndCountryCodeTo(String countryCodeFrom, String countryCodeTo);
}
