"use strict";

function getDevicesSuccess(result)
{
	console.log("Devices Retrieved!");
	
	//Add Devices to Select
}

function getDevicesError()
{
	console.error("Error Getting Devices");
}

function makeGetDevicesCall()
{
	makeAjaxCall(prepareURL(getDevices), GET, getDevicesSuccess, getDevicesError);
}
