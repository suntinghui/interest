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
	.subTitle{
		font-size: 14px;
		margin-top: 1.25rem;
		margin-bottom: 0.3125rem;
		font-weight: 600;
	}
</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">

				<Col span="8">日期：
				<DatePicker v-model="dateModel" type="date" placeholder="选择日期" style="width: 250px"></DatePicker>
				</Col>

				<Col span="8">设备：
				<Select v-model="deviceModel" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.deviceTypeList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}</Option>
				</Select>
				</Col>

				<Col span="8">所属地区：
				<Select v-model="areaModel" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.areaList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}</Option>
				</Select>
				</Col>

			</Row>
			<Row style="margin-bottom: 25px;">

				<Col span="8">渠道：
				<Select v-model="channelModel" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.channelList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}</Option>
				</Select>
				</Col>

				<Col span="8">网点：
				<Select v-model="shopModel" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.shopList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}
						({{item.paramKey}})</Option>
				</Select>
				</Col>

				<Col span="8">网点类型：
				<Select v-model="shopTypeModel" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.shopTypeList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}</Option>
				</Select>
				</Col>
			</Row>

			<Row style="margin-bottom: 25px; text-align: right;">
				<Col span="22"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>
			</Row>
		</div>

		<Spin size="large" fix v-if="showSpin"></Spin>

		<div style="padding: 10px 0;">
			<Table border :columns="columns0" :data="dataList" :height="350"></Table>
		</div>
		<div style="text-align: right;">
			<Page :total="total" :page-size="pageInfo.pageSize" show-sizer show-total @on-page-size-change="e=>{pageSizeChange(e)}" @on-change="e=>{pageSearch(e)}"></Page>
		</div>

		<Modal closable scrollable :mask-closable="false" v-model="showDetailModel" width="60%" title="详情信息">
			<Tabs :value="tabCheck" v-model="tabCheck" :animated="true" type="card">
				<Tab-pane label="机器信息" name="name1">
					<div class="detailDiv" v-for="(value, key) in this.detailInfo.deviceInfo" :key="key"><span class="keyDetail">{{key}}：</span><span
						 class="valueDetail">{{value}}</span></div>
				</Tab-pane>

				<Tab-pane label="门店信息" name="name2">
					<div class="detailDiv" v-for="(value, key) in this.detailInfo.shopInfo" :key="key"><span class="keyDetail">{{key}}：</span><span
						 class="valueDetail">{{value}}</span></div>
				</Tab-pane>

				<Tab-pane label="运营状态" name="name3">
					<Table border size="small" :columns="columns31" :data="data31"></Table>
				</Tab-pane>

				<Tab-pane label="维护信息" name="name4">

				</Tab-pane>
				<Tab-pane label="交易信息" name="name5" style="height:400px;overflow-y:auto;overflow-x:hidden;">
					<p class="subTitle">销售</p>
					<Table border size="small" :columns="columns51" :data="data51"></Table>

					<p class="subTitle">退款</p>
					<Table border size="small" :columns="columns52" :data="data52"></Table>

					<p class="subTitle">退款订单比率</p>
					<Table border size="small" :columns="columns53" :data="data53"></Table>

					<p class="subTitle">当日销售</p>
					<Table border size="small" :columns="columns54" :data="data54"></Table>

					<p class="subTitle">当日退款</p>
					<Table border size="small" :columns="columns55" :data="data55"></Table>

					<p class="subTitle">当日票种数量</p>
					<Table border size="small" :columns="columns56" :data="data56"></Table>

				</Tab-pane>
			</Tabs>

			<div slot="footer"></div>
		</Modal>
	</div>

</template>


<script>
	// for axios add finally
	import promiseFinally from 'promise.prototype.finally';
	promiseFinally.shim();

	export default {
		data() {
			return {
				showDetailModel: false, // 控制是否显示详情
				detailInfo: {}, // 某条数据下的所有的详情信息
				tabCheck: "name1",

				showSpin: false,
				searchContent: null,
				groupId: [],
				total: 0,
				/*pageInfo实体*/
				pageInfo: {
					page: 0,
					pageSize: 10
				},
				/*表显示字段*/
				columns0: [{
						title: "机器编号",
						key: "机器编号",
						align: "center"
					},
					{
						title: "网点编号",
						key: "网点编号",
						align: "center",
						sortable: true,
						width:150
					},
					{
						title: "启用时间",
						key: "启用时间",
						align: "center",
						sortable: true
					},
					{
						title: "设备类型",
						key: "设备类型",
						align: "center",
						sortable: true,
						width:120
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
						width:150,
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
				dataList: [],
				columns31: [],
				data31: [],
				columns51: [{
						title: "累计销售金额（元）",
						key: "累计销售金额（元）",
						align: "center"
					},
					{
						title: "累计销售票数（张）",
						key: "累计销售票数（张）",
						align: "center"
					},
					{
						title: "累计订单数（单）",
						key: "累计订单数（单）",
						align: "center"
					}
				],
				data51: [{
					"累计销售金额（元）": "100",
					"累计销售票数（张）": "2",
					"累计订单数（单）": "30",
				}],

				columns52: [{
						title: "累计退款订单数",
						key: "累计退款订单数",
						align: "center"
					},
					{
						title: "累计退款额",
						key: "累计退款额",
						align: "center"
					},
					{
						title: "累计退款人数",
						key: "累计退款人数",
						align: "center"
					}
				],
				data52: [{
					"累计退款订单数": "300",
					"累计退款额": "1000",
					"累计退款人数": "520",
				}],

				columns53: [{
					title: "退款订单比率",
					key: "退款订单比率",
					align: "center"
				}],
				data53: [{
					"退款订单比率": "30%",
				}],

				columns54: [{
					title: "当日销售额（元）",
					key: "当日销售额（元）",
					align: "center"
				}, {
					title: "当日销售票数（张）",
					key: "当日销售票数（张）",
					align: "center"
				}, {
					title: "当日订单数（单）",
					key: "当日订单数（单）",
					align: "center"
				}, {
					title: "当日最大订单额度",
					key: "当日最大订单额度",
					align: "center"
				}],
				data54: [{
					"当日销售额（元）": "3000",
					"当日销售票数（张）": "200",
					"当日订单数（单）": "230",
					"当日最大订单额度": "7800"
				}],

				columns55: [{
					title: "当日退款订单数",
					key: "当日退款订单数",
					align: "center"
				}, {
					title: "当日退款额",
					key: "当日退款额",
					align: "center"
				}, {
					title: "当日退款人数",
					key: "当日退款人数",
					align: "center"
				}],
				data55: [{
					"当日退款订单数": "100",
					"当日退款额": "200",
					"当日退款人数": "800"
				}],

				columns56: [{
					title: "票种名称",
					key: "票种名称",
					align: "center"
				}, {
					title: "票种单价",
					key: "票种单价",
					align: "center"
				}, {
					title: "累计销售张数",
					key: "累计销售张数",
					align: "center"
				}, {
					title: "累计销售金额",
					key: "累计销售金额",
					align: "center"
				}],
				data56: [{
					"票种名称": "五元票",
					"票种单价": "5",
					"累计销售张数": "1200",
					"累计销售金额": "6000"
				}, {
					"票种名称": "十元票",
					"票种单价": "10",
					"累计销售张数": "500",
					"累计销售金额": "5000"
				}],

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
			/*得到表数据*/
			getTable(e) {
				this.showSpin = true;

				this.axios({
						method: "get",
						url: "/rainbow/jqsxxx",
						timeout: 1000 * 60 * 2,
						params: {
							searchContent: this.searchContent,
							page: e.pageInfo.page,
							pageSize: e.pageInfo.pageSize
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
			
			search() {
				this.initPageInfo();
				this.getTable({
					pageInfo: this.pageInfo
				});
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
			
			showDetailInfo(rowData) {
				this.tabCheck = "name1"; // 默认刚打开时保证总是显示第一个tab

				console.log(JSON.stringify(rowData))

				this.showDetailModel = true;

				this.queryDetailInfo(rowData.shopNo);

			},
			queryDetailInfo(currentShopNo) {
				this.axios({
						method: "get",
						url: "/rainbow/mdsxxx",
						params: {
							shopNo: currentShopNo
						}
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))

							this.detailInfo = response.data.data;

							this.showYunyingInfo()


						}.bind(this)
					)
					.catch(function(error) {
						alert(error);
					})
					.finally(function() {

					}.bind(this));
			},
			showYunyingInfo() {
				this.data31 = [{
					"设备编号": "0001",
					"网点编号": "A1001",
					"设备启用时间": "2019-10-01",
					"网点申请时间": "2019-10-21",
					"设备配送时间": "2019-10-23",
				}];

				// 通过对数据循环的方式得到columns。注意值是否全的问题。执行一次即可break。
				this.data31.forEach(item => {
					this.columns31 = [];
					for (let [key, value] of Object.entries(item)) {
						this.columns31.push({
							"title": key,
							"key": key,
							"align": "center",
							"fixed": key=="设备编号"?"left":""
						})
					}
				})
			}

		}

	};
</script>
