export default {
	
	toPercent: function(point) {
		if (point == 0) {
			return 0;
		}
		var str = Number(point * 100).toFixed(2);
		str += "%";
		return str;
	}
	
}
