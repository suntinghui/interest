<!-- 销售额情况统计（按月）  -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">
				
				<Col span="10">起止月份：
				<Date-picker :value="startMonth"  @on-change='handleStartDateChange' type="month" editable="false"  placement="bottom-start" placeholder="开始月份" style="width: 150px"></Date-picker>
				-
				<Date-picker :value="endMonth"  @on-change='handleEndDateChange' type="month" editable="false" placement="bottom-start" placeholder="截止月份" style="width: 150px"></Date-picker>
				</Col>
				
				<Col span="8"  style="display: none;">渠道：
				<Select v-model="channelModel"  filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.channelList" :value="item.paramKey" :key="item.paramKey">{{ item.paramValue }}</Option>
				</Select>
				</Col>

				<Col span="4" style="text-align: center;"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>

			</Row>
			
		</div>
		
		<Spin size="large" fix v-if="showSpin"></Spin>

		<div style="padding: 10px 0;">
			<Table border :columns="columns1" :data="data1" :height="450" :search="true"></Table>
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
				startMonth: util.lastMonth(new Date()),
				endMonth: util.dateFormat(new Date()),
				showSpin: false,
				date: null,
				searchContent: null,
				groupId: [],
				/*表显示字段*/
				columns1: [{
						title: "顶级渠道",
						key: "顶级渠道",
						sortable: true,
						align: "center"
					},
					{
						title: "月份",
						key: "月份",
						sortable: true,
						align: "center"
					},
					{
						title: "销售额",
						key: "销售额",
						sortable: true,
						align: "center"
					}
				],
				data1: []
			};
		},
		mounted() {
			// 查询所有的参数
			this.$store.dispatch('queryParam', 'queryChannelList');
			
			/*页面初始化调用方法*/
			this.search();
		},
		methods: {
			search() {
				this.showSpin = true;

				this.axios({
						method: "get",
						url: "/rainbow/xsetjy",
						timeout: 1000 * 60 * 2,
						params: {
							startMonth: this.startMonth,
							endMonth: this.endMonth
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
			
			handleStartDateChange(selMonth) {
				this.startMonth = selMonth;
			},
			
			handleEndDateChange(selMonth) {
				this.endMonth = selMonth;
			}
			

		}
	};
</script>
