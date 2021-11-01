"use strict";

function getCountriesSuccess(result)
{
	let a = 5;
	console.log("Countries Retrieved!");
	
	//Add countries to Select	
}

function getCountriesError()
{
	console.error("Error Getting Countries");
}

function makeGetCountriesCall()
{
	makeAjaxCall(prepareURL(getCountries), GET, getCountriesSuccess, getCountriesError);
}
