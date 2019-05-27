function executeRequest(type) {
    let request = {
        type: type,
        url: window.location.origin + '/api/' + jQuery('#url').val(),
        headers: {
            'Accept': 'application/json;charset=UTF-8',
            'Content-Type': 'application/json;charset=UTF-8'
        },
        complete: function (data) {
            let result = JSON.stringify(JSON.parse(data.responseText), null, '\t');
            jQuery("#response").val(result);
        }
    };

    switch (type) {
        case 'GET':
            let requestParameters = jQuery('#requestParameters').val();
            if (requestParameters) {
                request.data = JSON.parse(requestParameters);
            }
            break;
        case 'POST':
        case 'PUT':
            let requestBody = jQuery('#requestBody').val();
            if (requestBody) {
                request.data = requestBody;
            }
            break;
    }
    jQuery.ajax(request);
}
