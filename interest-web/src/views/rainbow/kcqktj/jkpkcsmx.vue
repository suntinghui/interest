<!-- 即开票库存数明细(截止24时)  -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">
				
				<Col span="8">日期：
				<Date-picker :value="queryDate"  @on-change='handleDateChange' type="date" editable="false" placement="bottom-start" placeholder="选择日期" style="width: 250px"></Date-picker>
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
				queryDate: util.dateFormat(util.yestoday()),
				showSpin: false,
				date: null,
				searchContent: null,
				groupId: [],
				/*表显示字段*/
				columns1: [{
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
						title: "入库数量",
						key: "入库数量",
						sortable: true,
						align: "center"
					},
					{
						title: "出库数量",
						key: "出库数量",
						sortable: true,
						align: "center"
					},
					{
						title: "库存数量",
						key: "库存数量",
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
						url: "/rainbow/jkpkcsmx",
						timeout: 1000 * 60 * 2,
						params: {
							queryMonth: this.queryDate,
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
			
			handleDateChange(selDate) {
				this.queryDate = selDate;
			}
			

		}
	};
</script>
