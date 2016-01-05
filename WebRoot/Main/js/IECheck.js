$(document).ready(function() {
	detectBrowser();
});

function detectBrowser() {
	var browser = navigator.appName
	var b_version = navigator.appVersion
	var version = b_version.substr(b_version.indexOf('MSIE') + 4, 3).replace(' ', '').replace('.', '')
	if (browser == "Microsoft Internet Explorer") {
		if (version >= 8) {
			return true;
		} else {
			if (version <= 6) {
				alert('为了更好的体验，请升级您的浏览器了！');
			} else {
				layer.alert('为了更好的体验，请升级您的浏览器了！', {
					icon : 0
				});
			}
			return false;
		}
	} else {
		return true;
	}
}