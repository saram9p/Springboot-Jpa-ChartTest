// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

barCtx = document.querySelector("#myBarChart");

// Bar Chart Example
var myLineChart = new Chart(barCtx, {
  type: 'bar',
  data: {
    datasets: [{
    labels: [],
      label: "월별 방문자 수",
      backgroundColor: "rgba(2,117,216,1)",
      borderColor: "rgba(2,117,216,1)",
      data: [],
    }],
  },
  options: {
	animation: {
		duration: 0
	},
    scales: {
      xAxes: [{
        time: {
          unit: 'month'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: 6
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          maxTicksLimit: 5
        },
        gridLines: {
          display: true
        }
      }],
    },
    legend: {
      display: false
    }
  }
});

async function getBarChartData() {

	let response = await fetch("http://localhost:8080/getBarChartData", {
		method: "Post",
	});
	
	let parseResponse = await response.json();
	
		if(parseResponse.code == 1) { // ajax는 자바스크립트에서 분기 시켜줘야 한다

		removeDataSets(myLineChart);
		addMyLineChartDataSets(myLineChart);

		var barLabelList = myLineChart["data"]["labels"];
		var barValueList = myLineChart["data"]["datasets"]["0"]["data"];
		
		// 월별 방문자 수 차트
		var mJsonData = parseResponse.body;
		var mJData = JSON.parse(mJsonData);

		for (var i = 0; i < mJData.length; i++) { // mJData의 길이 까지 차트에 데이터를 집어넣는다
			var m = mJData[i];
			barLabelList.push(m.Time);
			barValueList.push(m.Count);
		}
		
		myLineChart.update();
		
	} else {
		console.log("차트를 불러올 수 없습니다.")
	}
	
}
		