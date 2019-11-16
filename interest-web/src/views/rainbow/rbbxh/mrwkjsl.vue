<!-- 每日未开机设备数量  -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">
		
				<Col span="8">日期：
				<Date-picker :value="dateValue" @on-change='handleDateChange'  :clearable="false"  type="daterange" editable="false" :options="dateOptions"
				 placement="bottom-start" placeholder="选择日期" style="width: 250px"></Date-picker>
				</Col>
		
				<Col span="8">所属地区：
				<Select v-model="selectValue.areaValue" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.areaList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}</Option>
				</Select>
				</Col>
		
				<Col span="8">设备：
				<Select v-model="selectValue.deviceTypeValue" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.deviceTypeList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}</Option>
				</Select>
				</Col>
		
			</Row>
			<Row style="margin-bottom: 25px;">
		
				<Col span="8">渠道：
				<Select v-model="selectValue.channelValue" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.channelList" :value="item.paramValue" :key="item.paramValue">{{ item.paramValue }}</Option>
				</Select>
				</Col>
		
				<Col span="8" style="display: none;">网点：
				<Select v-model="selectValue.shopValue" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.shopList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}
						({{item.paramKey}})</Option>
				</Select>
				</Col>
		
				<Col span="8">网点类型：
				<Select v-model="selectValue.shopTypeValue" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.shopTypeList" :value="item.paramValue" :key="item.paramValue">{{ item.paramValue }}</Option>
				</Select>
				</Col>
		
				<Col span="8" style="text-align: left;"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>
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
				selectValue:{},
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
						key: "dt",
						align: "center",
						sortable: true
					},
					{
						title: "设备类型",
						key: "DDI_Type",
						align: "center",
						sortable: true
					},
					{
						title: "每日未开机设备数量",
						key: "每日未开机设备数量",
						align: "center",
						sortable: true
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
						url: "/rainbow/mrwkjsl",
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
								shopValue: this.selectValue.shopValue,
								shopTypeValue: this.selectValue.shopTypeValue
							}
						}
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
				this.dateValue = daterange;
			}
			

		}
	};
</script>
