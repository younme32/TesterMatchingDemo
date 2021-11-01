"use strict";

function makeAPICall(type)
{
	if(type === matchTesters && countries !== undefined && devices !== undefined)
	{
		makeMatchTestersCall();	
	} else if(type === getCountries)
	{
		makeGetCountriesCall();	
	} else if (type === getDevices)
	{
		makeGetDevicesCall();
	}
	
}

//Run after fully loaded
jquery(window).on("load", function(){
	//Make call to get all countries available
	makeAPICall(getCountries);
	//Make call to get all devices available
	makeAPICall(getDevices);
});