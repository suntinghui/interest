<style>

</style>
<template>
	<div style="margin: 40px;">
		<div>
			<Row style="margin-bottom: 25px;">
				<Col span="9">搜索：
				<Input v-model="searchContent" placeholder="请输入..." style="width:300px" />
				</Col>
				<Col span="6">
				<DatePicker v-model="date" type="date" placeholder="Select date" style="width: 200px"></DatePicker>
				</Col>
				<Col span="4"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>
			</Row>
		</div>

		<div>

		</div>
	</div>
</template>
<script>
	export default {
		data() {
			return {
				date: null,
				searchContent: null,
				groupId: [],
				/*表数据*/
				data1: []
			};
		},
		mounted() {
			/*页面初始化调用方法*/
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
				      alert("then"+JSON.stringify(response));
				    }.bind(this)
				  )
				  .catch(function(error) {
				    alert(error);
				  });
				
			},

		}

	};
</script>
