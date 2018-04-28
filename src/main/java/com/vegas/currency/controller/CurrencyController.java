package com.vegas.currency.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegas.currency.entity.CurrencyRate;
import com.vegas.currency.repository.CurrencyRepository;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

	@Autowired
	CurrencyRepository currencyRepository;

	@GetMapping("/rate/{countryCode}")
	List<CurrencyRate> getRate(@PathVariable("countryCode") String countryCode) {
		return currencyRepository.findAllByCountryCodeFrom(countryCode);
	}

	@GetMapping("/rate/{sourceCountryCode}/{targetCountryCode}")
	String getForexRate(@PathVariable("sourceCountryCode") String sourceCountryCode,
			@PathVariable("targetCountryCode") String targetCountryCode) {
		return String.valueOf(currencyRepository
				.findAllByCountryCodeFromAndCountryCodeTo(sourceCountryCode, targetCountryCode).getConversionRate());
	}

	@PostMapping(value = "/rate/")
	CurrencyRate save(@RequestBody CurrencyRate currencyRate) {
		currencyRate.setLastUpdatedOn(LocalDate.now());
		return currencyRepository.save(currencyRate);
	}
}
