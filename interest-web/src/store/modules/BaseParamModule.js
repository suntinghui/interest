import axios from "axios";

export default {

	state: {
		areaList: [], // 区域
		shopTypeList: [], // 网点类型
		shopList: [], // 网点
		deviceTypeList: [] ,// 设备类型
		channelList: [] // 渠道列表
	},
	
	mutations: {
		setAreaList(state, value) {
			state.areaList = value;
		},
		setShopTypeList(state, value) {
			state.shopTypeList = value;
		},
		setShopList(state, value) {
			state.shopList = value;
		},
		setDeviceTypeList(state, value) {
			state.deviceTypeList = value;
		},
		setChannelList(state, value) {
			state.channelList = value;
		}
		
	},

	actions: {
		queryAllParam(context) {
			this.dispatch("queryAreaList")
			this.dispatch("queryShopTypeList")
			this.dispatch("queryShopList")
			this.dispatch("queryDeviceTypeList")
			this.dispatch("queryChannelList")
		},
		
		queryParam (type) {
			this.dispatch(type);
		},

		queryAreaList(context) {
			axios({
					method: "get",
					url: "rainbow/areaList",
				})
				.then(function(response) {
					console.log(JSON.stringify(response))
					context.commit('setAreaList', response.data.data)
				})
				.catch(function(error) {
					console.log(error)
				});
		},
		
		queryShopTypeList(context) {
			axios({
					method: "get",
					url: "rainbow/shopTypeList",
				})
				.then(function(response) {
					console.log(JSON.stringify(response))
					context.commit('setShopTypeList', response.data.data)
				})
				.catch(function(error) {
					console.log(error)
				});
		},
		
		queryShopList(context) {
			axios({
					method: "get",
					url: "rainbow/shopList",
				})
				.then(function(response) {
					console.log(JSON.stringify(response))
					context.commit('setShopList', response.data.data)
				})
				.catch(function(error) {
					console.log(error)
				});
		},
		
		queryDeviceTypeList(context) {
			axios({
					method: "get",
					url: "rainbow/deviceTypeList",
				})
				.then(function(response) {
					console.log(JSON.stringify(response))
					context.commit('setDeviceTypeList', response.data.data)
				})
				.catch(function(error) {
					console.log(error)
				});
		},
		
		queryChannelList(context) {
			axios({
					method: "get",
					url: "rainbow/channelList",
				})
				.then(function(response) {
					console.log(JSON.stringify(response))
					context.commit('setChannelList', response.data.data)
				})
				.catch(function(error) {
					console.log(error)
				});
		},



	}



}
