$(document).ready(function() {
	getAjax("page.pageNow=", "getarticlepage", "1");
});

var loadData = function() {
	var result = "";
	for (var i = 0; i < dataList.length; i++) {
		result += "<tr onclick='sel(this)'><td style='display:none;'>0</td><td style='display:none;'>"
				+ dataList[i].id
				+ "</td><th scope='row'>"
				+ (i + 1)
				+ "</th><td>"
				+ dataList[i].title
				+ "</td><td>"
				+ dataList[i].classifyId
				+ "</td><td>"
				+ dataList[i].newtime
				+ "</td><td>"
				+ dataList[i].updatetime
				+ "</td><td>"
				+ dataList[i].praisecount
				+ "</td><td>"
				+ dataList[i].readcount
				+ "</td><td>"
				+ dataList[i].limit
				+ "</td><td>"
				+ dataList[i].state
				+ "</td></tr>";
	}
	document.getElementById("article").innerHTML = result;
}

$('#enable').click(function() {
	var re = -1;
	var tb = document.getElementById('article');
	for (var i = 0; i < tb.rows.length; i++) {
		if (tb.rows[i].cells[0].innerText.indexOf('1') >= 0) {
			re = i + 1;
		}
	}
	if (re > 0) {
		layer.msg('确定启用？', {
			time : 20000, // 20s后自动关闭
			btn : [ '确定', '取消' ],
			yes : function() {
				layer.msg('确定' + re);
			}
		});
	} else {
		layer.msg("选择不能为空！");
	}
})

$('#disable').click(function() {
	var re = -1;
	var tb = document.getElementById('article');
	for (var i = 0; i < tb.rows.length; i++) {
		if (tb.rows[i].cells[0].innerText.indexOf('1') >= 0) {
			re = i + 1;
		}
	}
	if (re > 0) {
		layer.msg('确定禁用？', {
			time : 20000, // 20s后自动关闭
			btn : [ '确定', '取消' ],
			yes : function() {
				layer.msg('确定' + re);
			}
		});
	} else {
		layer.msg("选择不能为空！");
	}
})

$('#delete').click(function() {
	var re = -1;
	var tb = document.getElementById('article');
	for (var i = 0; i < tb.rows.length; i++) {
		if (tb.rows[i].cells[0].innerText.indexOf('1') >= 0) {
			re = i + 1;
		}
	}
	if (re > 0) {
		layer.msg('确定删除第' + re + '条数据？', {
			time : 20000, // 20s后自动关闭
			btn : [ '确定', '取消' ],
			yes : function() {
				layer.msg('确定' + re);
			}
		});
	} else {
		layer.msg("选择不能为空！");
	}
})