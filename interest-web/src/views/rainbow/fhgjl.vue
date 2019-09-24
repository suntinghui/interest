<!-- 复合关机率  -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">

				<Col span="8">日期：
				<DatePicker v-model="date" type="date" placeholder="选择日期" style="width: 250px"></DatePicker>
				</Col>

				<Col span="8">设备：
				<Select v-model="wangdianType" clearable style="width: 250px">
					<Option v-for="item in wangdianList" :value="item.id" :key="item.id">{{ item.title }}</Option>
				</Select>
				</Col>

				<Col span="8">所属地区：
				<Select v-model="wangdianType" clearable style="width: 250px">
					<Option v-for="item in areaList" :value="item.id" :key="item.id">{{ item.title }}</Option>
				</Select>
				</Col>

			</Row>
			<Row style="margin-bottom: 25px;">

				<Col span="8">渠道：
				<Select v-model="wangdianType" clearable style="width: 250px">
					<Option v-for="item in wangdianList" :value="item.id" :key="item.id">{{ item.title }}</Option>
				</Select>
				</Col>

				<Col span="8">网点：
				<Select v-model="wangdianType" clearable style="width: 250px">
					<Option v-for="item in wangdianList" :value="item.id" :key="item.id">{{ item.title }}</Option>
				</Select>
				</Col>

				<Col span="8">网点类型：
				<Select v-model="wangdianType" clearable style="width: 250px">
					<Option v-for="item in wangdianList" :value="item.id" :key="item.id">{{ item.title }}</Option>
				</Select>
				</Col>
			</Row>

			<Row style="margin-bottom: 25px; text-align: right;">
				<Col span="22"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>
			</Row>
		</div>

		<Spin size="large" fix v-if="showSpin"></Spin>

		<div style="padding: 10px 0;">
			<Table border :columns="columns1" :data="data1" :height="350"></Table>
		</div>

		<div ref="chart" :style="{width: '600px', height: '300px', display:'none'}"></div>
	</div>
</template>


<script>
	import util from '../../util.js'
	import data from '../../data.js'
	// for axios add finally
	import promiseFinally from 'promise.prototype.finally';
	promiseFinally.shim();

	export default {
		data() {
			return {
				showSpin: false,
				date: null,
				searchContent: null,
				groupId: [],
				wangdianList: [{
					id: 1,
					title: "第一"
				}],
				areaList: data.areaList(),
				/*表显示字段*/
				columns1: [{
						title: "标题",
						key: "title",
						align: "center"
					},
					{
						title: "数值",
						key: "value",
						align: "center"
					}
				],
				data1: []
			};
		},
		mounted() {
			/*页面初始化调用方法*/
			this.search();
			
			this.showCharts();
		},
		methods: {
			search() {
				this.showSpin = true;

				this.axios({
						method: "get",
						url: "/rainbow/fhgjl",
						params: {

						}
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))

							var item = {
								"title": "复合关机率",
								"value": util.toPercent(response.data.data)
							};

							this.data1 = [];
							this.data1.push(item);
						}.bind(this)
					)
					.catch(function(error) {
						alert(error);
					})
					.finally(function() {
						this.showSpin = false;
					}.bind(this));

			},
			showCharts: function() {
				var option = {
				    xAxis: {
				        type: 'category',
				        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
				    },
				    yAxis: {
				        type: 'value'
				    },
				    series: [{
				        data: [820, 932, 901, 934, 1290, 1330, 1320],
				        type: 'line'
				    }]
				};
				
				var myChart = this.$echarts.init(this.$refs.chart);
				myChart.setOption(option);
			}

		}
	};
</script>
