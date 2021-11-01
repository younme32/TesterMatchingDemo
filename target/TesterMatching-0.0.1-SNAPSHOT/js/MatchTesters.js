"use strict";

function getTestersMatchSuccess(result)
{
	console.log("Tester Matching Successful!");
	
	//Report Results
}

function getTestersMatchError()
{
	console.error("Tester Matching Error");
}

function makeMatchTesterCall()
{
	let countries = [];
	let devices = []
	
	//Fill countries and devices with selected values (if there are any)
	
	makeAjaxCall(prepareURL(matchTesters, prepareParameters(countries, devices)), GET, getTestersMatchSuccess, getTestersMatchError);
	
}

