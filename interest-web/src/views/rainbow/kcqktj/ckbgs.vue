<!-- 库存包裹数  -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">

				<Col span="8">日期：
				<Date-picker :value="dateValue"  @on-change='handleDateChange' type="daterange" editable="false" :options="dateOptions" placement="bottom-start" placeholder="选择日期" style="width: 250px"></Date-picker>
				</Col>

				<Col span="8" style="text-align: center;"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>

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
				date: null,
				searchContent: null,
				groupId: [],
				/*表显示字段*/
				columns1: [{
						title: "设备类型",
						key: "设备类型",
						align: "center"
					},
					{
						title: "出库包裹数",
						key: "出库包裹数",
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
						url: "/rainbow/ckbgs",
						timeout: 1000 * 60 * 2,
						params: {
							startDate: this.dateValue[0],
							endDate: this.dateValue[1]
						}
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))

							this.data1 = response.data.data;
							
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
