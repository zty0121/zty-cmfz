<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('UserCount'));
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '持名法州App活跃用户'
        },
        tooltip: {},
        legend: {
            data: ['用户数量']
        },
        xAxis: {
            data: ["第一周", "第二周", "第三周"]
        },
        yAxis: {},
        series: [{
            name: '数量',
            type: 'bar',
            data: []
        }]
    };
    myChart.setOption(option);
    // 异步加载统计信息
    $.post("${pageContext.request.contextPath }/uc/UserCount", function (data) {
        console.log(data);
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption({
            series: [{
                // 根据名字对应到相应的系列
                name: '活跃用户',
                data: data
            }]
        });
    }, "json");
</script>
<div id="UserCount" style="width: 100%;height: 100%;margin-top: 30px;margin-left: 30px"></div>

这里用户模块的柱状图