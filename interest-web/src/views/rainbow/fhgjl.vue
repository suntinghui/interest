<!-- 复合关机率  -->
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

			<Row style="margin-bottom: 25px; text-align: center;">
				<Col><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>
			</Row>
		</div>

		<div style="padding: 10px 0;">
			<Table border :columns="columns1" :data="data1" :height="350"></Table>
		</div> 
	</div>
</template>


<script>
	import util from '../../util.js'
	
	export default {
		data() {
			return {
				date: null,
				searchContent: null,
				groupId: [],
				wangdianList: [{
					id: 1,
					title: "好的"
				}],
				/*表显示字段*/
				columns1: [
				  {
					title: "标题",
				    width: 400,
					key: "title",
				    align: "center"
				  },
				  {
				    title: "数值",
				    key: "value",
					align: "center"
				  }],
				data1: []
			};
		},
		mounted() {
			/*页面初始化调用方法*/
			this.search();
		},
		methods: {
			search() {
				this.axios({
						method: "get",
						url: "/rainbow/fhgjl",
						params: {

						}
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))
							
							var item = {
								"title": "复合关机率",
								"value": util.toPercent(response.data.data)
							};
							
							this.data1 = [];
							this.data1.push(item);
						}.bind(this)
					)
					.catch(function(error) {
						alert(error);
					});

			},

		}

	};
</script>
