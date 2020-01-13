/* eslint-disable */
<template>
	<div style="width: 800px; height:400px;" ref="chart" id="chart"></div>
</template>

<script>
	import util from '../../../util.js'
	import data from '../../../data.js'

	// for axios add finally
	import promiseFinally from 'promise.prototype.finally';
	promiseFinally.shim();
	
	import tracksJSON from './tracks.json'

	export default {

		mounted() {
			
			
			this.queryData(tracksJSON);
		},

		methods: {
			queryData(data) {
				
				var echarts = require('echarts/lib/echarts');
				
				require('echarts/extension/bmap/bmap');
				
				require('echarts/lib/chart/heatmap');
				
				// 引入提示框和标题组件
				require('echarts/lib/component/tooltip');
				require('echarts/lib/component/visualMap');
				require('echarts/lib/component/title');
				require('echarts/lib/component/dataZoom');
				require('echarts/lib/component/legend');
				
				let myChart = echarts.init(document.getElementById('chart'));
				
				var points = [].concat.apply([], data.map(function(track) {
					return track.map(function(seg) {
						return seg.coord.concat([1]);
					});
				}));

				var option = {
					animation: false,
					bmap: {
						center: [120.13066322374, 30.240018034923],
						zoom: 14,
						roam: true
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
						blurSize: 6
					}]
				}

				myChart.setOption(option);
				// 添加百度地图插件
				var bmap = myChart.getModel().getComponent('bmap').getBMap();
				bmap.addControl(new BMap.MapTypeControl());
			},
		}

	}
</script>

<style>

</style>
