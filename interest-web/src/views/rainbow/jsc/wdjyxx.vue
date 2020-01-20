<template>
	<div>
		<div style="height:630px" id="container" tabindex="0"></div>
		<Spin size="large" fix v-if="showSpin"></Spin>
		<deviceInfoModal :showModal="showDetailModel" :detailInfo='detailInfo' :transferInfo='transferInfo' :detailTitle="detailTitle" :tabCheck="tabCheck" @closeSpin="closeSpin"></deviceInfoModal>
	</div>
</template>

<script>
	import AMap from 'AMap'
	import util from '../../../util.js'
	import data from '../../../data.js'
	// for axios add finally
	import promiseFinally from 'promise.prototype.finally';
	promiseFinally.shim();
	
	import deviceInfo from '../../component/deviceInfo'

	var _this;

	export default {

		name: '设备交易信息',
		data() {
			return {
				map: null,
				data: [],
				
				showSpin: false,
				
				startDate: util.lastMonth(new Date()),
				endDate: util.dateFormat(new Date()),
				
				showDetailModel: false, // 控制是否显示详情
				detailInfo: {}, // 某条数据下的所有的详情信息
				transferInfo: {},
				tabCheck: "name1",
				detailTitle: '加载中...',
			}
		},
		components: {
			'deviceInfoModal': deviceInfo
		},
		mounted() {
			this.init()
			this.queryData()
		},
		methods: {
			init: function() {
				_this = this;

				this.map = new AMap.Map('container', {
					center: [116.397428, 39.90923],
					resizeEnable: true,
					zoom: 11,
					features: ['bg', 'road', 'building'],
				})

				this.map.plugin(['AMap.ToolBar', 'AMap.Scale', 'AMap.OverView'], function() {
					_this.map.addControl(new AMap.ToolBar())
					_this.map.addControl(new AMap.Scale())

					// 鹰眼
					var overView = new AMap.OverView({
						visible: true
					});
					overView.open();
					_this.map.addControl(overView)
				})
			},
			
			/*得到详情数据*/
			showDetailInfo(ddiNo, shopNo) {
				
				this.showDetailModel = false;
				
				this.tabCheck = "name1"; // 默认刚打开时保证总是显示第一个tab
			
				this.detailInfo = []; // 置空详情数据，否则打开时仍然是上次的数据
			
				this.transferInfo = [];
				
				this.queryDetailInfo(ddiNo, shopNo);
			
				this.queryTransferInfo(ddiNo, shopNo);
			
			},
			
			queryDetailInfo(ddiNo, shopNo) {
				this.detailTitle = '加载中...';
			
				this.showSpin = true;
			
				this.axios({
						method: "get",
						url: "/rainbow/jqsxxx_detail",
						params: {
							filterMap: {
								ddiNo: ddiNo,
								shopValue: shopNo,
								startDate: this.startDate,
								endDate: this.endDate
							}
						}
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))
			
							this.detailTitle = '详情信息';
			
							this.detailInfo = response.data.data;
			
							this.showDetailModel = true;
			
						}.bind(this)
					)
					.catch(function(error) {
						//alert(error);
						this.showSpin = false;
					})
					.finally(function() {
						
					}.bind(this));
			},
			
			queryTransferInfo(ddiNo, shopNo) {
				this.showSpin = true;
			
				this.axios({
						method: "get",
						url: "/rainbow/jqsxxx_transfer_list",
						params: {
							filterMap: {
								ddiNo: ddiNo,
								shopValue: shopNo,
								startDate: this.startDate,
								endDate: this.endDate
							}
						}
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))
			
							this.transferInfo = response.data.data;
			
						}.bind(this)
					)
					.catch(function(error) {
						//alert(error);
						this.showSpin = false;
					})
					.finally(function() {
						
					}.bind(this));
			},
			
			closeSpin() {
				console.log("==++++++++++++++++++++============================")
				this.showSpin = false;
			}, 

			queryData() {
				this.showSpin = true;

				this.axios({
						method: "get",
						url: "/rainbow/wdjyxx",
						timeout: 1000 * 60 * 2,
						params: {
							filterMap: {
								startDate: this.startDate,
								endDate: this.endDate,
							}
						}
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))

							var tempData = response.data.data;
							this.data = [];

							for (var i = 0; i < tempData.length; i++) {
								var item = tempData[i];
								var ll = item.SHOP_Position.split(',');
								if (ll.length != 2)
									continue;

								this.data.push({
									lng: parseFloat(ll[0]),
									lat: parseFloat(ll[1]),
									count: item['交易张数总计'],
									ddiNo: item['DDI_No'],
									shopNo: item['SHOP_No']
								})
							}

							this.loadData();

						}.bind(this)
					)
					.catch(function(error) {
						//alert(error);
						
					})
					.finally(function() {
						this.showSpin = false;
					}.bind(this));

			},

			loadData() {

				console.log(this.data)

				var heatmap;
				AMap.plugin(["AMap.Heatmap"], function() {
					//初始化heatmap对象
					heatmap = new AMap.Heatmap(_this.map, {
						radius: 25, //给定半径
						opacity: [0, 0.8]
						/*,
						gradient:{
						    0.5: 'blue',
						    0.65: 'rgb(117,211,248)',
						    0.7: 'rgb(0, 255, 0)',
						    0.9: '#ffea00',
						    1.0: 'red'
						}
						 */
					});
					//设置数据集：该数据为北京部分“公园”数据
					heatmap.setDataSet({
						data: _this.data,
						max: 100
					});
				});



				var cluster, markers = [];
				AMap.plugin(['AMap.MarkerClusterer'], function() {
					for (var i = 0; i < _this.data.length; i += 1) {
						
						var item = _this.data[i];

						var marker = new AMap.Marker({
							position: [item['lng'], item['lat']],
							content: '<div style="background-color: hsla(180, 100%, 50%, 0.7); height: 24px; width: 24px; border: 1px solid hsl(180, 100%, 40%); border-radius: 12px; box-shadow: hsl(180, 100%, 50%) 0px 0px 1px;"></div>',
							offset: new AMap.Pixel(-15, -15),
							clickable: true,
						});
						AMap.event.addListener(marker, 'click', function() {
							_this.showDetailInfo(item['ddiNo'], item['shopNo']);
						})

						markers.push(marker)
					}

					var count = markers.length;
					var _renderClusterMarker = function(context) {
						var factor = Math.pow(context.count / count, 1 / 18);
						var div = document.createElement('div');
						var Hue = 180 - factor * 180;
						var bgColor = 'hsla(' + Hue + ',100%,50%,0.7)';
						var fontColor = 'hsla(' + Hue + ',100%,20%,1)';
						var borderColor = 'hsla(' + Hue + ',100%,40%,1)';
						var shadowColor = 'hsla(' + Hue + ',100%,50%,1)';
						div.style.backgroundColor = bgColor;
						var size = Math.round(30 + Math.pow(context.count / count, 1 / 5) * 20);
						div.style.width = div.style.height = size + 'px';
						div.style.border = 'solid 1px ' + borderColor;
						div.style.borderRadius = size / 2 + 'px';
						div.style.boxShadow = '0 0 1px ' + shadowColor;
						div.innerHTML = context.count;
						div.style.lineHeight = size + 'px';
						div.style.color = fontColor;
						div.style.fontSize = '14px';
						div.style.textAlign = 'center';
						context.marker.setOffset(new AMap.Pixel(-size / 2, -size / 2));
						context.marker.setContent(div)
					};

					if (cluster) {
						cluster.setMap(null);
					}

					cluster = new AMap.MarkerClusterer(_this.map, markers, {
						gridSize: 80,
						renderClusterMarker: _renderClusterMarker
					});
				})
			},

		}
	}
</script>
