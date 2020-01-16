/* eslint-disable */
<template>
	<div style="width: 1300px; height:650px;" ref="chart" id="chart"></div>
</template>

<script>
	import util from '../../../util.js'
	import data from '../../../data.js'
	import BMapLib from 'BMapLib'
	import {
		MP
	} from '../../../map.js'

	// for axios add finally
	import promiseFinally from 'promise.prototype.finally';
	promiseFinally.shim();

	import tracksJSON from './tracks.json'

	export default {

		data() {
			return {
				data: []
			}
		},

		mounted() {
			MP();

			this.queryData();

			/**
			this.$nextTick(function(){
				var _this = this;
				MP().then(BMap => {
					_this.showMap(tracksJSON);
				})
			})
			**/
		},

		methods: {
			queryData() {
				this.showSpin = true;

				this.axios({
						method: "get",
						url: "/rainbow/wdjyxx",
						timeout: 1000 * 60 * 2,
						params: {
							filterMap: {
								startDate: util.lastMonth(new Date()),
								endDate: util.dateFormat(new Date()),
							}
						}
					})
					.then(
						function(response) {
							console.log(JSON.stringify(response))

							this.data = response.data.data;

							this.showMap(this.data);

						}.bind(this)
					)
					.catch(function(error) {
						alert(error);
					})
					.finally(function() {
						this.showSpin = false;
					}.bind(this));

			},

			showMap(data) {

				var echarts = require('echarts');

				require('echarts/extension/bmap/bmap');

				let myChart = echarts.init(document.getElementById('chart'));

				var points = [];
				for (var i = 0; i < data.length; i++) {
					var item = data[i];
					var ll = item.SHOP_Position.split(',');
					if (ll.length != 2)
						continue;

					points.push([parseFloat(ll[0]), parseFloat(ll[1]), item['交易张数总计']])
				}
				
				console.log(points[1]);
				
				var option = {
					animation: false,
					bmap: {
						center: [116.404269, 39.915156],
						zoom: 11,
						roam: true,
						mapStyle: {
							styleJson: [{
								'featureType': 'water',
								'elementType': 'all',
								'stylers': {
									'color': '#d1d1d1'
								}
							}, {
								'featureType': 'land',
								'elementType': 'all',
								'stylers': {
									'color': '#f3f3f3'
								}
							}, {
								'featureType': 'railway',
								'elementType': 'all',
								'stylers': {
									'visibility': 'off'
								}
							}, {
								'featureType': 'highway',
								'elementType': 'all',
								'stylers': {
									'color': '#fdfdfd'
								}
							}, {
								'featureType': 'highway',
								'elementType': 'labels',
								'stylers': {
									'visibility': 'off'
								}
							}, {
								'featureType': 'arterial',
								'elementType': 'geometry',
								'stylers': {
									'color': '#fefefe'
								}
							}, {
								'featureType': 'arterial',
								'elementType': 'geometry.fill',
								'stylers': {
									'color': '#fefefe'
								}
							}, {
								'featureType': 'poi',
								'elementType': 'all',
								'stylers': {
									'visibility': 'off'
								}
							}, {
								'featureType': 'green',
								'elementType': 'all',
								'stylers': {
									'visibility': 'off'
								}
							}, {
								'featureType': 'subway',
								'elementType': 'all',
								'stylers': {
									'visibility': 'off'
								}
							}, {
								'featureType': 'manmade',
								'elementType': 'all',
								'stylers': {
									'color': '#d1d1d1'
								}
							}, {
								'featureType': 'local',
								'elementType': 'all',
								'stylers': {
									'color': '#d1d1d1'
								}
							}, {
								'featureType': 'arterial',
								'elementType': 'labels',
								'stylers': {
									'visibility': 'off'
								}
							}, {
								'featureType': 'boundary',
								'elementType': 'all',
								'stylers': {
									'color': '#fefefe'
								}
							}, {
								'featureType': 'building',
								'elementType': 'all',
								'stylers': {
									'color': '#d1d1d1'
								}
							}, {
								'featureType': 'label',
								'elementType': 'labels.text.fill',
								'stylers': {
									'color': '#999999'
								}
							}]
						}
					},
					visualMap: {
						show: false,
						top: 'top',
						min: 0,
						max: 5,
						seriesIndex: 0,
						calculable: true,
						inRange: {
							color: ['blue', 'blue', 'green', 'yellow', 'red']
						}
					},
					series: [{
						type: 'heatmap',
						coordinateSystem: 'bmap',
						data: points,
						pointSize: 5,
						blurSize: 6,
					}]
				}

				myChart.setOption(option);
				
				var options = {
				            size: BMAP_POINT_SIZE_SMALL,
				            shape: BMAP_POINT_SHAPE_STAR,
				            color: '#d340c3'
				        }
						
				var pointCollection = new BMap.PointCollection(points, options); 
				pointCollection.addEventListener('click', function (e) {
				    console.log('单击点的坐标为：' + e.point.lng + ',' + e.point.lat);  // 监听点击事件
				});

				// 添加百度地图插件
				var bmap = myChart.getModel().getComponent('bmap').getBMap();

				bmap.addOverlay(pointCollection);  // 添加Overlay
				bmap.addControl(new BMap.MapTypeControl());
				

				

			},
		}

	}
</script>

<style>

</style>
