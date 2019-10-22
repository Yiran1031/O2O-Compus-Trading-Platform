$(function(){
	getList();
	function getList(e) {
		$.ajax({
			url:"/project/shopadmin/getshoplist",
			tyep:"get",
			dataType:"json",
			success:function(data){
				if(data.success) {
					handleList(data.shopList);
					handleUser(data.user);
				}
			}
		});
	}
	
	function handleUser(data){
		$('#user-name').text(data.name);
	}
	function handleList(data){
		var html='';
		data.map(function(item,index) {
			html += '<div class="row row-shop"><div class="col-40">'
				 + item.shopName + '</div><div class="col-40">'
				 + shopStatus(item.enableStatus)
				 + '</div><div class="col-20">'
				 + goShop(item.enableStatus, item.shopId) + '</div></div>';
		});
		$('.shop-wrap').html(html);
	}
	function shopStatus(status) {
		if(status == 0) {
			return 'checking';
		} else if (status == -1) {
			return 'closed';
		} else if (status == 1){
			return 'opening';
		}
	}
	
	function goShop(status,id) {
		if (status == 1) {
			return '<a href="/project/shopadmin/shopmanagement?shopId=' + id + '">enter</a>';
		} else {
			return'';
		}
	}
});