<!-- 退款情况统计合计  -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">
				
				<Col span="10">起止月份：
				<Date-picker :value="startMonth"  @on-change='handleStartDateChange'  :clearable="false"  type="month" editable="false"  placement="bottom-start" placeholder="开始月份" style="width: 150px"></Date-picker>
				至
				<Date-picker :value="endMonth"  @on-change='handleEndDateChange'  :clearable="false"  type="month" editable="false" placement="bottom-start" placeholder="截止月份" style="width: 150px"></Date-picker>
				</Col>
				
				
				<Col span="4" style="text-align: center;"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>

			</Row>
			
		</div>
		
		<Spin size="large" fix v-if="showSpin"></Spin>

		<div style="padding: 10px 0;">
			<Table border :columns="columns1" :data="data1" :height="450" :search="true"></Table>
		</div>
		
		<!-- 月份统计 -->
		<Modal closable scrollable :mask-closable="false" v-model="showMonthDetailModel" width="60%" :title="monthTitle" style="padding-left: 30px; padding-right: 30px;">
			<Table border size="default" :columns="columns2" :data="data2" :no-data-text="noDataTips" :height="450" ></Table>
			<div slot="footer"></div>
		</Modal>
		
		<!-- 按日统计 -->
		<Modal closable scrollable :mask-closable="false" v-model="showDayDetailModel" width="60%" :title="dayTitle" style="padding-left: 30px; padding-right: 30px;">
			<Table border size="default" :columns="columns3" :data="data3" :no-data-text="noDataTips" :height="450" ></Table>
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
				startMonth: util.lastMonth(new Date()),
				endMonth: util.dateFormat(new Date()),
				
				showMonthDetailModel: false,
				monthTitle: '详情',
				
				showDayDetailModel: false,
				dayTitle: '详情',
				
				noDataTips: '暂无数据',
				
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
						title: "退款",
						key: "退款",
						sortable: true,
						align: "center"
					},
					{
						title: "操作",
						key: "Action",
						align: "center",
						width: 150,
						render: (h, params) => {
							return h('Button', {
								props: {
									type: "primary",
								},
								on: {
									click: () => {
										this.queryMonthDetailInfo(params.row)
									}
								}
							}, "详情")
						}
					}
				],
				data1: [],
				columns2: [{
						title: "顶级渠道",
						key: "顶级渠道",
						align: "center",
						sortable: true
					},
					{
						title: "月份",
						key: "月份",
						align: "center",
						sortable: true
					},
					{
						title: "退款",
						key: "退款",
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
									type: "primary",
								},
								on: {
									click: () => {
										this.queryDayDetailInfo(params.row)
									}
								}
							}, "详情")
						}
					}
				],
				data2: [],
				columns3: [{
						title: "顶级渠道",
						key: "顶级渠道",
						align: "center",
						sortable: true
					},
					{
						title: "日期",
						key: "日期",
						align: "center",
						sortable: true
					},
					{
						title: "退款",
						key: "退款",
						align: "center",
						sortable: true
					}
				],
				data3: []
			};
		},
		
		mounted() {
			
			/*页面初始化调用方法*/
			this.search();
		},
		methods: {
			search() {
				this.showSpin = true;

				// 合计
				this.axios({
						method: "get",
						url: "/rainbow/tkqktjhj",
						timeout: 1000 * 60 * 2,
						params: {
							filterMap: {
								startMonth: this.startMonth,
								endMonth: this.endMonth,
							}
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
			
			queryMonthDetailInfo (rowData) {
				
				this.monthTitle = "加载中...";
				this.noDataTips = "正在加载数据，请稍候";
				this.data2 = [];
				this.showMonthDetailModel = true;
				
				// 按月
				this.axios({
						method: "get",
						url: "/rainbow/tkqktjy",
						timeout: 1000 * 60 * 2,
						params: {
							filterMap: {
								startMonth: rowData['月份'],
								endMonth: rowData['月份']
							}
						},
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))
				
							this.data2 = response.data.data;
							
							this.monthTitle = rowData['月份']
							
						}.bind(this)
					)
					.catch(function(error) {
						alert(error);
					})
					.finally(function() {
						this.noDataTips = "暂无数据";
						
					}.bind(this));
			},
			
			queryDayDetailInfo (rowData) {
				
				this.dayTitle = "加载中...";
				this.noDataTips = "正在加载数据，请稍候";
				this.data3 = [];
				this.showDayDetailModel = true;
				
				// 按日
				this.axios({
						method: "get",
						url: "/rainbow/tkqktjr",
						timeout: 1000 * 60 * 2,
						params: {
							filterMap: {
								queryMonth: rowData['月份'],
								channelValue: rowData['顶级渠道']
							}
						},
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))
				
							this.data3 = response.data.data;
							
							this.dayTitle = rowData['顶级渠道']+'  '+rowData['月份']
							
						}.bind(this)
					)
					.catch(function(error) {
						alert(error);
					})
					.finally(function() {
						this.noDataTips = "暂无数据";
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
