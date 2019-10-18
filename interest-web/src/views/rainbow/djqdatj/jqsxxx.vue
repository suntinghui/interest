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
			<Table border :columns="columns1" :data="data1" :height="350"></Table>
		</div>
		<div style="text-align: right;">
			<Page :total="total" :page-size="pageInfo.pageSize" show-elevator show-total @on-change="e=>{pageSearch(e)}"></Page>
		</div>
		
		<Modal closable scrollable
		        v-model="showDetailModel"
				width="60%"
		        title="详情信息" >
				<Tabs value="name1" animated type="card">
				        <Tab-pane label="机器信息" name="name1">
							<div class="detailDiv" v-for="(value, key) in this.detailInfo.shopInfo" :key="key"><span class="keyDetail">{{key}}：</span><span class="valueDetail">{{value}}</span></div>
						</Tab-pane>
						
				        <Tab-pane label="门店信息" name="name2">
							
						</Tab-pane>
						
				        <Tab-pane label="运营状态" name="name3">
							
						</Tab-pane>
						
						<Tab-pane label="维护信息" name="name4">
							
						</Tab-pane>
						<Tab-pane label="交易信息" name="name5">
							
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
				showDetailModel: false,
				detailInfo: {},
				
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
						title: "机器编号",
						key: "ddiNo",
						align: "center"
					},
					{
						title: "机器类型",
						key: "ddiType",
						align: "center",
						sortable: true
					},
					{
						title: "网点地址",
						key: "shopAddress",
						align: "center",
						width: 400
					},
					{
						title: "网点编号",
						key: "shopNo",
						align: "center",
						sortable: true
					},
					{
						title: "操作",
						key: "Action",
						align: "center",
						render: (h, params) => {
							return h('Button', {
								props: {
									type: "primary"
								},
								on:{
									click: () => {
									    this.showDetailInfo(params)
									}
								}
							}, "详情")
						}
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
			/*得到表数据*/
			getTable(e) {
				this.showSpin = true;

				this.axios({
						method: "get",
						url: "/rainbow/jqsxxx",
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
							this.data1 = response.data.data.data;

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
			showDetailInfo (params) {
				this.showDetailModel = true;
				
				this.queryDetailInfo(params.row.shopNo);
				
			},
			queryDetailInfo (currentShopNo) {
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
				
						}.bind(this)
					)
					.catch(function(error) {
						alert(error);
					})
					.finally(function() {
						
					}.bind(this));
			}

		}

	};
</script>
