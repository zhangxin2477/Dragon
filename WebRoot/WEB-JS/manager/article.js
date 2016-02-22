$(document).ready(function() {
	getAjax("page.pageNow=", "getarticlepage", "1");
});

var loadData = function() {
	var result = "";
	for (var i = 0; i < dataList.length; i++) {
		result += "<tr onclick='sel(this)'><td style='display:none;'>0</td><td style='display:none;'>"
				+ dataList[i][0]
				+ "</td><th scope='row'>"
				+ (i + 1)
				+ "</th><td>"
				+ dataList[i][3]
				+ "</td><td>"
				+ dataList[i][11]
				+ "</td><td>"
				+ dataList[i][5]
				+ "</td><td>"
				+ dataList[i][6]
				+ "</td><td>"
				+ dataList[i][8]
				+ "</td><td>"
				+ dataList[i][9]
				+ "</td><td>" + dataList[i][7] + "</td><td>";
		if (dataList[i][10] == 1) {
			result += "启用";
		} else {
			result += "禁用";
		}
		result += "</td></tr>";
	}
	document.getElementById("article").innerHTML = result;
}

$('#enable').click(function() {
	var re = -1, id = null;
	var tb = document.getElementById('article');
	for (var i = 0; i < tb.rows.length; i++) {
		if (tb.rows[i].cells[0].innerText.indexOf('1') >= 0) {
			re = i + 1;
			id = tb.rows[i].cells[1].innerText;
		}
	}
	if (re > 0) {
		layer.msg('确定启用所选内容？', {
			time : 20000, // 20s后自动关闭
			btn : [ '确定', '取消' ],
			yes : function() {
				var result = $.ajax({
					url : "changearticlestate",
					data : "article.id=" + id + "&article.state=1",
					async : false
				}).responseJSON;
				if (result == "success") {
					getAjax("page.pageNow=", "getarticlepage", "1");
					layer.msg("启用成功！");
				} else {
					layer.msg("启用失败！");
				}
			}
		});
	} else {
		layer.msg("选择不能为空！");
	}
})

$('#disable').click(function() {
	var re = -1, id = null;
	var tb = document.getElementById('article');
	for (var i = 0; i < tb.rows.length; i++) {
		if (tb.rows[i].cells[0].innerText.indexOf('1') >= 0) {
			re = i + 1;
			id = tb.rows[i].cells[1].innerText;
		}
	}
	if (re > 0) {
		layer.msg('确定禁用所选内容？', {
			time : 20000, // 20s后自动关闭
			btn : [ '确定', '取消' ],
			yes : function() {
				var result = $.ajax({
					url : "changearticlestate",
					data : "article.id=" + id + "&article.state=0",
					async : false
				}).responseJSON;
				if (result == "success") {
					getAjax("page.pageNow=", "getarticlepage", "1");
					layer.msg("禁用成功！");
				} else {
					layer.msg("禁用失败！");
				}
			}
		});
	} else {
		layer.msg("选择不能为空！");
	}
})

$('#delete').click(function() {
	var re = -1, id;
	var tb = document.getElementById('article');
	for (var i = 0; i < tb.rows.length; i++) {
		if (tb.rows[i].cells[0].innerText.indexOf('1') >= 0) {
			re = i + 1;
			id = tb.rows[i].cells[1].innerText;
		}
	}
	if (re > 0) {
		layer.msg('确定删除第' + re + '条数据内容？', {
			time : 20000, // 20s后自动关闭
			btn : [ '确定', '取消' ],
			yes : function() {
				var result = $.ajax({
					url : "deletearticle",
					data : "article.id=" + id,
					async : false
				}).responseJSON;
				if (result == "success") {
					getAjax("page.pageNow=", "getarticlepage", "1");
					layer.msg("删除成功！");
				} else {
					layer.msg("删除失败！");
				}
			}
		});
	} else {
		layer.msg("选择不能为空！");
	}
})