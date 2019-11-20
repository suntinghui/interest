<!-- 单机日销平均  -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">
		
				<Col span="8">日期：
				<Date-picker :value="dateValue" @on-change='handleDateChange' :clearable="false"  type="daterange" editable="false" :options="dateOptions"
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
					<Option v-for="item in this.$store.state.param.shopList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}-{{item.paramKey}}</Option>
				</Select>
				</Col>
		
				<Col span="8" >网点类型：
				<Select v-model="selectValue.shopTypeValue" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.shopTypeList" :value="item.paramValue" :key="item.paramValue">{{ item.paramValue }}</Option>
				</Select>
				</Col>
				
				<Col span="8" style="text-align: left;"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>
			</Row>
		</div>

		<Spin size="large" fix v-if="showSpin"></Spin>

		<div style="padding: 10px 0;">
			<Table border :columns="columns1" :data="data1" :height="350" :search="true"></Table>
		</div>
		
		<div style="margin-top: 0.3125rem;text-align: right;">
			备注：2019年8月14日前无数据
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
				dateValue: [util.dateFormat(util.lastWeek(new Date())), util.dateFormat(new Date())],
				selectValue:{},
				
				showSpin: false,
				searchContent: null,
				groupId: [],
				/*表显示字段*/
				columns1: [{
						title: "指标",
						key: "title",
						align: "center"
					},
					{
						title: "数值（单位：元）",
						key: "value",
						align: "center"
					}
				],
				data1: [],
				dateOptions: {
					shortcuts: [{
							text: '最近一周',
							value() {
								const end = new Date();
								const start = new Date();
								start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
								return [start, end];
							}
						},
						{
							text: '最近一个月',
							value() {
								const end = new Date();
								const start = new Date();
								start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
								return [start, end];
							}
						},
						{
							text: '最近三个月',
							value() {
								const end = new Date();
								const start = new Date();
								start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
								return [start, end];
							}
						}
					]
				}
			};
		},
		mounted() {
			// 查询所有的参数
			this.$store.dispatch('queryAllParam');
			
			/*页面初始化调用方法*/
			this.search();
		},
		methods: {
			search() {
				this.showSpin = true;

				this.axios({
						method: "get",
						url: "/rainbow/djrxpj",
						timeout: 1000 * 60 * 2,
						params: {
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
							
							if (response.data.data != null) {
								this.data1 = [{
									"title": "日均销售额",
									"value": util.numFixed(response.data.data['在网设备日均销售额'])
								},{
									"title": "开机日均销售额",
									"value": util.numFixed(response.data.data['开机在网设备日均单台销额'])
								}];
							} else {
								this.data1 = [{
									"title": "日均销售额",
									"value": "0.00"
								},{
									"title": "开机日均销售额",
									"value": "0.00"
								}];
							}
							
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
				console.log(daterange)
				this.dateValue = daterange;
			}


		}
	};
</script>
