<!-- 票仓实时余量 -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">

				<Col span="10" style="text-align: left;">当前票仓实时余量统计</Col>

			</Row>

		</div>

		<Spin size="large" fix v-if="showSpin"></Spin>

		<div>
			<Table border :columns="columns1" :data="data1" :height="450" :search="true"></Table>
		</div>

		<Modal closable scrollable :mask-closable="false" v-model="showDetailModel" width="60%" title="票仓实时余量" style="padding-left: 30px; padding-right: 30px;">
			<Table border size="default" :columns="columns2" :data="data2" :height="450"></Table>
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
				dateValue: [util.dateFormat(util.lastWeek(new Date())), util.dateFormat(new Date())],
				showDetailModel: false,

				showSpin: false,
				date: null,
				searchContent: null,
				groupId: [],
				/*表显示字段*/
				columns1: [{
						title: "实时余量",
						key: "实时余量",
						align: "center"
					},
					{
						title: "余票金额",
						key: "余票金额",
						align: "center"
					},
					{
						title: "操作",
						key: "Action",
						align: "center",
						width: 300,
						render: (h, params) => {
							return [h('Button', {
									props: {
										type: "primary"
									},
									on: {
										click: () => {
											this.queryDetailInfo(params.row)
										}
									}
								}, "详情"),
								h('Button', {
									props: {
										type: "info"
									},
									style: {
										margin: '15px'
									},
									on: {
										click: () => {
											this.search()
										}
									}
								}, "刷新")
							]
						}
					}
				],
				data1: [],
				columns2: [{
						title: "仓内票种",
						key: "仓内票种",
						sortable: true,
						align: "center"
					},
					{
						title: "票种金额",
						key: "票种金额",
						sortable: true,
						align: "center"
					},
					{
						title: "余票张数",
						key: "余票张数",
						sortable: true,
						align: "center"
					},
					{
						title: "余票金额",
						key: "余票金额",
						sortable: true,
						align: "center"
					}
				],
				data2: []
			};
		},
		mounted() {

			/*页面初始化调用方法*/
			this.search();
		},
		methods: {
			search() {
				this.showSpin = true;

				this.axios({
						method: "get",
						url: "/rainbow/pcssyl",
						timeout: 1000 * 60 * 2,
						params: {

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

			queryDetailInfo(rowData) {
				this.showSpin = true;

				this.axios({
						method: "get",
						url: "/rainbow/pcssylxq",
						timeout: 1000 * 60 * 2,
						params: {
							filterMap: {
								startDate: this.dateValue[0],
								endDate: this.dateValue[1],
							}
						}
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))

							this.data2 = response.data.data;

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

		}
	};
</script>
