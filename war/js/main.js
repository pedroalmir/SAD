/** Data definition */

/** Parse data to JSON */
function parseJSON(data) {
    return window.JSON && window.JSON.parse ? window.JSON.parse(data) : (new Function("return " + data))(); 
}

/** Send request */
function sendRequest(json, items){
	$.ajax({
		url: '/services',
		type: 'POST',
		data: {json: json},
		beforeSend: function(){
			/* Active the loader */
			$('#execute').button('loading');
		}, success: function(data, textStatus, jqXHR){
			var result = parseJSON(data);
			console.log(result);
			
			/*var selectedItemsMap = new Object();
			$.map(result.selectedItems, function(value, key){
				selectedItemsMap[value.id] = value;
			});*/
			
		}, error: function(jqXHR, textStatus, errorThrown){
			console.log(textStatus);
		}, complete: function(jqXHR, textStatus){
			/* Disable the loader*/
			$('#execute').button('reset')
		}
	});
}

$(document).ready(function() {
	
	$('#execute').click(function(){
		var btn = $(this);
		$('#resultsPanel').show("slow", "swing");
	});
});