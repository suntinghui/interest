<!-- 零销量设备占比统计  -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">

				<Col span="8">日期：
				<DatePicker :value="queryDate" @on-change="handleDateChange" type="date" placeholder="选择日期" style="width: 250px"></DatePicker>
				</Col>

				<Col span="8">设备：
				<Select v-model="deviceModel" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.deviceTypeList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}</Option>
				</Select>
				</Col>

				<Col span="8">所属地区：
				<Select v-model="areaModel" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.areaList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}</Option>
				</Select>
				</Col>

			</Row>
			<Row style="margin-bottom: 25px;">

				<Col span="8">渠道：
				<Select v-model="channelModel"  filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.channelList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}</Option>
				</Select>
				</Col>

				<Col span="8">网点：
				<Select v-model="shopModel" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.shopList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }} ({{item.paramKey}})</Option>
				</Select>
				</Col>

				<Col span="8">网点类型：
				<Select v-model="shopTypeModel" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.shopTypeList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}</Option>
				</Select>
				</Col>
			</Row>

			<Row style="margin-bottom: 25px; text-align: right;">
				<Col span="22"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>
			</Row>
		</div>
		
		<Spin size="large" fix v-if="showSpin"></Spin>

		<div style="padding: 10px 0;">
			<Table border :columns="columns1" :data="data1" :height="350" :search="true"></Table>
		</div>
		
	</div>
</template>


<script>
	import util from '../../../util.js'
	import data from '../../../data.js'
	// for axios add finally
	import promiseFinally from 'promise.prototype.finally';
	promiseFinally.shim();

	export default {
		data() {
			return {
				queryDate: util.dateFormat(util.yestoday()),
				showSpin: false,
				date: null,
				searchContent: null,
				groupId: [],
				/*表显示字段*/
				columns1: [{
						title: "在网设备总数",
						key: "在网设备总数",
						align: "center"
					},
					{
						title: "在网开机设备总数",
						key: "在网开机设备总数",
						align: "center"
					},
					{
						title: "在网总体零销量设备数",
						key: "在网总体零销量设备数",
						align: "center"
					},
					{
						title: "在网开机零销量设备数",
						key: "在网开机零销量设备数",
						align: "center"
					},
					{
						title: "零销量设备占比",
						key: "零销量设备占比",
						align: "center"
					},
					{
						title: "零销量设备开机数占比",
						key: "零销量设备开机数占比",
						align: "center"
					}
				],
				data1: []
			};
		},
		mounted() {
			// 查询所有的参数
			this.$store.dispatch('queryAllParam');
			
			/*页面初始化调用方法*/
			this.search();
		},
		methods: {
			search() {
				this.showSpin = true;

				this.axios({
						method: "get",
						url: "/rainbow/lxlsbzbtj",
						timeout: 1000 * 60 * 2,
						params: {
							queryDate: this.queryDate
						}
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))

							this.data1 = [];
							this.data1.push(response.data.data)
							
						}.bind(this)
					)
					.catch(function(error) {
						alert(error);
					})
					.finally(function() {
						this.showSpin = false;
					}.bind(this));

			},
			
			handleDateChange: function(selDate) {
				this.queryDate = selDate
			}
			

		}
	};
</script>
