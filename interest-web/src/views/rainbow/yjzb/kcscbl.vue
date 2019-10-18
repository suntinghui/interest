<!-- 空仓时长比率  -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">

				<Col span="20">起止日期：
					<Date-picker :value="dateValue"  @on-change='handleDateChange' type="daterange" editable="false" :options="dateOptions" placement="bottom-start" placeholder="选择日期" style="width: 240px"></Date-picker>
				</Col>
				
				<Col span="4"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>
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
				dateValue: [util.dateFormat(util.lastWeek(new Date())), util.dateFormat(new Date())],
				
				showSpin: false,
				searchContent: null,
				groupId: [],
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
				data1: [],
				dateOptions: {
					shortcuts: [{
							text: '最近一周',
							value() {
								const end = new Date();
								const start = new Date();
								start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
								return [start, end];
							}
						},
						{
							text: '最近一个月',
							value() {
								const end = new Date();
								const start = new Date();
								start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
								return [start, end];
							}
						},
						{
							text: '最近三个月',
							value() {
								const end = new Date();
								const start = new Date();
								start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
								return [start, end];
							}
						}
					]
				}
			};
		},
		mounted() {
			/*页面初始化调用方法*/
			this.search();
		},
		methods: {
			search() {
				this.showSpin = true;

				this.axios({
						method: "get",
						url: "/rainbow/kcscbl",
						params: {
							startDate: this.dateValue[0],
							endDate: this.dateValue[1],
						}
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))

							var item = {
								"title": "空仓时长比率",
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
			handleDateChange(daterange) {
				console.log(daterange)
				this.dateValue = daterange;
			}


		}
	};
</script>
