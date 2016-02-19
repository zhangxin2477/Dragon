<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />

<div class="info">
	<div>
		<select id="s_province" name="s_province"></select> <select
			id="s_city" name="s_city"></select>   <select id="s_county"
			name="s_county"></select>
		<script class="resources library" src="${path}/WEB-PLUGIN/city/area.js" type="text/javascript"></script>

		<script type="text/javascript">
			_init_area();
		</script>
	</div>
	<div id="show"></div>
</div>
<script type="text/javascript">
	var Gid = document.getElementById;
	var showArea = function() {
		Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市"
				+ Gid('s_city').value + " - 县/区" + Gid('s_county').value
				+ "</h3>"
	}
	Gid('s_county').setAttribute('onchange', 'showArea()');
</script>