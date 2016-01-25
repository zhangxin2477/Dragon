$(document).ready(function() {
	LoadThemeData("page.pageNow=1");
});

function sel(tr) {
	var tb = document.getElementById('theme');
	for (var i = 0; i < tb.rows.length; i++) {
		tb.rows[i].style.backgroundColor = "#ffffff";
		tb.rows[i].cells[0].innerText = 0;
	}
	tr.style.backgroundColor = "#dff0d8";
	tr.cells[0].innerText = 1;
}

function LoadThemeData(params) {
	$
			.ajax({
				type : "GET",
				async : true,
				url : "findalltheme",
				data : params,
				dataType : "json",
				success : function(data) {
					var result = "";
					var dataList = data.dataList;
					var total = data.totalCount;
					var pageNow = data.pageNow;
					var pageCount = data.pageCount;
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
					laypage({
						cont : $('.page'), // 容器。值支持id名、原生dom对象，jquery对象,
						pages : pageCount, // 总页数
						curr : pageNow,
						skip : true, // 是否开启跳页
						skin : '#337ab7',
						groups : 5, // 连续显示分页数
						jump : function(obj, first) { // 触发分页后的回调
							var curr = obj.curr;
							if (!first) {
								LoadThemeData("page.pageNow=" + curr);
							}
						}
					});
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					layer.msg("FUCK");
				}
			});
}

$('#add')
		.click(
				function() {
					layer
							.open({
								type : 1, // page层
								area : [ '50%', '260px' ],
								title : '新增主题',
								shade : 0.6, // 遮罩透明度
								moveType : 1, // 拖拽风格，0是默认，1是传统拖动
								shift : 1, // 0-6的动画形式，-1不开启
								btn : [ '注册', '关闭' ],
								yes : function(index) {
									var params = $("form").serialize();
									$
											.ajax({
												type : "POST",
												async : true,
												url : "addtheme",
												data : params,
												dataType : "json",
												success : function(data) {
													if (data == "success") {
														LoadThemeData("page.pageNow=1");
														layer.msg("注册成功！");
														layer.close(index);
													} else {
														layer.msg("注册失败！");
													}
												},
												error : function(
														XMLHttpRequest,
														textStatus, errorThrown) {
													layer.msg("注册失败！");
													return false;
												}
											});
								},
								btn2 : function(index) {
									layer.close(index);
								},
								content : "<form style='padding:10px;'><div class='input-group'><span class='input-group-addon' id='basic-addon1'>中文名称</span><input name='theme.nameCn' type='text' class='form-control' placeholder='中文名称' aria-describedby='basic-addon1'></div><br>"
										+ "<div class='input-group'><span class='input-group-addon' id='basic-addon1'>英文名称</span><input name='theme.nameEn' type='text' class='form-control' placeholder='英文名称' aria-describedby='basic-addon1'></div><br>"
										+ "<div class='input-group'><span class='input-group-addon' id='basic-addon1'>注册码</span><input name='theme.preKey' type='text' class='form-control' placeholder='注册码' aria-describedby='basic-addon1'></div></form>"
							});
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
						layer
								.open({
									type : 1, // page层
									area : [ '50%', '200px' ],
									title : '修改主题',
									shade : 0.6, // 遮罩透明度
									moveType : 1, // 拖拽风格，0是默认，1是传统拖动
									shift : 1, // 0-6的动画形式，-1不开启
									btn : [ '修改', '关闭' ],
									yes : function() {
										var params="";
										$.ajax({
											type : "POST",
											async : true,
											url : "updatetheme",
											data : params,
											dataType : "json",
											success : function(data) {
												if (data == "success") {
													LoadThemeData("page.pageNow=1");
													layer.msg("修改成功！");
													layer.close(index);
												} else {
													layer.msg("修改失败！");
												}
											},
											error : function(
													XMLHttpRequest,
													textStatus, errorThrown) {
												layer.msg("修改失败！");
												return false;
											}
										});
										layer.msg('修改成功');
									},
									btn2 : function() {
										layer.close();
									},
									content : "<form style='padding:10px;'><div class='input-group'><span class='input-group-addon' id='basic-addon1'>中文名称</span><input type='text' class='form-control' placeholder='中文名称' aria-describedby='basic-addon1' value='"
											+ name_cn
											+ "' name='theme.nameCn'></div><br>"
											+ "<div class='input-group'><span class='input-group-addon' id='basic-addon1'>英文名称</span><input type='text' class='form-control' placeholder='英文名称' aria-describedby='basic-addon1' value='"
											+ name_cn + "' name='theme.nameEn'></div></form>"
								});
					} else {
						layer.msg("选择不能为空！");
					}
				})

$('#delete').click(function() {
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
				$.ajax({
					type : "POST",
					async : true,
					url : "deletetheme",
					data : params,
					dataType : "json",
					success : function(data) {
						if (data == "success") {
							layer.msg("删除成功！");
							LoadThemeData("page.pageNow=1");
						} else {
							layer.msg("删除失败！");
						}
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						layer.msg("删除失败！");
					}
				});
			}
		});
	} else {
		layer.msg("选择不能为空！");
	}
})