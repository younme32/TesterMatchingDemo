"use strict";

function addDevice(deviceDescr, select)
{
	select.append(jquery("<option></option>").val(deviceDescr).html(deviceDescr));
	sortSelect(select);
}

function getDevicesSuccess(result)
{
	console.log("Devices Retrieved!");
	
	//Add Devices to Select
	let select = jquery("#DeviceSelect");
	result.forEach(function(element){
		addDevice(element.description, select);
	});
}

function getDevicesError()
{
	console.error("Error Getting Devices");
}

function makeGetDevicesCall()
{
	makeAjaxCall(prepareURL(getDevices), GET, getDevicesSuccess, getDevicesError);
}

function removeSelectedDevice()
{
	
}


function onSelectDevice()
{
	let select = jquery("#DeviceSelect");
	
	let value = select.val();
	
	//Create Selected Value Label
	let container = jquery("#SelectedDeviceContainer");
	let device = jquery("<label></label>").html(value).addClass("selectedValue")
	device.click(function(){
		addDevice($(this).html(), select);
		$(this).remove();
		makeAPICall(matchTesters);
	});
	container.append(device);
	
	jquery("#DeviceSelect option[value='" + value + "']").remove();
	
	makeAPICall(matchTesters);
}
