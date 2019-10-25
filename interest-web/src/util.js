export default {

	toPercent: function(point) {
		if (point == 0) {
			return 0;
		}
		var str = Number(point * 100).toFixed(2);
		str += "%";
		return str;
	},

	lastWeek: function(date) {
		var curDate = new Date();
		curDate.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
		return curDate;
	},
	
	dateFormat: function(date) {
		var year = date.getFullYear();
		/* 在日期格式中，月份是从0开始的，因此要加0
		 * 使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05
		 * */
		var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
		var day = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
		// 拼接
		return year + "-" + month + "-" + day;
	},

	datetimeFormat: function(date) {
		var year = date.getFullYear();
		/* 在日期格式中，月份是从0开始的，因此要加0
		 * 使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05
		 * */
		var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
		var day = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
		var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
		var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
		var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
		// 拼接
		return year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
	},
	
	numFixed: function(num) {
		try{
			return num.toFixed(2)
		}catch(e){
			return 0.00;
		}
	}
	
	

}
