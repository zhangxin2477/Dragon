function sel(tr) {
	var tb = document.getElementById('body_list');
	for (var i = 0; i < tb.rows.length; i++) {
		tb.rows[i].style.backgroundColor = "#ffffff";
		tb.rows[i].cells[0].innerText = 0;
	}
	tr.style.backgroundColor = "#dff0d8";
	tr.cells[0].innerText = 1;
}

laypage({
	cont : $('.page'), // 容器。值支持id名、原生dom对象，jquery对象,
	pages : 100, // 总页数
	skip : true, // 是否开启跳页
	skin : '#337ab7',
	groups : 5, // 连续显示分页数
	first : '首页', // 若不显示，设置false即可
	last : '尾页', // 若不显示，设置false即可
	prev : '上一页', // 若不显示，设置false即可
	next : '下一页', // 若不显示，设置false即可
	hash : true, // 开启hash
	jump : function(obj) { // 触发分页后的回调
		
	}
});

$('#enable').click(function() {
	var re = -1;
	var tb = document.getElementById('body_list');
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
	var tb = document.getElementById('body_list');
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
	var tb = document.getElementById('body_list');
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