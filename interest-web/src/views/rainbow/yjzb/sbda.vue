<!-- 设备档案  -->
<style>

</style>

<template>
	<div style="margin: 40px;">
		
		<Spin size="large" fix v-if="showSpin"></Spin>
		
		<div style="padding: 10px 0;">
			<Table border :columns="columns1" :data="data1" :height="500"></Table>
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
						align: "center",
						sortable: true
					},
					{
						title: "意向时间",
						key: "yixiangTime",
						align: "center",
						sortable: true
					},
					{
						title: "关联时间",
						key: "guanlianTime",
						align: "center",
						sortable: true
					},
					{
						title: "装票开启时间",
						key: "openTime",
						align: "center",
						sortable: true
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
