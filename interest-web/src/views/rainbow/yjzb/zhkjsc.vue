<!-- 综合开机时长  -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">
		
				<Col span="12">日期：
				<Date-picker :value="dateValue"  @on-change='handleDateChange' :clearable="false"  type="daterange" editable="false" :options="dateOptions" placement="bottom-start" placeholder="选择日期" style="width: 250px"></Date-picker>
				</Col>
		
				<Col span="8"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>
		
			</Row>
			
		</div>

		<Spin size="large" fix v-if="showSpin"></Spin>

		<div style="padding: 10px 0;">
			<Table border :columns="columns1" :data="data1" :height="350"></Table>
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
				date: null,
				searchContent: null,
				groupId: [],
				/*表显示字段*/
				columns1: [{
						title: "标题",
						key: "title",
						align: "center"
					},
					{
						title: "数值(小时)",
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
		},
		methods: {
			search() {
				this.showSpin = true;

				this.axios({
						method: "get",
						url: "/rainbow/zhkjsc",
						timeout: 1000 * 60 * 2,
						params: {
							startDate: this.dateValue[0],
							endDate: this.dateValue[1],
						}
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))

							var item = {
								"title": "综合开机时长",
								"value": response.data.data
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
				this.dateValue = daterange;
			}
			

		}

	};
</script>
