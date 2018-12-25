<%@page pageEncoding="UTF-8" %>
<meta charset="utf-8">
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'));

    option = {
        title: {
            text: 'iphone销量',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['用户数量']
        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'],           // 文本，默认为数值文本
            calculable: true
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        series: [
            {
                name: '用户数量',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: []
            }

        ]
    };
    myChart.setOption(option)
    $.post("${pageContext.request.contextPath }/uc/UserAddress", function (data) {
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