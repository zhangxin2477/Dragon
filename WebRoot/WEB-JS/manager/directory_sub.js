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
					var tb = document.getElementById('directory-sub');
					for (var i = 0; i < tb.rows.length; i++) {
						if (tb.rows[i].cells[0].innerText.indexOf('1') >= 0) {
							re = i + 1;
						}
					}
					if (re > 0) {
						layer
								.open({
									type : 1, // page层
									area : [ '50%', '150px' ],
									title : '修改子菜单',
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
									content : "<div style='padding:10px;'><div class='input-group'><span class='input-group-addon' id='basic-addon1'>子菜单名称</span><input type='text' class='form-control' placeholder='子菜单名称' aria-describedby='basic-addon1'></div></div>"
								});
					} else {
						layer.msg("选择不能为空！");
					}
				})

$('#delete-sub').click(function() {
	var re = -1;
	var tb = document.getElementById('directory-sub');
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
