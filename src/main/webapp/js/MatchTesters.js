"use strict";

function clearTable(table)
{
	table.find("tr:gt(0)").remove();
}


function getTestersMatchSuccess(result)
{
	console.log("Tester Matching Successful!");
	let table = jquery(".results");
	clearTable(table);
	
	//Report Results
	result.forEach(function(element){
		let firstName = element.firstName;
		let lastName = element.lastName;
		let bugsFilled = element.bugsFilled;
		let country = element.country;
		
		let row = jquery("<tr></tr>");
		row.append(jquery("<td></td>").html(firstName));
		row.append(jquery("<td></td>").html(lastName));
		row.append(jquery("<td></td>").html(country));
		row.append(jquery("<td></td>").html(bugsFilled));
		
		table.append(row);
	});
}

function getTestersMatchError()
{
	console.error("Tester Matching Error");
}

function getValuesFromSelection(selection)
{
	let arr = [];
	selection.children().each(function(index, element){
		arr.push(element.innerHTML);
	});
	return arr;
}

function makeMatchTesterCall()
{
	let countries = [];
	let devices = []
	
	//Fill countries and devices with selected values (if there are any)
	countries = getValuesFromSelection(jquery("#SelectedCountryContainer"));
	devices = getValuesFromSelection(jquery("#SelectedDeviceContainer"));
	
	makeAjaxCall(prepareURL(matchTesters, prepareParameters(countries, devices)), GET, getTestersMatchSuccess, getTestersMatchError);
	
}

