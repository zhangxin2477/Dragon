function sel(tr) {
	var tb = document.getElementById('body_list');
	for (var i = 0; i < tb.rows.length; i++) {
		tb.rows[i].style.backgroundColor = "#ffffff";
		tb.rows[i].cells[0].innerText = 0;
	}
	tr.style.backgroundColor = "#dff0d8";
	tr.cells[0].innerText = 1;
}

$('#add').click(function() {
	layer.open({
		type : 1, // page层
		area : [ '50%', '260px' ],
		title : '新增父菜单',
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
		content : ""
	});
})

$('#edit').click(function() {
	var re = -1;
	var tb = document.getElementById('body_list');
	for (var i = 0; i < tb.rows.length; i++) {
		if (tb.rows[i].cells[4].innerText.indexOf('1') >= 0) {
			re = i + 1;
		}
	}
	if (re > 0) {
		layer.open({
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
			content : ""
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