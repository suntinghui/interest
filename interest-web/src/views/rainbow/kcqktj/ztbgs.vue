<!-- 在途包裹数  -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">
		
				<Col span="8">日期：
				<Date-picker :value="queryDate" @on-change='handleDateChange' type="datetime" editable="false" 
				 placement="bottom-start" placeholder="选择时间" :clearable="false" style="width: 250px"></Date-picker>
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
			<Table border :columns="columns1" :data="data1" :height="350" :search="true"></Table>
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
				queryDate: util.datetimeFormat(new Date()),
				
				showSpin: false,
				date: null,
				searchContent: null,
				groupId: [],
				/*表显示字段*/
				columns1: [{
						title: "设备类型",
						key: "设备类型",
						align: "center"
					},
					{
						title: "在途包裹数",
						key: "在途包裹数",
						align: "center"
					}
				],
				data1: []
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
						url: "/rainbow/ztbgs",
						timeout: 1000 * 60 * 2,
						params: {
							filterMap: {
								queryDate: this.queryDate,
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
			
			handleDateChange(selDate) {
				this.queryDate = selDate;
			}
			
		}
	};
</script>
