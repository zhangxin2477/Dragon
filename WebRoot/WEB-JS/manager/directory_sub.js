function selSub(tr) {
	var tb = document.getElementById('directory-sub');
	for (var i = 0; i < tb.rows.length; i++) {
		tb.rows[i].style.backgroundColor = "#ffffff";
		tb.rows[i].cells[2].innerText = 0;
	}
	tr.style.backgroundColor = "#dff0d8";
	tr.cells[2].innerText = 1;
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

$('#add-sub')
		.click(
				function() {
					layer
							.open({
								type : 1, // page层
								area : [ '50%', '150px' ],
								title : '新增子菜单',
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
				})

$('#edit-sub')
		.click(
				function() {
					var re = -1;
					var tb = document.getElementById('directory-sub');
					for (var i = 0; i < tb.rows.length; i++) {
						if (tb.rows[i].cells[2].innerText.indexOf('1') >= 0) {
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
		if (tb.rows[i].cells[2].innerText.indexOf('1') >= 0) {
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