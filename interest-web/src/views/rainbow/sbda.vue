<!-- 设备档案  -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">

				<Col span="8">日期：
				<DatePicker v-model="date" type="date" placeholder="选择日期" style="width: 250px"></DatePicker>
				</Col>

				<Col span="8">设备：
				<Select v-model="wangdianType" clearable style="width: 250px">
					<Option v-for="item in wangdianList" :value="item.id" :key="item.id">{{ item.title }}</Option>
				</Select>
				</Col>

				<Col span="8">所属地区：
				<Select v-model="wangdianType" clearable style="width: 250px">
					<Option v-for="item in wangdianList" :value="item.id" :key="item.id">{{ item.title }}</Option>
				</Select>
				</Col>

			</Row>
			<Row style="margin-bottom: 25px;">

				<Col span="8">渠道：
				<Select v-model="wangdianType" clearable style="width: 250px">
					<Option v-for="item in wangdianList" :value="item.id" :key="item.id">{{ item.title }}</Option>
				</Select>
				</Col>

				<Col span="8">网点：
				<Select v-model="wangdianType" clearable style="width: 250px">
					<Option v-for="item in wangdianList" :value="item.id" :key="item.id">{{ item.title }}</Option>
				</Select>
				</Col>

				<Col span="8">网点类型：
				<Select v-model="wangdianType" clearable style="width: 250px">
					<Option v-for="item in wangdianList" :value="item.id" :key="item.id">{{ item.title }}</Option>
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
	</div>
</template>


<script>
	
	// for axios add finally
	import promiseFinally from 'promise.prototype.finally';
	promiseFinally.shim();
	
	export default {
		data() {
			return {
				showSpin: false,
				date: null,
				searchContent: null,
				groupId: [],
				wangdianList: [{
					id: 1,
					title: "第一"
				}],
				total: 0,
				/*pageInfo实体*/
				pageInfo: {
					page: 0,
					pageSize: 10
				},
				/*表显示字段*/
				columns1: [{
						title: "网点名称",
						key: "name",
						align: "center"
					},
					{
						title: "所属渠道",
						key: "channel",
						align: "center"
					},
					{
						title: "意向时间",
						key: "yixiangTime",
						align: "center"
					},
					{
						title: "关联时间",
						key: "guanlianTime",
						align: "center"
					},
					{
						title: "装票开启时间",
						key: "openTime",
						align: "center"
					}
				],
				data1: []
			};
		},
		mounted() {
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
						url: "/rainbow/sbda",
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
					.finally(function(){
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
			}

		}

	};
</script>
