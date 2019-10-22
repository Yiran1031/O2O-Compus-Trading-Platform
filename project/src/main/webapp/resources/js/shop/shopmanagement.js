/**
 * 
 */

$(function() {
	var shopId = getQueryString('shopId');
	var shopInfoUrl = '/project/shopadmin/getshopmanagementinfo?shopId=' + shopId;
	$.getJSON(shopInfoUrl, function(data){
		if (data.redirect) {
			window.location.href = data.url;
		} else {
			if (data.shopId != undefined && data.shopId != null) {
				shopId = data.shopId;
			}
			$('#shopInfo').attr('href','/project/shopadmin/shopoperation?shopId=' + shopId);
		}
	});
});