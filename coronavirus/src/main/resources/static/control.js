console.log(document.getElementById('main'));
var myChart = echarts.init(document.getElementById('main'));
function updateMap(num){
    $(".control").show();
    $(".control:eq("+num+")").hide();
    myChart.clear();
    var opt = null;
    switch(num){
        case 0:{
            opt = {
                // 设置标题和副标题及副标题跳转链接
                title: {
                    text: '新冠疫情-国内累计数据',
                },
                // 数据提示框
                tooltip: {
                    trigger: 'item', // item放到数据区域触发
                    formatter: function (params, ticket, callback) {
                        if(params.data)
                            return params.name+'<br/>'+params.data.value+' (人)';
                        else
                            return params.name+'<br/>无疫情信息';
                    }
                },
                // 视觉映射方案:
                // visualMap默认是连续映射，我们也可以设置为分段型，对于分布范围广的数据
                // 使用透明度来区分疫情严重情况
                visualMap: {
                    type: 'piecewise',
                    pieces: [
                        {gt: 2000, color: 'darkred'},                        // (1500, Infinity]
                        {gt: 1300, lte: 2000, color: 'red', colorAlpha: 1},  // (1000, 1500]
                        {gt: 800, lte: 1300, color: 'red', colorAlpha: 0.8},
                        {gt: 500, lte: 800, color: 'red', colorAlpha: 0.6},
                        {gt: 200, lte: 500, color: 'red', colorAlpha: 0.4},
                        {gt: 50, lte: 200, color: 'red', colorAlpha: 0.3},
                        {lt: 50, color: 'red', colorAlpha: 0.2}          // (-Infinity, 100)
                    ],
                },

                // 具体数据
                series: [
                    {
                        name: '国内各省确诊病例', // 系列名称
                        zoom:1.2,//地图大小
                        type: 'map', // 系列类型，地图
                        map: 'china', // 要使用的地图，即上面注册的地图名称
                        roam: true, // 开启鼠标缩放和平移漫游
                        label: { // 图形上的文本标签，地图默认显示数据名
                            show: true,
                            formatter: '{b}', // b是数据名，c是数据值
                            fontSize: 8
                        },
                        data: data.data,
                    }
                ]
            };

        }
            break;
        case 1:{
            opt = {
                // 设置标题和副标题及副标题跳转链接
                title: {
                    text: '新冠疫情-国内新增数据',
                },
                // 数据提示框
                tooltip: {
                    trigger: 'item', // item放到数据区域触发
                    formatter:  function (params, ticket, callback) {
                        if(params.data)
                            return params.name+'<br/>'+params.data.value+' (人)';
                        else
                            return params.name+'<br/>无疫情信息';
                    }
                },

                // 视觉映射方案:
                // visualMap默认是连续映射，我们也可以设置为分段型，对于分布范围广的数据
                // 使用透明度来区分疫情严重情况
                visualMap: {
                    type: 'piecewise',
                    pieces: [
                        {gt: 50, color: 'darkred'},                        // (1500, Infinity]
                        {gt: 30, lte: 50, color: 'red', colorAlpha: 1},  // (1000, 1500]
                        {gt: 20, lte: 30, color: 'red', colorAlpha: 0.8},
                        {gt: 10, lte: 20, color: 'red', colorAlpha: 0.6},
                        {gt: 5, lte: 10, color: 'red', colorAlpha: 0.4},
                        {gt: 1, lte: 5, color: 'red', colorAlpha: 0.3},
                        {lt: 1, color: 'red', colorAlpha: 0.0}          // (-Infinity, 100)
                    ],
                },

                // 具体数据
                series: [
                    {
                        name: '国内各省确诊病例', // 系列名称
                        zoom:1.2,//地图大小
                        type: 'map', // 系列类型，地图
                        map: 'china', // 要使用的地图，即上面注册的地图名称
                        roam: true, // 开启鼠标缩放和平移漫游
                        label: { // 图形上的文本标签，地图默认显示数据名
                            show: true,
                            formatter: '{b}', // b是数据名，c是数据值
                            fontSize: 8
                        },
                        data: data.today,
                    }
                ]
            };
        }
            break;
        case 2:{
            opt = {
                // 设置标题和副标题及副标题跳转链接
                title: {
                    text: '新冠疫情-全球累计数据',
                },
                // 数据提示框
                tooltip: {
                    trigger: 'item', // item放到数据区域触发
                    //formatter: '{b}<br/>{c} (人)' // 提示数据格式br表示换行，地图 : {a}（系列名称），{b}（区域名称），{c}（合并数值）, {d}（无）
                    formatter:function (params, ticket, callback) {
                        if(params.data)
                            return params.name+'<br/>'+params.data.value+' (人)';
                        else
                            return params.name+'<br/> 未公布感染人数';
                    }
                },
                // 视觉映射方案1：,疫情颜色根据传染病疫情等级分类为5个级别：黄色-橙色-深橙色-红色-深红色
                // 为了是视觉分布更好，可以添加更多的颜色范围，然后适当调小max的值，因为美国和其它国家相差太大
                /**/
                visualMap: {
                    min: 1, // 颜色映射对应的最小值，即对应下面的lightskyblue
                    max: 500000, // 颜色映射对应的最大值，即对应下面的orangered
                    text: ['严重', '轻微'], // 映射图上下标记文本
                    realtime: true, // 是否显示拖拽手柄，映射条可以拖拽调整要映射的范围
                    calculable: true, // 拖拽时，是否实时更新地图
                    inRange: {
                        color: ['rgba(222,0,0,0.2)','rgba(160,0,0,1)'] // 颜色映射范围，最小值，过渡值，最大值
                    }
                },

                // 具体数据
                series: [
                    {
                        name: '全球各国确诊病例', // 系列名称
                        zoom:1.2,//地图大小
                        type: 'map', // 系列类型，地图
                        map: 'world', // 要使用的地图，即上面注册的地图名称
                        roam: true, // 开启鼠标缩放和平移漫游
                        label: { // 图形上的文本标签，地图默认显示数据名
                            show: true,
                            fontSize:8,
                            //formatter: '{b}', // b是数据名，c是数据值
                            formatter:function (params, ticket, callback) {
                                //公布了数据 且 数据累计数据大于5万的显示国家名称
                                if(params.data && params.data.value>50000) {
                                    return params.name;
                                }else{
                                    return '';
                                }
                            }
                        },
                        data: data.g_data,
                    }
                ]
            };
        }
            break;
        case 3:{
            opt = {
                // 设置标题和副标题及副标题跳转链接
                title: {
                    text: '新冠疫情-全球新增数据',
                },
                // 数据提示框
                tooltip: {
                    trigger: 'item', // item放到数据区域触发
                    formatter:function (params, ticket, callback) {
                        if(params.data)
                            return params.name+'<br/>'+params.data.value+' (人)';
                        else
                            return params.name+'<br/> 未公布感染人数';
                    }
                },
                // 视觉映射方案1：,疫情颜色根据传染病疫情等级分类为5个级别：黄色-橙色-深橙色-红色-深红色
                // 为了是视觉分布更好，可以添加更多的颜色范围，然后适当调小max的值，因为美国和其它国家相差太大
                /**/
                visualMap: {
                    min: 0, // 颜色映射对应的最小值，
                    max: 20000, // 颜色映射对应的最大值
                    text: ['严重', '轻微'], // 映射图上下标记文本
                    realtime: true, // 是否显示拖拽手柄，映射条可以拖拽调整要映射的范围
                    calculable: true, // 拖拽时，是否实时更新地图
                    inRange: {
                        color: ['rgba(160,0,0,0)','rgba(160,0,0,1)'] // 颜色映射范围，最小值，过渡值，最大值
                    }
                },
                // 具体数据
                series: [
                    {
                        name: '全球各国新增病例', // 系列名称
                        zoom:1.2,//地图大小
                        type: 'map', // 系列类型，地图
                        map: 'world', // 要使用的地图，即上面注册的地图名称
                        roam: true, // 开启鼠标缩放和平移漫游
                        label: { // 图形上的文本标签，地图默认显示数据名
                            show: true,
                            fontSize:8,
                            //formatter: '{b}', // b是数据名，c是数据值
                            formatter:function (params, ticket, callback) {
                                //公布了数据 且 数据累计数据大于5万的显示国家名称
                                if(params.data && params.data.value>1000 || params.name == '中国') {
                                    return params.name;
                                }else{
                                    return '';
                                }
                            }
                        },
                        data: data.g_today,
                    }
                ]
            };
        }
            break;
    }
    myChart.setOption(opt);
}
updateMap(0);