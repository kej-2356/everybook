/**
 * ajax 곧통모듈
 * ------------------
 * make 유영주
 */
var commonAjax = function(url, data, fn, methodType, errormsg){
	console.log(url);
	console.log(data);
	console.log(fn);
	console.log(methodType);
	console.log(errormsg);
	var request = $.ajax({
		  url: url,
		  method: methodType,
		  data: data,
		  dataType: "json"
		});
	
	request.done(fn);
	
	request.fail(function( jqXHR, textStatus ) {
		  alert( errormsg + textStatus );
		});
}