$(document).ready(function() {
	getAjax("dir_page.pageNow=", "getdirpage", "1");
});

var loadData = function() {
	var result = "";
	for (var i = 0; i < dataList.length; i++) {
		result += "<tr onclick='sel(this)'>"
				+ "<td style='display:none;'>0</td>"
				+ "<td style='display:none;'>" + dataList[i].id + "</td>"
				+ "<td style='display:none;'>" + dataList[i].s_dir_id + "</td>"
				+ "<td style='display:none;'>" + dataList[i].theme_id + "</td>"
				+ "<th scope='row'>" + (i + 1) + "</th>" + "<td>"
				+ dataList[i].name + "</td>" + "<td>" + dataList[i].s_dir_id
				+ "</td>" + "<td>" + dataList[i].theme_id + "</td>" + "</tr>";
	}
	document.getElementById("directory-par").innerHTML = result;
}

$('#add-par')
		.click(
				function() {
					$
							.getJSON(
									"getthemelist",
									function(result, status) {
										if (status == "success") {
											var themeContent = "";
											for (var i = 0; i < result.length; i++) {
												themeContent += "<option value='"
														+ result[i].id
														+ "'>"
														+ result[i].nameCn
														+ "</option>";
											}
											showBox(
													"260px",
													"新增父菜单",
													"保存",
													"关闭",
													"<form style='padding:10px;'><div class='input-group'><span class='input-group-addon' id='basic-addon1'>父菜单名称</span><input type='text' class='form-control' placeholder='父菜单名称' aria-describedby='basic-addon1'></div><br>"
															+ "<div class='form-group input-group'><input type='text' class='form-control' placeholder='子菜单' disabled> <span class='input-group-btn'><button class='btn btn-info' type='button' onclick='dir_sub_choice()'>选择子菜单</button></span></div>"
															+ "<div class='input-group'><span class='input-group-addon' id='basic-addon1'>主题__名称</span><select class='form-control'>"
															+ themeContent
															+ "</select></div></form>",
													"adddir",
													"dir_page.pageNow=",
													"getdirpage", "1");
										}
									});
				})

var choice_sdir = function() {
	alert(123);
}

function dir_sub_choice() {
	$
			.getJSON(
					"getsdirfordir",
					function(result, status) {
						if (status == "success") {
							var sdirContent = "";
							for (var i = 0; i < result.length; i++) {
								sdirContent += "<label class='checkbox-inline'><input type='checkbox' id='inlineCheckbox1' value='"
										+ result[i][0]
										+ "'>"
										+ result[i][1]
										+ "</label>";
							}
							showTip("260px", "选择子菜单", "确定", "取消", sdirContent,
									choice_sdir);
						}
					});
}

$('#edit-par')
		.click(
				function() {
					var re = -1;
					var tb = document.getElementById('directory-par');
					for (var i = 0; i < tb.rows.length; i++) {
						if (tb.rows[i].cells[4].innerText.indexOf('1') >= 0) {
							re = i + 1;
						}
					}
					if (re > 0) {
						showBox();
						layer
								.open({
									type : 1, // page层
									area : [ '50%', '260px' ],
									title : '修改父菜单',
									shade : 0.6, // 遮罩透明度
									moveType : 1, // 拖拽风格，0是默认，1是传统拖动
									shift : 1, // 0-6的动画形式，-1不开启
									btn : [ '保存', '关闭' ],
									yes : function() {
										layer.msg('保存');
									},
									btn2 : function() {
										layer.close();
									},
									content : "<div style='padding:10px;'><div class='input-group'><span class='input-group-addon' id='basic-addon1'>父菜单名称</span><input type='text' class='form-control' placeholder='父菜单名称' aria-describedby='basic-addon1'></div><br>"
											+ "<div class='input-group'><span class='input-group-addon' id='basic-addon1'>子菜单名称</span><select class='form-control'><option>1</option><option>2</option></select></div><br>"
											+ "<div class='input-group'><span class='input-group-addon' id='basic-addon1'>主题__名称</span><select class='form-control'><option>1</option><option>2</option></select></div></div>"
								});
					} else {
						layer.msg("选择不能为空！");
					}
				})

$('#delete-par').click(function() {
	var re = -1;
	var tb = document.getElementById('directory-par');
	for (var i = 0; i < tb.rows.length; i++) {
		if (tb.rows[i].cells[4].innerText.indexOf('1') >= 0) {
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