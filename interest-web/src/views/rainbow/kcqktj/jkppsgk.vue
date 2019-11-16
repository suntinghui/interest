<!-- 即开票配送概况  -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">

				<Col span="8">日期：
				<Date-picker :value="dateValue"  @on-change='handleDateChange' type="daterange" :clearable="false" editable="false" :options="dateOptions" placement="bottom-start" placeholder="选择日期" style="width: 250px"></Date-picker>
				</Col>

				<Col span="8"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>

			</Row>
		</div>
		
		<Spin size="large" fix v-if="showSpin"></Spin>

		<div style="padding: 10px 0;">
			<Table border :columns="columns1" :data="data1" :height="450" :search="true"></Table>
		</div>
		
		<Modal closable scrollable :mask-closable="false" v-model="showDetailModel" width="60%" :title="detailTitle" style="padding-left: 30px; padding-right: 30px;">
			<Table border size="default" :columns="columns2" :data="data2" :height="450" ></Table>
			<div slot="footer"></div>
		</Modal>
		
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
				deviceModel: [],
				dateValue: [util.dateFormat(util.lastWeek(new Date())), util.dateFormat(new Date())],
				showDetailModel: false,
				detailTitle: "详情",
				
				showSpin: false,
				date: null,
				searchContent: null,
				groupId: [],
				/*表显示字段*/
				columns1: [{
						title: "日期",
						key: "日期",
						align: "center",
						sortable: true
					},
					{
						title: "即开票数量（张）",
						key: "即开票数量（张）",
						align: "center",
						sortable: true
					},
					{
						title: "总价值（元）",
						key: "总价值（元）",
						align: "center",
						sortable: true
					},
					{
						title: "总包裹数",
						key: "总包裹数",
						align: "center",
						sortable: true
					},
					{
						title: "操作",
						key: "Action",
						align: "center",
						width: 150,
						render: (h, params) => {
							return h('Button', {
								props: {
									type: "primary"
								},
								on: {
									click: () => {
										this.queryDetailInfo(params.row)
									}
								}
							}, "详情")
						}
					}
				],
				data1: [],
				columns2: [
					{
						title: "设备编号",
						key: "设备编号",
						align: "center",
						sortable: true,
						width:180,
					},
					{
						title: "网点编号",
						key: "网点编号",
						align: "center",
						width:150,
						sortable: true
					},
					{
						title: "网点名称",
						key: "网点名称",
						align: "center",
						sortable: true,
						width:300
					},
					{
						title: "票种",
						key: "票种",
						align: "center",
						width:150,
						sortable: true
					},
					{
						title: "面值",
						key: "面值",
						align: "center",
						width:150,
						sortable: true
					},
					{
						title: "即开票数量（张）",
						key: "即开票数量（张）",
						align: "center",
						width:180,
						sortable: true
					},
					{
						title: "总价值（元）",
						key: "总价值（元）",
						align: "center",
						width:150,
						sortable: true
					},
					{
						title: "出库时间",
						key: "出库时间",
						align: "center",
						width:180,
						sortable: true
					},
					{
						title: "加仓时间",
						key: "加仓时间",
						align: "center",
						width:180,
						sortable: true
					},
					{
						title: "配送员昵称",
						key: "配送员昵称",
						align: "center",
						width:150
					},
					{
						title: "门店地址",
						key: "门店地址",
						align: "center",
						width:400
					}
				],
				data2: []
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
						url: "/rainbow/jkppsgk",
						timeout: 1000 * 60 * 2,
						params: {
							filterMap: {
								startDate: this.dateValue[0],
								endDate: this.dateValue[1],
							}
						},
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
			
			queryDetailInfo (rowData) {
				this.showSpin = true;
				
				this.axios({
						method: "get",
						url: "/rainbow/jkppsmx",
						timeout: 1000 * 60 * 2,
						params: {
							filterMap: {
								startDate: rowData['日期'],
								endDate: rowData['日期']
							}
						},
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))
				
							this.data2 = response.data.data;
							
							this.showDetailModel = true;
							
							this.detailTitle = rowData['日期'];
							
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
