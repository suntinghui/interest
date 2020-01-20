<!-- 机器属性信息  -->
<style>
	.detailDiv {
		margin-top: 0.3125rem;
		margin-bottom: 0.3125rem;
		margin-left: 1.25rem;
	}
	.keyDetail {
		font-size: 14px;
		display:-moz-inline-box;
		display:inline-block;
		width: 5rem;
		margin-top: 0.3125rem;
		margin-bottom: 0.3125rem;
	}
	.valueDetail {
		font-size: 14px;
	}
	
</style>

<template>
	<div style="margin-top: 10px; margin-bottom: 10px;">
		<div style="margin-left: 20px; margin-right: 20px;">
			<Row style="margin-bottom: 25px;">

				<Col span="8">日期：
				<Date-picker :value="dateValue" @on-change='handleDateChange' type="daterange" editable="false" :options="dateOptions"
				 placement="bottom-start" :clearable="false" placeholder="选择日期" style="width: 250px"></Date-picker>
				</Col>

				<Col span="8">设备：
				<Select v-model="selectValue.deviceTypeValue" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.deviceTypeList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}</Option>
				</Select>
				</Col>

				<Col span="8">所属地区：
				<Select v-model="selectValue.areaValue" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.areaList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}</Option>
				</Select>
				</Col>

			</Row>
			<Row style="margin-bottom: 25px;">

				<Col span="8">渠道：
				<Select v-model="selectValue.channelValue" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.channelList" :value="item.paramValue" :key="item.paramValue">{{ item.paramValue }}</Option>
				</Select>
				</Col>

				<Col span="8">网点：
				<Select v-model="selectValue.shopValue" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.shopList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}-{{item.paramKey}}</Option>
				</Select>
				</Col>

				<Col span="8" style="display: none;">网点类型：
				<Select v-model="selectValue.shopTypeValue" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.shopTypeList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}</Option>
				</Select>
				</Col>

				<Col span="8" style="text-align: left;"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>
			</Row>
		</div>

		<Spin size="large" fix v-if="showSpin"></Spin>

		<div style="padding: 10px 0;">
			<Table border :columns="columns_list" :data="dataList"></Table>
		</div>

		<div style="text-align: right;">
			<Page :total="total" :page-size="pageInfo.pageSize" show-sizer show-total @on-page-size-change="e=>{pageSizeChange(e)}"
			 @on-change="e=>{pageSearch(e)}"></Page>
		</div>

		<deviceInfoModal :showModal="showDetailModel" :detailInfo='detailInfo' :transferInfo='transferInfo' :detailTitle="detailTitle" :tabCheck="tabCheck" @closeSpin="closeSpin" ></deviceInfoModal>

	</div>

</template>

<script>
	import util from '../../../util.js'
	import data from '../../../data.js'

	// for axios add finally
	import promiseFinally from 'promise.prototype.finally';
	promiseFinally.shim();

	import deviceInfo from '../../component/deviceInfo'

	export default {
		data() {
			return {
				dateValue: ['2019-12-01', util.dateFormat(new Date())],
				dataList: [], // 列表数据

				showDetailModel: false, // 控制是否显示详情
				detailInfo: {}, // 某条数据下的所有的详情信息
				transferInfo: {},

				selectValue: {},

				tabCheck: "name1",
				showSpin: false,
				detailTitle: '加载中...',
				searchContent: null,
				groupId: [],
				total: 0,
				/*pageInfo实体*/
				pageInfo: {
					page: 0,
					pageSize: 10
				},

				columns_list: [{
						title: "机器编号",
						key: "机器编号",
						align: "center",
						sortable: true,
						width: 200
					},
					{
						title: "网点编号",
						key: "网点编号",
						align: "center",
						sortable: true,
						width: 150
					},
					{
						title: "启用时间",
						key: "启用时间",
						align: "center",
						sortable: true,
						width: 180
					},
					{
						title: "设备类型",
						key: "设备类型",
						align: "center",
						sortable: true,
						width: 120
					},
					{
						title: "设备位置",
						key: "设备位置",
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
									type: "primary"
								},
								on: {
									click: () => {
										this.showDetailInfo(params.row)
									}
								}
							}, "详情")
						}
					}
				],

			};
		},

		components: {
			'deviceInfoModal': deviceInfo
		},

		mounted() {
			// 查询所有的参数
			this.$store.dispatch('queryAllParam');

			/*页面初始化调用方法*/
			this.getDataList({
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
				this.getDataList({
					pageInfo: this.pageInfo
				});

			},

			/*得到列表数据*/
			getDataList(e) {
				this.showSpin = true;

				this.axios({
						method: "get",
						url: "/rainbow/jqsxxx_list",
						timeout: 1000 * 60 * 2,
						params: {
							page: e.pageInfo.page,
							pageSize: e.pageInfo.pageSize,
							filterMap: {
								startDate: this.dateValue[0],
								endDate: this.dateValue[1],
								deviceTypeValue: this.selectValue.deviceTypeValue,
								areaValue: this.selectValue.areaValue,
								channelValue: this.selectValue.channelValue,
								shopValue: this.selectValue.shopValue
							}
						}
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))

							this.total = response.data.data.totalCount;
							this.dataList = response.data.data.data;

						}.bind(this)
					)
					.catch(function(error) {
						alert(error);
					})
					.finally(function() {
						this.showSpin = false;
					}.bind(this));

			},

			/*得到详情数据*/
			showDetailInfo(rowData) {
				this.showDetailModel = false;
				
				this.tabCheck = "name1"; // 默认刚打开时保证总是显示第一个tab

				console.log(JSON.stringify(rowData))

				this.detailInfo = []; // 置空详情数据，否则打开时仍然是上次的数据

				this.transferInfo = [];

				this.queryDetailInfo(rowData['机器编号'], rowData['网点编号']);

				this.queryTransferInfo(rowData['机器编号'], rowData['网点编号']);

			},

			queryDetailInfo(ddiNo, shopNo) {
				this.detailTitle = '加载中...';

				this.showSpin = true;

				this.axios({
						method: "get",
						url: "/rainbow/jqsxxx_detail",
						params: {
							filterMap: {
								ddiNo: ddiNo,
								shopValue: shopNo,
								startDate: this.dateValue[0],
								endDate: this.dateValue[1]
							}
						}
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))

							this.detailTitle = '详情信息';

							this.detailInfo = response.data.data;

							this.showDetailModel = true;

						}.bind(this)
					)
					.catch(function(error) {
						alert(error);
						this.showSpin = false;
					})
					.finally(function() {
						
					}.bind(this));
			},

			queryTransferInfo(ddiNo, shopNo) {
				this.showSpin = true;

				this.axios({
						method: "get",
						url: "/rainbow/jqsxxx_transfer_list",
						params: {
							filterMap: {
								ddiNo: ddiNo,
								shopValue: shopNo,
								startDate: this.dateValue[0],
								endDate: this.dateValue[1]
							}
						}
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))

							this.transferInfo = response.data.data;

						}.bind(this)
					)
					.catch(function(error) {
						alert(error);
						this.showSpin = false;
					})
					.finally(function() {
						
					}.bind(this));
			},


			/*分页点击事件*/
			pageSearch(e) {
				this.pageInfo.page = e - 1;
				this.getDataList({
					pageInfo: this.pageInfo
				});
			},

			// 改变每页显示条数时触发
			pageSizeChange(e) {
				this.pageInfo.pageSize = e;
				this.pageInfo.page = 0;
				this.getDataList({
					pageInfo: this.pageInfo
				});
			},

			handleDateChange(daterange) {
				this.dateValue = daterange;
			},
			
			closeSpin() {
				console.log("============================================")
				this.showSpin = false;
			}, 

		}

	};
</script>
