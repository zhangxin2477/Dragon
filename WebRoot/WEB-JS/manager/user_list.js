$(document).ready(function() {
	getAjax("page.pageNow=", "getuserpage", "1");
});

function seluser(tr) {
	var tb = tr.parentNode;
	for (var i = 0; i < tb.rows.length; i++) {
		tb.rows[i].style.backgroundColor = "#ffffff";
		tb.rows[i].cells[0].innerText = 0;
	}
	tr.style.backgroundColor = "#dff0d8";
	tr.cells[0].innerText = 1;
	if (tr.cells[6].innerText == "已启用") {
		document.getElementById("enable").disabled = "disabled";
		document.getElementById("disable").disabled = "";
	} else {
		document.getElementById("enable").disabled = "";
		document.getElementById("disable").disabled = "disable";
	}
}

var loadData = function() {
	var result = "";
	if (dataList != null) {
		for (var i = 0; i < dataList.length; i++) {
			result += "<tr onclick='seluser(this)'><td style='display:none;'>0</td>"
					+ "<td style='display:none;'>"
					+ dataList[i][0]
					+ "</td>"
					+ "<td>"
					+ (i + 1)
					+ "</td>"
					+ "<td>"
					+ dataList[i][1]
					+ "</td>"
					+ "<td>"
					+ dataList[i][2]
					+ "</td>";
			if (dataList[i][2] == 1) {
				result += "<td>管理员</td>";
			} else {
				result += "<td>普通用户</td>";
			}
			if (dataList[i][7] == 1) {
				result += "<td>已启用</td>";
			} else {
				result += "<td>未启用</td>";
			}
			result += "<td style='display:none;'>" + dataList[i][17] + "</td></tr>";
		}
		document.getElementById("user").innerHTML = result;
	}
};

$('#enable').click(function() {
	var re = -1, id = null, name;
	var tb = document.getElementById('user');
	for (var i = 0; i < tb.rows.length; i++) {
		if (tb.rows[i].cells[0].innerText.indexOf('1') >= 0) {
			re = i + 1;
			id = tb.rows[i].cells[1].innerText;
			name = tb.rows[i].cells[4].innerText;
		}
	}
	if (re > 0) {
		layer.msg('确定启用用户：' + name + '？', {
			time : 20000, // 20s后自动关闭
			btn : [ '确定', '取消' ],
			yes : function() {
				var result = $.ajax({
					url : "changestate",
					data : "users.id=" + id + "&users.active=1",
					async : false
				}).responseJSON;
				if (result == "success") {
					getAjax("page.pageNow=", "getuserpage", "1");
					layer.msg("启用成功！");
				} else {
					layer.msg("启用失败！");
				}
			}
		});
	} else {
		layer.msg("选择不能为空！");
	}
});

$('#disable').click(function() {
	var re = -1, id = null, name;
	var tb = document.getElementById('user');
	for (var i = 0; i < tb.rows.length; i++) {
		if (tb.rows[i].cells[0].innerText.indexOf('1') >= 0) {
			re = i + 1;
			id = tb.rows[i].cells[1].innerText;
			name = tb.rows[i].cells[4].innerText;
		}
	}
	if (re > 0) {
		layer.msg('确定禁用用户：' + name + '？', {
			time : 20000, // 20s后自动关闭
			btn : [ '确定', '取消' ],
			yes : function() {
				var result = $.ajax({
					url : "changestate",
					data : "users.id=" + id + "&users.active=0",
					async : false
				}).responseJSON;
				if (result == "success") {
					getAjax("page.pageNow=", "getuserpage", "1");
					layer.msg("禁用成功！");
				} else {
					layer.msg("禁用失败！");
				}
			}
		});
	} else {
		layer.msg("选择不能为空！");
	}
});

$('#delete').click(function() {
	var re = -1, id = null, sub_id = null;
	var tb = document.getElementById('user');
	for (var i = 0; i < tb.rows.length; i++) {
		if (tb.rows[i].cells[0].innerText.indexOf('1') >= 0) {
			re = i + 1;
			id = tb.rows[i].cells[1].innerText;
			sub_id = tb.rows[i].cells[7].innerText;
		}
	}
	if (re > 0) {
		layer.msg('确定删除第' + re + '条用户数据？', {
			time : 20000, // 20s后自动关闭
			btn : [ '确定', '取消' ],
			yes : function() {
				var result = $.ajax({
					url : "deleteuser",
					data : "users.id=" + id + "&susers.id=" + sub_id,
					async : false
				}).responseJSON;
				if (result == "success") {
					getAjax("page.pageNow=", "getuserpage", "1");
					layer.msg("删除成功！");
				} else {
					layer.msg("删除失败！");
				}
			}
		});
	} else {
		layer.msg("选择不能为空！");
	}
});