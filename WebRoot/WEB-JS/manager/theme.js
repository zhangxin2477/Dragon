$(document).ready(function() {
	getAjax("page.pageNow=", "findalltheme", "1");
});

var loadData = function() {
	var result = "";
	for (var i = 0; i < dataList.length; i++) {
		result += "<tr onclick='sel(this)'><td style='display:none;'>0</td><td style='display:none;'>"
				+ dataList[i].id
				+ "</td><th scope='row'>"
				+ (i + 1)
				+ "</th><td>"
				+ dataList[i].nameCn
				+ "</td><td>"
				+ dataList[i].nameEn
				+ "</td><td>"
				+ dataList[i].preKey
				+ "</td></tr>";
	}
	document.getElementById("theme").innerHTML = result;
}

$('#add')
		.click(
				function() {
					showBox(
							"260px",
							"新增主题",
							"注册",
							"关闭",
							"<form style='padding:10px;'><div class='input-group'><span class='input-group-addon' id='basic-addon1'>中文名称</span><input name='theme.nameCn' type='text' class='form-control' placeholder='中文名称' aria-describedby='basic-addon1'></div><br>"
									+ "<div class='input-group'><span class='input-group-addon' id='basic-addon1'>英文名称</span><input name='theme.nameEn' type='text' class='form-control' placeholder='英文名称' aria-describedby='basic-addon1'></div><br>"
									+ "<div class='input-group'><span class='input-group-addon' id='basic-addon1'>注册码</span><input name='theme.preKey' type='text' class='form-control' placeholder='注册码' aria-describedby='basic-addon1'></div></form>",
							"addtheme", "page.pageNow=", "findalltheme", "1");
				})

$('#edit')
		.click(
				function() {
					var re = -1;
					var id = null, name_cn = null, name_en = null, pre_key = null;
					var tb = document.getElementById('theme');
					for (var i = 0; i < tb.rows.length; i++) {
						if (tb.rows[i].cells[0].innerText.indexOf('1') >= 0) {
							re = i + 1;
							id = tb.rows[i].cells[1].innerText;
							name_cn = tb.rows[i].cells[3].innerText;
							name_en = tb.rows[i].cells[4].innerText;
							pre_key = tb.rows[i].cells[5].innerText;
						}
					}
					if (re > 0) {
						showBox(
								"200px",
								"修改主题",
								"修改",
								"关闭",
								"<form style='padding:10px;'><input type='text' name='theme.id' style='display:none;' value='"
										+ id
										+ "'/><div class='input-group'><span class='input-group-addon' id='basic-addon1'>中文名称</span><input type='text' class='form-control' placeholder='中文名称' aria-describedby='basic-addon1' value='"
										+ name_cn
										+ "' name='theme.nameCn'></div><br>"
										+ "<div class='input-group'><span class='input-group-addon' id='basic-addon1'>英文名称</span><input type='text' class='form-control' placeholder='英文名称' aria-describedby='basic-addon1' value='"
										+ name_en
										+ "' name='theme.nameEn'></div></form>",
								"updatetheme", "page.pageNow", "findalltheme",
								"1");
					} else {
						layer.msg("选择不能为空！");
					}
				})

$('#delete').click(
		function() {
			var id = -1;
			var re = -1;
			var tb = document.getElementById('theme');
			for (var i = 0; i < tb.rows.length; i++) {
				if (tb.rows[i].cells[0].innerText.indexOf('1') >= 0) {
					id = tb.rows[i].cells[1].innerText;
					re = i + 1;
				}
			}
			if (re > 0) {
				layer.msg('确定删除第' + re + '条数据？', {
					time : 20000, // 20s后自动关闭
					btn : [ '确定', '取消' ],
					yes : function() {
						var params = "theme.id=" + id;
						postAjax(params, "deletetheme", 0, "page.pageNow=",
								"findalltheme", "1")
					}
				});
			} else {
				layer.msg("选择不能为空！");
			}
		})