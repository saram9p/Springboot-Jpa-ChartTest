// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

function resetBarCanvas(){
	document.querySelector('#myBarChart').remove(); // this is my <canvas> element
	//var newCanvas = "\<canvas id='myBarChart' width='100%' height='40'\>\</canvas\>";
	//var newCanvas = document.createElement("").innerHTML("<	canvas id='myAreaChart' width='100%' height='40'></canvas>");
	document.getElementById("BarChartContainer").innerHTML += "<canvas id='myBarChart' width='100%' height='40'></canvas>";
	//document.querySelector('#AreaChartContainer').append(newCanvas);
	//$("#AreaChartContainer").append("<canvas id='myAreaChart' width='100%' height='40'></canvas>");
	barCtx = document.querySelector("#myBarChart");
	//ctx = canvas.getContext('2d');
	//ctx.canvas.width = $('#graph').width(); // resize to parent width
	//ctx.canvas.height = $('#graph').height(); // resize to parent height
	//var x = canvas.width/2;
	//var y = canvas.height/2;
	//ctx.font = '10pt Verdana';
	//ctx.textAlign = 'center';
	//ctx.fillText('This text is centered on the canvas', x, y);
};

async function getBarChartData() {

	let response = await fetch("http://localhost:8080/getBarChartData", {
		method: "Post",
	});
	
	let parseResponse = await response.json();
	//console.log(parseResponse);
	
		if(parseResponse.code == 1) { // ajax는 자바스크립트에서 분기 시켜줘야 한다
			
			resetBarCanvas();

		// Bar Chart Example
		//var ctx = document.getElementById("myBarChart");
		var myLineChart = new Chart(barCtx, {
		  type: 'bar',
		  data: {
		    labels: [],
		    datasets: [{
		      label: "Revenue",
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

		var barLabelList = myLineChart["data"]["labels"];
		var barValueList = myLineChart["data"]["datasets"]["0"]["data"];
		
		// 월별 방문자 수 차트
		var mJsonData = parseResponse.body;
		//var mJsonObject = JSON.stringify(mJsonData);
		var mJData = JSON.parse(mJsonData);

		
        var check = mJData["0"]["Count"];
        
		console.log(mJData);
		console.log(mJData["0"]["Count"]);
		console.log(count);

		if(count = 0){
			
			for (var i = 0; i < mJData.length; i++) { // mJData의 길이 까지 차트에 데이터를 집어넣는다
			var m = mJData[i];
			console.log(m);
			//console.log(myLineChart["data"]);
			barLabelList.push(m.Time);
			barValueList.push(m.Count);
			
			myLineChart.update();
			count = count + mJData["0"]["Count"];
			}
		}
		
		if(check != count){
			
			for (var i = 0; i < mJData.length; i++) { // mJData의 길이 까지 차트에 데이터를 집어넣는다
				var m = mJData[i];
				console.log(m);
				//console.log(myLineChart["data"]);
				barLabelList.push(m.Time);
				barValueList.push(m.Count);
			}
			
			myLineChart.update();
		} else {
		}

		
		
	} else {
		console.log("차트를 불러올 수 없습니다.")
	}
	
}
		