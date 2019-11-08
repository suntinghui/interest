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

	lastMonth: function(curDate) {
		var year = curDate.getFullYear();
		var month = curDate.getMonth()+1;
		
		if (month == 1) {
			year = year - 1;
			month = 12;
		} else {
			month = month-1;
		}
		
		if (month<10) {
			return year+"-0"+month;
		} else {
			return year+"-"+month;
		}
	},

	yestoday: function() {
		var curDate = new Date();
		curDate.setTime(curDate.getTime() - 3600 * 1000 * 24 * 1);
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
		try {
			return num.toFixed(2)
		} catch (e) {
			return 0.00;
		}
	},

	arr2Str: function(arr) {
		return JSON.stringify(arr).replace(/\[/g, "").replace(/]/g, "");
	}



}
