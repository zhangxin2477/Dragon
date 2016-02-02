/**
 * 
 */

$(document).ready(function() {
	getAjax("pageList.pageNow=", "getclassifypage", "1");
});

var loadData = function() {
	var result = "";
	if (dataList != null) {
		for (var i = 0; i < dataList.length; i++) {
			result += "<tr onclick='sel(this)'><td style='display:none;'>0</td>"
					+ "<td style='display:none;'>"
					+ dataList[i][0]
					+ "</td>"
					+ "<td style='display:none;'>"
					+ dataList[i][1]
					+ "</td>"
					+ "<td>"
					+ (i + 1)
					+ "</td>"
					+ "<td>"
					+ dataList[i][2]
					+ "</td>"
					+ "<td>"
					+ dataList[i][3]
					+ "</td>"
					+ "<td>"
					+ dataList[i][4]
					+ "</td>"
					+ "<td>"
					+ dataList[i][5]
					+ "</td>"
					+ "<td style='display:none;'>"
					+ dataList[i][6]
					+ "</td>"
					+ "<td>" + dataList[i][7] + "</td></tr>";
		}
		document.getElementById("classify").innerHTML = result;
	}
};

$('#add')
		.click(
				function() {
					var themeData = $.ajax({
						url : "getthemelist",
						async : false
					}).responseJSON;
					var themelist = "<option value=''></option>";
					if (themeData.length > 0) {
						for (var i = 0; i < themeData.length; i++) {
							themelist += "<option value='" + themeData[i].id
									+ "'>" + themeData[i].nameCn + "</option>";
						}
					}
					var classifyData = $.ajax({
						async : false,
						url : "getclassifylist"
					}).responseJSON;
					var classifylist = "<option value=''></option>";
					if (classifyData.length > 0) {
						for (var i = 0; i < classifyData.length; i++) {
							classifylist += "<option value='"
									+ classifyData[i].id + "'>"
									+ classifyData[i].className + "</option>";
						}
					}
					showBox(
							"360px",
							"新增分类",
							"保存",
							"关闭",
							"<form style='padding:10px;'><div class='input-group'><span class='input-group-addon'>主题名称</span>"
									+ "<select name='classify.themeId' class='form-control'>"
									+ themelist
									+ "</select></div><div class='input-group'><span class='input-group-addon'>分类名称</span>"
									+ "<input name='classify.className' type='text' class='form-control' placeholder='分类名称'/></div><div class='input-group'><span class='input-group-addon'>父类名称</span>"
									+ "<select class='form-control' name='classify.classParentid'>"
									+ classifylist
									+ "</select></div><div class='input-group'><span class='input-group-addon'>层次</span>"
									+ "<select name='classify.classGrade' class='form-control'><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option></select></div><div class='input-group'><span class='input-group-addon'>级别</span>"
									+ "<select name='classify.classLevel' class='form-control'><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option></select></div></form>",
							"addclassify", "pageList.pageNow=",
							"getclassifypage", "1");
				});

$('#edit')
		.click(
				function() {
					var re = -1;
					var id = null, theme_id = null, parent_id = null, class_name = null, class_grade = null, class_level = null;
					var tb = document.getElementById('classify');
					for (var i = 0; i < tb.rows.length; i++) {
						if (tb.rows[i].cells[0].innerText.indexOf('1') >= 0) {
							re = i + 1;
							id = tb.rows[i].cells[1].innerText;
							class_name = tb.rows[i].cells[5].innerText;
							theme_id = tb.rows[i].cells[2].innerText;
							parent_id = tb.rows[i].cells[8].innerText;
							class_grade = tb.rows[i].cells[6].innerText;
							class_level = tb.rows[i].cells[7].innerText;
						}
					}
					if (re > 0) {
						var themeData = $.ajax({
							url : "getthemelist",
							async : false
						}).responseJSON;
						var themelist = "<option value=''></option>";
						if (themeData.length > 0) {
							for (var i = 0; i < themeData.length; i++) {
								if (theme_id == themeData[i].id) {
									themelist += "<option value='"
											+ themeData[i].id
											+ "' selected = 'selected'>"
											+ themeData[i].nameCn + "</option>";
								} else {
									themelist += "<option value='"
											+ themeData[i].id + "'>"
											+ themeData[i].nameCn + "</option>";
								}
							}
						}
						var classifyData = $.ajax({
							async : false,
							data : "params= where id<>" + id,
							url : "getclassifylist"
						}).responseJSON;
						var classifylist = "<option value=''></option>";
						if (classifyData.length > 0) {
							for (var i = 0; i < classifyData.length; i++) {
								if (parent_id == classifyData[i].id) {
									classifylist += "<option value='"
											+ classifyData[i].id
											+ "' selected = 'selected'>"
											+ classifyData[i].className
											+ "</option>";
								} else {
									classifylist += "<option value='"
											+ classifyData[i].id + "'>"
											+ classifyData[i].className
											+ "</option>";
								}
							}
						}
						var gradelist = "<option value=''></option>";
						for (var i = 1; i <= 5; i++) {
							if (class_grade == i) {
								gradelist += "<option value='" + i
										+ "' selected = 'selected'>" + i
										+ "</option>";
							} else {
								gradelist += "<option value='" + i + "'>" + i
										+ "</option>";
							}
						}
						var levellist = "<option value=''></option>";
						for (var i = 1; i <= 5; i++) {
							if (class_level == i) {
								levellist += "<option value='" + i
										+ "' selected = 'selected'>" + i
										+ "</option>";
							} else {
								levellist += "<option value='" + i + "'>" + i
										+ "</option>";
							}
						}
						showBox(
								"360px",
								"修改分类",
								"保存",
								"关闭",
								"<form style='padding:10px;'><div class='input-group'><span class='input-group-addon'>主题名称</span>"
										+ "<input style='display:none;' name='classify.id' type='text' class='form-control' placeholder='id' value='"
										+ id
										+ "'/><select name='classify.themeId' class='form-control'>"
										+ themelist
										+ "</select></div><div class='input-group'><span class='input-group-addon'>分类名称</span>"
										+ "<input name='classify.className' type='text' class='form-control' placeholder='分类名称' value='"
										+ class_name
										+ "'/></div><div class='input-group'><span class='input-group-addon'>父类名称</span>"
										+ "<select class='form-control' name='classify.classParentid'>"
										+ classifylist
										+ "</select></div><div class='input-group'><span class='input-group-addon'>层次</span>"
										+ "<select name='classify.classGrade' class='form-control'>"
										+ gradelist
										+ "</select></div><div class='input-group'><span class='input-group-addon'>级别</span>"
										+ "<select name='classify.classLevel' class='form-control'>"
										+ levellist + "</select></div></form>",
								"updateclassify", "pageList.pageNow=",
								"getclassifypage", "1");
					} else {
						layer.msg("选择的不能为空！");
					}
				});

$('#delete').click(
		function() {
			var re = -1;
			var id = null;
			var tb = document.getElementById('classify');
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
						var params = "classify.id=" + id;
						postAjax(params, "deleteclassify", 0,
								"pageList.pageNow=", "getclassifypage", "1");
					}
				});
			} else {
				layer.msg("选择的不能为空！");
			}
		});