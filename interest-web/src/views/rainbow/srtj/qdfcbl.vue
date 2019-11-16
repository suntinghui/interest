<!-- 渠道分成详情 -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">

				<Col span="8">日期：
				<Date-picker :value="dateValue"  @on-change='handleDateChange' :clearable="false"  type="month" editable="false" placement="bottom-start" placeholder="选择日期" style="width: 250px"></Date-picker>
				</Col>
				
				<Col span="8" style="display: none;"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>

			</Row>
		</div>
		
		<Spin size="large" fix v-if="showSpin"></Spin>

		<div style="padding: 10px 0;">
			<Table border :columns="columns1" :data="data1" :height="450" :search="true"></Table>
		</div>
		<div style="text-align: right;">
			<Page :total="total" :page-size="pageInfo.pageSize" show-sizer show-total @on-page-size-change="e=>{pageSizeChange(e)}" @on-change="e=>{pageSearch(e)}"></Page>
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
				dateValue: util.lastMonth(new Date()),
				showDetailModel: false,
				detailTitle: '分成详情',
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
						title: "顶级渠道",
						key: "顶级渠道",
						align: "center",
						sortable: true
					},
					{
						title: "全部分成比例(%)",
						key: "全部分成比例",
						align: "center",
						sortable: true
					},
					{
						title: "门店分成比例(%)",
						key: "门店分成比例",
						align: "center",
						sortable: true
					},
					{
						title: "渠道分成比例(%)",
						key: "渠道分成比例",
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
				
				columns2: [{
						title: "日期",
						key: "日期",
						align: "center",
						sortable: true
					},
					{
						title: "门店分成金额",
						key: "门店分成金额",
						align: "center",
						sortable: true
					},
					{
						title: "渠道分成金额",
						key: "渠道分成金额",
						align: "center",
						sortable: true
					}
				],
				data2: []
			};
		},
		mounted() {
			
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
						url: "/rainbow/qdfcbl",
						timeout: 1000 * 60 * 2,
						params: {
							page: e.pageInfo.page,
							pageSize: e.pageInfo.pageSize
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
			
			// 查询详情信息
			queryDetailInfo (rowData) {
				this.showSpin = true;
				
				this.axios({
						method: "get",
						url: "/rainbow/qdfcxq",
						timeout: 1000 * 60 * 2,
						params: {
							filterMap: {
								queryMonth: this.dateValue,
								channelValue:  rowData['顶级渠道']
							}
						},
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))
							
							this.data2 = response.data.data;
							
							this.detailTitle = rowData['顶级渠道']+' ['+ this.dateValue+'] 详情';
							
							this.showDetailModel = true;
							
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
			
			handleDateChange(selDate) {
				this.dateValue = selDate;
			}
			

		}
	};
</script>
