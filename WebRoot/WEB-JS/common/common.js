/**
 * 公共JS区
 */

var dataList;
var listen_dataList = function(_dataList, event) {
	dataList = _dataList;
	if (event) {
		event();
	}
};

var list;
var listen_list = function(_list, event) {
	list = _list;
	if (event) {
		event();
	}
};

// table选择
function sel(tr) {
	var tb = tr.parentNode;
	for (var i = 0; i < tb.rows.length; i++) {
		tb.rows[i].style.backgroundColor = "#ffffff";
		tb.rows[i].cells[0].innerText = 0;
	}
	tr.style.backgroundColor = "#dff0d8";
	tr.cells[0].innerText = 1;
}

function backAjax(params, url){
	$.ajax({
		type : "GET",
		url : url,
		async : true,
		data : params,
		dataType : "json",
		success : function(result, status, xhr) {
			if (status == "success") {
				listen_list(result, loadList);
			}
		},
		error : function(xhr, status, error) {
			layer.msg("加载失败！");
		}
	})
}

function postAjax(postparams, posturl, index, getparams, geturl, getvalue) {
	$.ajax({
		type : "POST",
		url : posturl,
		async : true,
		data : postparams,
		dataType : "json",
		success : function(result, status, xhr) {
			if (status == "success") {
				if (result == "success") {
					getAjax(getparams, geturl, getvalue);
					layer.msg("成功！");
					layer.close(index);
				} else {
					layer.msg("失败！");
				}
			} else {
				layer.msg("失败！");
			}
		},
		error : function(xhr, status, error) {
			layer.msg("失败！");
		}
	})
}

// 获取列表
function getAjax(params, url, value) {
	$.ajax({
		type : "GET",
		url : url,
		async : true,
		data : params + value,
		dataType : "json",
		success : function(result, status, xhr) {
			if (status == "success") {
				listen_dataList(result.dataList, loadData);
				var total = result.totalCount;
				var pageNow = result.pageNow;
				var pageCount = result.pageCount;
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
							getAjax(params, url, curr);
						}
					}
				});
			}
		},
		error : function(xhr, status, error) {
			layer.msg("加载失败！");
		}
	})
}

// 弹出弹框
function showBox(height, title, btn1, btn2, content, posturl, getparams,
		geturl, getvalue) {
	layer.open({
		type : 1, // page层
		area : [ '50%', height ],
		title : title,
		shade : 0.6, // 遮罩透明度
		moveType : 1, // 拖拽风格，0是默认，1是传统拖动
		shift : 1, // 0-6的动画形式，-1不开启
		btn : [ btn1, btn2 ],
		yes : function(index) {
			var postparams = $("form").serialize();
			postAjax(postparams, posturl, index, getparams, geturl, getvalue)
		},
		btn2 : function(index) {
			layer.close(index);
		},
		content : content
	});
}

function showTip(height, title, btn1, btn2, content,event){
	layer.open({
		type : 1, // page层
		area : [ '50%', height ],
		title : title,
		shade : 0.6, // 遮罩透明度
		moveType : 1, // 拖拽风格，0是默认，1是传统拖动
		shift : 1, // 0-6的动画形式，-1不开启
		btn : [ btn1, btn2 ],
		yes : function(index) {
			if(event){
				event();
			}
		},
		btn2 : function(index) {
			layer.close(index);
		},
		content : content
	});
}