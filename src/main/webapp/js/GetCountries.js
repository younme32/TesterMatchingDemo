"use strict";

function addCountry(country, select)
{
	select.append(jquery("<option></option>").val(country).html(country));
	sortSelect(select);
}

function getCountriesSuccess(result)
{
	let a = 5;
	console.log("Countries Retrieved!");
	
	//Add countries to Select	
	let select = jquery("#CountrySelect");
	result.forEach(function(element){
		addCountry(element, select);
	});
}

function getCountriesError()
{
	console.error("Error Getting Countries");
}

function makeGetCountriesCall()
{
	makeAjaxCall(prepareURL(getCountries), GET, getCountriesSuccess, getCountriesError);
}


function onSelectCountry()
{
	let select = jquery("#CountrySelect");
	
	let value = select.val();
	
	//Create Selected Value Label
	let container = jquery("#SelectedCountryContainer");
	let country = jquery("<label></label").html(value).addClass("selectedValue");
	country.click(function(){
		addCountry($(this).html(), select);
		$(this).remove();
		makeAPICall(matchTesters);
	});
	container.append(country);
	
	jquery("#CountrySelect option[value='" + value + "']").remove();
	
	makeAPICall(matchTesters);
	
}

