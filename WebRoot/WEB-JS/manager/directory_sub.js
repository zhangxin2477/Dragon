$(document).ready(function() {
	getAjax("sdir_page.pageNow=", "findallsdir", "1");
});

var loadData = function() {
	var result = "";
	for (var i = 0; i < dataList.length; i++) {
		result += "<tr onclick='sel(this)'><td style='display:none;'>0</td><td style='display:none;'>"
				+ dataList[i].id
				+ "</td><td style='display:none;'>"
				+ dataList[i].SDirId
				+ "</td><th scope='row'>"
				+ (i + 1)
				+ "</th><td>" + dataList[i].name + "</td></tr>";
	}
	document.getElementById("directory-sub").innerHTML = result;
}

$('#add-sub')
		.click(
				function() {
					showBox(
							"150px",
							"新增子菜单",
							"保存",
							"关闭",
							"<form style='padding:10px;'><div class='input-group'><span class='input-group-addon' id='basic-addon1'>子菜单名称</span><input type='text' class='form-control' placeholder='子菜单名称' aria-describedby='basic-addon1' name='sdirectory.name'></div></form>",
							"addsdir", "sdir_page.pageNow=", "findallsdir", "1");
				})

$('#edit-sub')
		.click(
				function() {
					var re = -1;
					var id = null, name = null, s_dir_id = null;
					var tb = document.getElementById('directory-sub');
					for (var i = 0; i < tb.rows.length; i++) {
						if (tb.rows[i].cells[0].innerText.indexOf('1') >= 0) {
							re = i + 1;
							id = tb.rows[i].cells[1].innerText;
							name = tb.rows[i].cells[4].innerText;
						}
					}
					if (re > 0) {
						showBox(
								"150px",
								"修改子菜单",
								"修改",
								"关闭",
								"<form style='padding:10px;'><input type='text' name='sdirectory.id' style='display:none;' value='"
										+ id
										+ "'/><div class='input-group'><span class='input-group-addon' id='basic-addon1'>子菜单名称</span><input type='text' class='form-control' placeholder='子菜单名称' aria-describedby='basic-addon1' value='"
										+ name
										+ "' name='sdirectory.name'></div></form>",
								"updatesdir", "sdir_page.pageNow", "findallsdir",
								"1");
					} else {
						layer.msg("选择不能为空！");
					}
				})

$('#delete-sub').click(
		function() {
			var re = -1;
			var id = -1;
			var tb = document.getElementById('directory-sub');
			for (var i = 0; i < tb.rows.length; i++) {
				if (tb.rows[i].cells[0].innerText.indexOf('1') >= 0) {
					re = i + 1;
					id = tb.rows[i].cells[1].innerText;
				}
			}
			if (re > 0) {
				layer.msg('确定删除第' + re + '条数据？', {
					time : 20000, // 20s后自动关闭
					btn : [ '确定', '取消' ],
					yes : function() {
						var params = "sdirectory.id=" + id;
						postAjax(params, "deletesdir", 0, "sdir_page.pageNow=",
								"findallsdir", "1");
					}
				});
			} else {
				layer.msg("选择不能为空！");
			}
		})
