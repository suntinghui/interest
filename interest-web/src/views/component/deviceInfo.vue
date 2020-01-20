<template>
	<Modal v-model="showModal" @on-visible-change="visibleChanged" closable scrollable :mask-closable="false" width="60%" :title="detailTitle">
		<Tabs :value="tabCheck" v-model="tabCheck" :animated="true" type="card">
			<Tab-pane label="机器信息" name="name1" style="height:400px;overflow-y:auto;overflow-x:hidden; padding-left: 20px; padding-right: 20px;">
				<Table border size="small" :columns="columns_jqsxxx" :data="this.detailInfo.jqsxxx"></Table>
			</Tab-pane>

			<Tab-pane label="门店信息" name="name2" style="height:400px;overflow-y:auto;overflow-x:hidden; padding-left: 20px; padding-right: 20px;">
				<Table border size="small" :columns="columns_mdsxxx" :data="this.detailInfo.mdsxxx"></Table>
			</Tab-pane>

			<Tab-pane label="运营状态" name="name3" style="height:400px;overflow-y:auto;overflow-x:hidden; padding-left: 20px; padding-right: 20px;">
				<p class="subTitle">运营状态1</p>
				<Table border size="small" :columns="columns_yyzt1" :data="this.detailInfo.yyzt1"></Table>
				<p class="subTitle">运营状态2</p>
				<Table border size="small" :columns="columns_yyzt2" :data="this.detailInfo.yyzt2"></Table>
				<p class="subTitle">机器获客总人数</p>
				<Table border size="small" :columns="columns_yyzt3_jqhkzrs" :data="this.detailInfo.yyzt3_jqhkzrs"></Table>
				<p class="subTitle">机器日均购彩人数</p>
				<Table border size="small" :columns="columns_yyzt3_jqrjgcrs" :data="this.detailInfo.yyzt3_jqrjgcrs"></Table>
				<p class="subTitle">机器日均新购彩人数</p>
				<Table border size="small" :columns="columns_yyzt3_jqrjxgcrs" :data="this.detailInfo.yyzt3_jqrjxgcrs"></Table>
				<p class="subTitle">机器日均复购人数</p>
				<Table border size="small" :columns="columns_yyzt3_jqrjfgrs" :data="this.detailInfo.yyzt3_jqrjfgrs"></Table>
			</Tab-pane>

			<Tab-pane label="维护信息" name="name4" style="height:400px;overflow-y:auto;overflow-x:hidden; padding-left: 20px; padding-right: 20px;">
				<p class="subTitle">维护信息1</p>
				<Table border size="small" :columns="columns_sbwhtj3" :data="this.detailInfo.sbwhtj3"></Table>
				<p class="subTitle">维护信息2</p>
				<Table border size="small" :columns="columns_sbwhtj4" :data="this.detailInfo.sbwhtj4"></Table>
				<p class="subTitle">维护信息3</p>
				<Table border size="small" :columns="columns_sbwhtj5" :data="this.detailInfo.sbwhtj5"></Table>
			</Tab-pane>
			<Tab-pane label="交易信息" name="name5" style="height:400px;overflow-y:auto;overflow-x:hidden; padding-left: 20px; padding-right: 20px;">
				<p class="subTitle">销售</p>
				<Table border size="small" :columns="columns_sbjyxx_xs" :data="this.detailInfo.sbjyxx_xs"></Table>

				<p class="subTitle">退款</p>
				<Table border size="small" :columns="columns_sbjyxx_tk" :data="this.detailInfo.sbjyxx_tk"></Table>

				<p class="subTitle">退款订单比率</p>
				<Table border size="small" :columns="columns_sbjyxx_tkddbl" :data="this.detailInfo.sbjyxx_tkddbl"></Table>

				<p class="subTitle">当日销售</p>
				<Table border size="small" :columns="columns_sbjyxx_drxs" :data="this.detailInfo.sbjyxx_drxs"></Table>

				<p class="subTitle">当日退款</p>
				<Table border size="small" :columns="columns_sbjyxx_drtk" :data="this.detailInfo.sbjyxx_drtk"></Table>

				<p class="subTitle">当日票种数量</p>
				<Table border size="small" :columns="columns_sbjyxx_drpzxl" :data="this.detailInfo.sbjyxx_drpzxl"></Table>

			</Tab-pane>

			<Tab-pane label="交易统计" name="name6" style="height:400px;overflow-y:auto;overflow-x:hidden; padding-left: 20px; padding-right: 20px;">
				<div style="width: 800px; height:400px;" ref="chart" id="chart"></div>
			</Tab-pane>
		</Tabs>


		<div slot="footer"></div>
	</Modal>
</template>

<script>
	import util from '../../util.js'
	import data from '../../data.js'

	// for axios add finally
	import promiseFinally from 'promise.prototype.finally';
	promiseFinally.shim();

	export default {
		data() {
			return {
				// 机器属性信息
				columns_jqsxxx: [{
						title: "机器编号",
						key: "机器编号",
						align: "center"
					},
					{
						title: "网点编号",
						key: "网点编号",
						align: "center"
					},
					{
						title: "启用时间",
						key: "启用时间",
						align: "center"
					},
					{
						title: "设备位置",
						key: "设备位置",
						align: "center",
						width: 300
					},
					{
						title: "设备类型",
						key: "设备类型",
						align: "center"
					}
				],

				// 门店属性信息
				columns_mdsxxx: [{
						title: "网点编号",
						key: "网点编号",
						align: "center",
						width: 180,
					},
					{
						title: "网点名称",
						key: "网点名称",
						align: "center",
						width: 180,
					},
					{
						title: "详细地址",
						key: "详细地址",
						align: "center",
						width: 180,
					},
					{
						title: "所属区域",
						key: "所属区域",
						align: "center",
						width: 180,
					},
					{
						title: "GIS位置",
						key: "GIS位置",
						align: "center",
						width: 180,
					},
					{
						title: "门店类型",
						key: "门店类型",
						align: "center",
						width: 180,
					},
					{
						title: "门店每日人流量",
						key: "门店每日人流量",
						align: "center",
						width: 180,
					},
					{
						title: "人均消费",
						key: "人均消费",
						align: "center",
						width: 180,
					},
					{
						title: "距公司距离",
						key: "距公司距离",
						align: "center",
						width: 180,
					},
					{
						title: "所属商圈",
						key: "所属商圈",
						align: "center",
						width: 180,
					},
					{
						title: "网点开门时间",
						key: "网点开门时间",
						align: "center",
						width: 180,
					},
					{
						title: "网点关门时间",
						key: "网点关门时间",
						align: "center",
						width: 180,
					},
					{
						title: "所属区域经理",
						key: "所属区域经理",
						align: "center",
						width: 180,
					},
					{
						title: "撤店时间",
						key: "撤店时间",
						align: "center",
						width: 180,
					}
				],

				// 运营状态信息-1
				columns_yyzt1: [{
						title: "设备编号",
						key: "设备编号",
						align: "center",
						width: 180,
					},
					{
						title: "网点编号",
						key: "网点编号",
						align: "center",
						width: 180,
					},
					{
						title: "设备启用时间",
						key: "设备启用时间",
						align: "center",
						width: 180,
					},
					{
						title: "网点申请时间",
						key: "网点申请时间",
						align: "center",
						width: 180,
					},
					{
						title: "设备撤出时间",
						key: "设备撤出时间",
						align: "center",
						width: 180,
					},
					{
						title: "设备目前状态",
						key: "设备目前状态",
						align: "center",
						width: 180,
					},
					{
						title: "目前门店状态",
						key: "目前门店状态",
						align: "center",
						width: 180,
					},
					{
						title: "所属渠道",
						key: "所属渠道",
						align: "center",
						width: 180,
					},
					{
						title: "合作类型",
						key: "合作类型",
						align: "center",
						width: 180,
					}
				],

				// 运营状态信息-2
				columns_yyzt2: [{
						title: "机器编号",
						key: "机器编号",
						align: "center"
					},
					{
						title: "网点编号",
						key: "网点编号",
						align: "center"
					},
					{
						title: "启用时间",
						key: "启用时间",
						align: "center"
					},
					{
						title: "设备累计开机时间（时）",
						key: "设备累计开机时间（时）",
						align: "center"
					},
					{
						title: "累计开机天数",
						key: "累计开机天数",
						align: "center"
					},
					{
						title: "日均开机时长（小时）",
						key: "日均开机时长（小时）",
						align: "center"
					}
				],

				// 运营状态信息-3   机器获客总人数
				columns_yyzt3_jqhkzrs: [{
						title: "设备编号",
						key: "DDI_No",
						align: "center"
					},
					{
						title: "网点编号",
						key: "SHOP_No",
						align: "center"
					},
					{
						title: "启用时间",
						key: "启用时间",
						align: "center"
					},
					{
						title: "机器获客总人数",
						key: "机器获客总人数",
						align: "center"
					}
				],


				//  运营状态信息-3   机器日均购彩人数
				columns_yyzt3_jqrjgcrs: [{
						title: "机器编号",
						key: "机器编号",
						align: "center"
					},
					{
						title: "网点编号",
						key: "网点编号",
						align: "center"
					},
					{
						title: "启用时间",
						key: "启用时间",
						align: "center"
					},
					{
						title: "累计购彩人数",
						key: "累计购彩人数",
						align: "center"
					},
					{
						title: "查询时段内运营天数",
						key: "查询时段内运营天数",
						align: "center"
					},
					{
						title: "机器日均购彩人数",
						key: "机器日均购彩人数",
						align: "center"
					}
				],

				//  运营状态信息-3   机器日均新购彩人数
				columns_yyzt3_jqrjxgcrs: [{
						title: "机器编号",
						key: "机器编号",
						align: "center"
					},
					{
						title: "网点编号",
						key: "网点编号",
						align: "center"
					},
					{
						title: "启用时间",
						key: "启用时间",
						align: "center"
					},
					{
						title: "新用户总数",
						key: "新用户总数",
						align: "center"
					},
					{
						title: "查询时段内运营天数",
						key: "查询时段内运营天数",
						align: "center"
					},
					{
						title: "机器日均新购彩人数",
						key: "机器日均新购彩人数",
						align: "center"
					}
				],


				//  运营状态信息-3   机器日均复购人数
				columns_yyzt3_jqrjfgrs: [{
						title: "机器编号",
						key: "机器编号",
						align: "center"
					},
					{
						title: "网点编号",
						key: "网点编号",
						align: "center"
					},
					{
						title: "启用时间",
						key: "启用时间",
						align: "center"
					},
					{
						title: "复购用户总数",
						key: "复购用户总数",
						align: "center"
					},
					{
						title: "查询时段内运营天数",
						key: "查询时段内运营天数",
						align: "center"
					},
					{
						title: "机器日均复购人数",
						key: "机器日均复购人数",
						align: "center"
					}
				],

				//  设备维护统计3
				columns_sbwhtj3: [{
						title: "加仓时间",
						key: "加仓时间",
						align: "center",
						width: 180,
					},
					{
						title: "出库日期",
						key: "出库日期",
						align: "center",
						width: 180,
					},
					{
						title: "设备",
						key: "设备",
						align: "center",
						width: 180,
					},
					{
						title: "网点编号",
						key: "网点编号",
						align: "center",
						width: 180,
					},
					{
						title: "启用时间",
						key: "启用时间",
						align: "center",
						width: 180,
					},
					{
						title: "出库包裹号",
						key: "出库包裹号",
						align: "center",
						width: 180,
					},
					{
						title: "彩票名称",
						key: "彩票名称",
						align: "center",
						width: 180,
					},
					{
						title: "加票额度（元）",
						key: "加票额度（元）",
						align: "center",
						width: 180,
					},
					{
						title: "加票张数",
						key: "加票张数",
						align: "center",
						width: 180,
					},
					{
						title: "姓名",
						key: "姓名",
						align: "center",
						width: 180,
					}
				],

				//  设备维护统计4
				columns_sbwhtj4: [{
						title: "设备编码",
						key: "设备编码",
						align: "center"
					},
					{
						title: "网点编码",
						key: "网点编码",
						align: "center"
					},
					{
						title: "机头编号",
						key: "机头编号",
						align: "center"
					},
					{
						title: "启用时间",
						key: "启用时间",
						align: "center"
					},
					{
						title: "仓内票种",
						key: "仓内票种",
						align: "center"
					},
					{
						title: "票种金额",
						key: "票种金额",
						align: "center"
					},
					{
						title: "实时余量",
						key: "实时余量",
						align: "center"
					}
				],

				// 设备维护统计5 
				columns_sbwhtj5: [{
						title: "设备",
						key: "设备",
						align: "center"
					},
					{
						title: "票仓",
						key: "票仓",
						align: "center"
					},
					{
						title: "加仓次数",
						key: "加仓次数",
						align: "center"
					}
				],

				// 设备交易信息-销售
				columns_sbjyxx_xs: [{
						title: "设备编号",
						key: "设备编号",
						align: "center"
					},
					{
						title: "网点编号",
						key: "网点编号",
						align: "center"
					},
					{
						title: "启用时间",
						key: "启用时间",
						align: "center"
					},
					{
						title: "累计销售额（元）",
						key: "累计销售额（元）",
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

				// 设备交易信息-退款
				columns_sbjyxx_tk: [{
						title: "设备编号",
						key: "设备编号",
						align: "center"
					},
					{
						title: "网点编号",
						key: "网点编号",
						align: "center"
					},
					{
						title: "启动时间",
						key: "启动时间",
						align: "center"
					},
					{
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


				// 设备交易信息-退款订单比率
				columns_sbjyxx_tkddbl: [{
						title: "设备编号",
						key: "设备编号",
						align: "center"
					},
					{
						title: "网点编号",
						key: "网点编号",
						align: "center"
					},
					{
						title: "启动时间",
						key: "启动时间",
						align: "center"
					},
					{
						title: "退款订单比率",
						key: "退款订单比率",
						align: "center"
					}
				],


				// 设备交易信息-当日销售
				columns_sbjyxx_drxs: [{
						title: "设备编号",
						key: "设备编号",
						align: "center",
						width: 180
					},
					{
						title: "网点编号",
						key: "网点编号",
						align: "center"
					},
					{
						title: "启动时间",
						key: "启动时间",
						align: "center"
					},
					{
						title: "当日销售额（元）",
						key: "当日销售额（元）",
						align: "center"
					},
					{
						title: "当日销售票数（张）",
						key: "当日销售票数（张）",
						align: "center"
					},
					{
						title: "当日订单数（单）",
						key: "当日订单数（单）",
						align: "center"
					},
					{
						title: "当日最大订单额度",
						key: "当日最大订单额度",
						align: "center"
					}
				],

				// 设备交易信息-当日退款
				columns_sbjyxx_drtk: [{
						title: "设备编号",
						key: "设备编号",
						align: "center",
						width: 180
					},
					{
						title: "网点编号",
						key: "网点编号",
						align: "center"
					},
					{
						title: "启动时间",
						key: "启动时间",
						align: "center"
					},
					{
						title: "当日退款订单数",
						key: "当日退款订单数",
						align: "center"
					},
					{
						title: "当日退款额",
						key: "当日退款额",
						align: "center"
					},
					{
						title: "当日退款人数",
						key: "当日退款人数",
						align: "center"
					}
				],

				// 设备交易信息-当日票种销量
				columns_sbjyxx_drpzxl: [{
						title: "设备编号",
						key: "设备编号",
						align: "center",
						width: 180
					},
					{
						title: "网点编号",
						key: "网点编号",
						align: "center"
					},
					{
						title: "启用时间",
						key: "启用时间",
						align: "center"
					},
					{
						title: "票种名称",
						key: "票种名称",
						align: "center"
					},
					{
						title: "票种单价",
						key: "票种单价",
						align: "center"
					},
					{
						title: "累计销售张数",
						key: "累计销售张数",
						align: "center"
					},
					{
						title: "累计销售金额",
						key: "累计销售金额",
						align: "center"
					}
				],
			}
		},

		props: {
			detailInfo: {
				type: Object,
				default: {}
			},
			transferInfo: {
				type: Object,
				default: {}
			},
			showModal: {
				type: Boolean,
				default: false
			},
			detailTitle: {
				type:String, 
				default: '加载中...'
			},
			tabCheck: {
				type: String,
				default: 'name1'
			}
		},
		
		mounted(){
			this.loadCharts()
		},

		methods: {
			visibleChanged(e) {
				if (e) {
					this.$emit('closeSpin')
					this.loadCharts();
				}
			},
			
			loadCharts() {
				var echarts = require('echarts/lib/echarts');

				require('echarts/lib/chart/scatter')
				require('echarts/lib/component/title')
				require('echarts/lib/component/dataZoom')

				let myChart = echarts.init(document.getElementById('chart'));

				var data = [];

				for (var i = 0; i < this.transferInfo.list.length; i++) {
					var item = this.transferInfo.list[i]
					var obj = [item['订单时间'], item['订单金额'], item['订单金额'], item['网点名称']]
					data.push(obj);
				}

				var option = {
					title: {
						text: ''
					},
					xAxis: {
						type: 'time',
						splitLine: {
							lineStyle: {
								type: 'dashed'
							}
						}
					},
					yAxis: {
						splitLine: {
							lineStyle: {
								type: 'dashed'
							}
						},
						scale: true
					},
					series: [{
						name: '',
						data: data,
						type: 'scatter',
						symbolSize: function(data) {
							return data[2] / 5;
						},
						emphasis: {
							label: {
								show: true,
								formatter: function(param) {
									return param.data[3] + " 在 " + param.data[0] + " 发生交易 " + param.data[1] + "元";
								},
								position: 'top'
							}
						},
						itemStyle: {
							shadowBlur: 10,
							shadowColor: 'rgba(120, 36, 50, 0.5)',
							shadowOffsetY: 5,
							color: new echarts.graphic.RadialGradient(0.4, 0.3, 1, [{
								offset: 0,
								color: 'rgb(251, 118, 123)'
							}, {
								offset: 1,
								color: 'rgb(204, 46, 72)'
							}])
						}
					}],
					dataZoom: [{
						show: true,
						type: 'slider',
						top: '90%',
						start: 0,
						end: 100
					}],
				};

				myChart.setOption(option);
			},
		}
	}
</script>

<style>
	.subTitle{
		font-size: 14px;
		margin-top: 1.25rem;
		margin-bottom: 0.3125rem;
		font-weight: 600;
	}
</style>
