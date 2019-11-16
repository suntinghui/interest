<!-- 即开票配送明细  -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">

				<Col span="8">日期：
				<Date-picker :value="dateValue"  @on-change='handleDateChange' :clearable="false" type="daterange" editable="false" :options="dateOptions" placement="bottom-start" placeholder="选择日期" style="width: 250px"></Date-picker>
				</Col>

				<Col span="8">设备类型：
				<Select v-model="deviceModel" filterable clearable multiple style="width: 250px">
					<Option v-for="item in this.$store.state.param.deviceTypeList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}</Option>
				</Select>
				</Col>

				<Col span="8"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>

			</Row>
		</div>
		
		<Spin size="large" fix v-if="showSpin"></Spin>

		<div style="padding: 10px 0;">
			<Table border :columns="columns1" :data="data1" :height="450" :search="true"></Table>
		</div>
		<div style="text-align: right;">
			<Page :total="total" :page-size="pageInfo.pageSize" show-sizer show-total @on-page-size-change="e=>{pageSizeChange(e)}" @on-change="e=>{pageSearch(e)}"></Page>
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
				deviceModel: [],
				dateValue: [util.dateFormat(util.lastWeek(new Date())), util.dateFormat(new Date())],
				
				showSpin: false,
				date: null,
				searchContent: null,
				groupId: [],
				total: 0,
				/*pageInfo实体*/
				pageInfo: {
					page: 0,
					pageSize: 10
				},
				/*表显示字段*/
				columns1: [{
						title: "日期",
						key: "日期",
						align: "center",
						sortable: true,
						width:180,
						fixed: 'left'
					},
					{
						title: "设备编号",
						key: "设备编号",
						align: "center",
						sortable: true,
						width:180,
						fixed: 'left'
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
						width:200
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
						width:200
					},
					{
						title: "门店地址",
						key: "门店地址",
						align: "center",
						width:400
					}
				],
				data1: []
			};
		},
		mounted() {
			// 查询所有的参数
			this.$store.dispatch('queryAllParam');
			
			/*页面初始化调用方法*/
			this.getTable({
				pageInfo: this.pageInfo
			});
		},
		methods: {
			initPageInfo() {
				this.pageInfo.page = 0;
				this.pageInfo.pageSize = 10;
			},
			
			search() {
				this.initPageInfo();
				this.getTable({
					pageInfo: this.pageInfo
				});
			},
			
			getTable(e) {
				this.showSpin = true;
				
				this.axios({
						method: "get",
						url: "/rainbow/jkppsmx",
						timeout: 1000 * 60 * 2,
						params: {
							page: e.pageInfo.page,
							pageSize: e.pageInfo.pageSize,
							startDate: this.dateValue[0],
							endDate: this.dateValue[1]
						},
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))

							this.data1 = response.data.data.data;
							this.total = response.data.data.totalCount;
							
						}.bind(this)
					)
					.catch(function(error) {
						alert(error);
					})
					.finally(function() {
						this.showSpin = false;
						
					}.bind(this));

			},
			
			/*分页点击事件*/
			pageSearch(e) {
				this.pageInfo.page = e - 1;
				this.getTable({
					pageInfo: this.pageInfo
				});
			},
			
			// 改变每页显示条数时触发
			pageSizeChange(e) {
				this.pageInfo.pageSize = e;
				this.pageInfo.page = 0;
				this.getTable({
					pageInfo: this.pageInfo
				});
			},
			
			handleDateChange(daterange) {
				console.log(daterange)
				this.dateValue = daterange;
			}
			

		}
	};
</script>
