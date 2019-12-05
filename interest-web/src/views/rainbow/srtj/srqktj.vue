<!-- 收入情况统计  -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">

				<Col span="10">起止月份：
				<Date-picker :value="startMonth" @on-change='handleStartDateChange' :clearable="false" type="month" editable="false"
				 placement="bottom-start" placeholder="开始月份" style="width: 150px"></Date-picker>
				-
				<Date-picker :value="endMonth" @on-change='handleEndDateChange' :clearable="false" type="month" editable="false"
				 placement="bottom-start" placeholder="截止月份" style="width: 150px"></Date-picker>
				</Col>

				<Col span="8">渠道：
				<Select v-model="selectValue.channelValue" filterable clearable style="width: 250px">
					<Option v-for="item in this.$store.state.param.channelList" :value="item.paramValue" :key="item.paramValue">{{ item.paramValue }}</Option>
				</Select>
				</Col>

				<Col span="4" style="text-align: center;"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>

			</Row>

		</div>

		<Spin size="large" fix v-if="showSpin"></Spin>

		<div style="padding: 10px 0;">
			<Table border :columns="columns1" :data="data1" :height="450" :search="true"></Table>
		</div>

		<!-- 该月份下的每日详情 -->
		<Modal closable scrollable :mask-closable="false" v-model="showDetailModel" width="60%" :title="detailTitle" style="padding-left: 30px; padding-right: 30px;">
			<Table border ref="dayTable" size="small" :columns="columns2" :data="data2" :height="450"></Table>
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
				endMonth: util.lastMonth(new Date()),

				showDetailModel: false,
				detailTitle: "详情",

				selectValue: {},

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
						title: "收入",
						key: "收入",
						sortable: true,
						align: "center"
					},
					{
						title: "操作",
						key: "Action",
						align: "center",
						width: 250,
						render: (h, params) => {
							return [h('Button', {
									props: {
										type: "primary"
									},
									style: {
										margin: '15px'
									},
									on: {
										click: () => {
											this.queryDetailInfo(params.row)
										}
									}
								}, "详情"),
								h('Button', {
									props: {
										type: "primary"
									},
									style: {
										margin: '15px'
									},
									on: {
										click: () => {
											this.downloadData(params.row)
										}
									}
								}, "下载")
							]
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
						title: "收入",
						key: "收入",
						align: "center",
						sortable: true
					}
				],
				data2: []
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
						url: "/rainbow/srqktj",
						timeout: 1000 * 60 * 2,
						params: {
							filterMap: {
								startMonth: this.startMonth,
								endMonth: this.endMonth,
								channelValue: this.selectValue.channelValue,
							}
						}
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))

							this.data1 = response.data.data;
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

			queryDetailInfo(rowData) {
				this.showSpin = true;

				this.axios({
						method: "get",
						url: "/rainbow/srqktjmx",
						timeout: 1000 * 60 * 2,
						params: {
							filterMap: {
								channelValue: rowData['顶级渠道'],
								queryMonth: rowData['月份']
							}
						},
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))

							this.data2 = response.data.data;
							this.showDetailModel = true;

							this.detailTitle = rowData['顶级渠道'] + '  ' + rowData['月份'];

						}.bind(this)
					)
					.catch(function(error) {
						alert(error);
					})
					.finally(function() {
						this.showSpin = false;

					}.bind(this));

			},

			downloadData(rowData) {
				this.showSpin = true;

				this.axios({
						method: "get",
						url: "/rainbow/srqktjmx",
						timeout: 1000 * 60 * 2,
						params: {
							filterMap: {
								channelValue: rowData['顶级渠道'],
								queryMonth: rowData['月份']
							}
						},
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))

							this.data2 = response.data.data;

							this.$refs.dayTable.exportCsv({
								filename: rowData['顶级渠道'] + '_' + rowData['月份'],
								columns: this.columns2,
								data: this.data2
							});

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
				console.log('====' + selMonth)
				this.startMonth = selMonth;
			},

			handleEndDateChange(selMonth) {
				this.endMonth = selMonth;
			}
		},
	};
</script>
