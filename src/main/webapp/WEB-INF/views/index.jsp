<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm\/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="/admin/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">

                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="/">Home</a>
                            </nav>
                        </div>
                    </div>

                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>

                    <div class="container-fluid px-4">
                        <h1 class="mt-4">회원관리페이지</h1>
                        <h2>${parseCount}</h2>
                        <br>
                        <div class="row">
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header" id="start">
                                        <i class="fas fa-chart-area me-1"></i>
                                        일별 방문자
                                    </div>
                                    <div class="card-body" id="AreaChartContainer" style="position: relative; height:40%; width:100%"><canvas id="myAreaChart"></canvas></div>
                                </div>
                            </div>
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        월별 방문자
                                    </div>
                                    <div class="card-body" id="BarChartContainer" style="position: relative; height:40%; width:100%"><canvas id="myBarChart"></canvas></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>

            </div>
        </div>


	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="/admin/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="/admin/assets/demo/chart-function.js"></script>
        <script src="/admin/assets/demo/chart-area-demo.js"></script>
        <script src="/admin/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="/admin/js/datatables-simple-demo.js"></script>

<script>
// 데이터 불러오기
	getBarChartData();
	getAreaChartData();
</script>

<script>

// 3초마다 데이터 불러오기
	setInterval(function(){
		getAreaChartData();
	}, 3000)
		
	setInterval(function(){
		getBarChartData();
	}, 3000)
	
</script>

</body>
</html> 