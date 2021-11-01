"use strict";

function makeAPICall(type)
{
	if(type === matchTesters)
	{
		makeMatchTesterCall();	
	} else if(type === getCountries)
	{
		makeGetCountriesCall();	
	} else if (type === getDevices)
	{
		makeGetDevicesCall();
	}
	
}

function sortSelect(select)
{
	select.html(select.find("option").sort(function(x, y){
		return jquery(x).text() > jquery(y).text() ? 1 : -1;
	}));
}

function initializeSelect(selectID, callback)
{
	jquery("#" + selectID).change(callback);
}


//Run after fully loaded
jquery(window).on("load", function(){
	//Make call to get all countries available
	makeAPICall(getCountries);
	//Make call to get all devices available
	makeAPICall(getDevices);
	
	//Initialize Select elements
	initializeSelect("DeviceSelect", onSelectDevice);
	initializeSelect("CountrySelect", onSelectCountry);
	
	makeAPICall(matchTesters);
	
});