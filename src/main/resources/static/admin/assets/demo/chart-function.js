function removeDataSets(Chart){
	// 빈 리스트 생성
	let list = [];
	// 빈 리스트를 labels 에 넣어서 초기화
	Chart.data.labels = list;
	// splice() : 배열의 기존 요소를 삭제 또는 교체하거나 새 요소를 추가하여 배열의 내용을 변경
	// -1번(끝에서 첫번째) 인덱스에서 한개 요소 제거
	Chart.data.datasets.splice(-1,1);
	// 차트 업데이트 하면 가끔씩 차트가 비어있는 화면 보이기 때문에 주석처리
	//Chart.update();
}

//데이터셋 추가
function addAreaChartDataSets(Chart){
	var newDataset = {
		labels: [],
		label: "일별 방문자수",
		lineTension: 0.3,
		backgroundColor: "rgba(2,117,216,0.2)",
		borderColor: "rgba(2,117,216,1)",
		pointRadius: 5,
		pointBackgroundColor: "rgba(2,117,216,1)",
		pointBorderColor: "rgba(255,255,255,0.8)",
		pointHoverRadius: 5,
		pointHoverBackgroundColor: "rgba(2,117,216,1)",
		pointHitRadius: 50,
		pointBorderWidth: 2,	
		data: []
	}
	
	// chart에 newDataset 푸쉬
	Chart.data.datasets.push(newDataset);
	
	Chart.update();	//차트 업데이트
}

function addMyLineChartDataSets(Chart){
	var newDataset = {
		labels: [],
		label: "월별 방문자 수",
		backgroundColor: "rgba(2,117,216,1)",
		borderColor: "rgba(2,117,216,1)",
		data: []
	}
	
	// chart에 newDataset 푸쉬
	Chart.data.datasets.push(newDataset);
	
	Chart.update();	//차트 업데이트
}

// 전에 사용했던 함수 (canvas 삭제 후에 다시 생성)
function resetAreaCanvas(){
	document.querySelector('#myAreaChart').remove();
	
	const canvas = document.createElement("canvas");
	
	canvas.setAttribute("id", "myAreaChart");
	document.getElementById("AreaChartContainer").appendChild(canvas);
	
	//document.getElementById("AreaChartContainer").insertAdjacentHTML('afterbegin', "<canvas id='myAreaChart' width='100%' height='40'></canvas>");
	ctx = document.querySelector("#myAreaChart");
};

// 전에 사용했던 함수 (canvas 삭제 후에 다시 생성)
function resetBarCanvas(){
	document.querySelector('#myBarChart').remove();
	
	const canvas = document.createElement("canvas");
	
	canvas.setAttribute("id", "myBarChart");
	document.getElementById("BarChartContainer").appendChild(canvas);
	
	//document.getElementById("BarChartContainer").insertAdjacentHTML('afterbegin', "<canvas id='myBarChart' width='100%' height='40'></canvas>");
	barCtx = document.querySelector("#myBarChart");
};