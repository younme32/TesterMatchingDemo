"use strict";

var jquery = $;

var baseURL = "/api/demo/Matching/";
var matchTesters = "Match";
var getCountries = "countries";
var getDevices = "devices";

var GET = "GET";

function makeAjaxCall(url, type, successCallback, errorCallback)
{
	jquery.ajax({url: url, success: successCallback, type: type, error: errorCallback});
};

function prepareURL(apiCall, parameters)
{
	let url = baseURL + apiCall;
	if(parameters != undefined)
	{
		url += parameters;
	}
	return url;
}

function prepareParameters(countries, devices)
{
	let param = "?";
	if(countries?.size() > 0)
	{
		param += "countries=";
		countries.forEach(element => param += element + ",");
		param = param.slice(0, -1);
	}
	
	if(devices?.size() > 0)
	{
		param += "devices=";
		devices.forEach(element => param += element + ",");
		param = param.slize(0, -1);
	}
	
	
}