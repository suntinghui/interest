<!-- 即开票月度采购票种明细表  -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">
				
				<Col span="10">起止月份：
				<Date-picker :value="startMonth"  @on-change='handleStartDateChange' :clearable="false" type="month" editable="false"  placement="bottom-start" placeholder="开始月份" style="width: 150px"></Date-picker>
				-
				<Date-picker :value="endMonth"  @on-change='handleEndDateChange' :clearable="false" type="month" editable="false" placement="bottom-start" placeholder="截止月份" style="width: 150px"></Date-picker>
				</Col>
				
				<Col span="4" style="text-align: center;"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>

			</Row>
			
		</div>
		
		<Spin size="large" fix v-if="showSpin"></Spin>

		<div style="padding: 10px 0;">
			<Table border :columns="columns1" :data="data1" :height="450" :search="true"></Table>
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
				startMonth: util.lastMonth(new Date()),
				endMonth: util.dateFormat(new Date()),
				showSpin: false,
				date: null,
				searchContent: null,
				groupId: [],
				/*表显示字段*/
				columns1: [{
						title: "月份",
						key: "月份",
						sortable: true,
						align: "center"
					},
					{
						title: "票种",
						key: "票种",
						sortable: true,
						align: "center"
					},
					{
						title: "面值",
						key: "面值",
						sortable: true,
						align: "center"
					},
					{
						title: "采购张数",
						key: "采购张数",
						sortable: true,
						align: "center"
					},
					{
						title: "总价值",
						key: "总价值",
						sortable: true,
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
						url: "/rainbow/jkpydcgpzmx",
						timeout: 1000 * 60 * 2,
						params: {
							startMonth: this.startMonth,
							endMonth: this.endMonth
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
			
			handleStartDateChange(selMonth) {
				this.startMonth = selMonth;
			},
			
			handleEndDateChange(selMonth) {
				this.endMonth = selMonth;
			}
			

		}
	};
</script>
