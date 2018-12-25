<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    var AlbumId = "";

    function Opt(value, row, index) {
        if (row.album_id != null) {
            return "<audio class='Music' height='1px' width='3px' src='${pageContext.request.contextPath}/music/" + row.url + "'controls='controls'></audio>"
        } else {
            return null;
        }
    };
    $(function () {
        $("#AlbumTreeGrid").treegrid({
            url: '${pageContext.request.contextPath}/act/Albumpage',
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'title', title: '名字', width: 60},
                {field: 'url', title: '下载路径', width: 60, formatter: Opt},
                {field: 'size', title: '大小', width: 80},
                {field: 'duration', title: '时长', width: 80},
            ]],
            fit: true,
            fitColumns: true,
            toolbar: AlbumTaskBar,
            pagination: true,
            pageList: [1, 3, 5, 7, 9],
            pageSize: 3,
        });
        $("#AddAlbumBtn").linkbutton({
            iconCls: 'icon-add',
            text: "添加专辑",
            onClick: function () {
                $("#AddAlbumDig").dialog("open");
            }
        });
        $("#AddAlbumDig").dialog({
            title: "添加",
            width: 600,
            height: 300,
            href: "${pageContext.request.contextPath}/Album/AddAlbum.jsp",
            closed: true,
            modal: true,
            cache: false,
        });
        $("#AlbumDetailBtn").linkbutton({
            iconCls: 'icon-add',
            text: "专辑详情",
            onClick: function () {
                //获取选中行
                var row = $("#AlbumTreeGrid").treegrid("getSelected");
                if (row != null) {
                    //编辑指定行
                    AlbumId = row.id;
                    $("#AlbumDetailDig").dialog("open");
                } else {
                    alert("请先选中行");
                }
            }
        });
        $("#AlbumDetailDig").dialog({
            title: "详情",
            width: 600,
            height: 300,
            href: "${pageContext.request.contextPath}/Album/AlbumDetail.jsp",
            closed: true,
            modal: true,
            cache: false,
        });
        $("#AddChapterBtn").linkbutton({
            iconCls: 'icon-add',
            text: "添加章节",
            onClick: function () {
                $("#AddChapterDig").dialog("open");
            }
        });
        $("#AddChapterDig").dialog({
            title: "添加章节",
            width: 600,
            height: 300,
            href: "${pageContext.request.contextPath}/Chapter/AddChapter.jsp",
            closed: true,
            modal: true,
            cache: false,
        });
        $("#DownLoadChapterBtn").linkbutton({
            iconCls: 'icon-add',
            text: "下载音频",
            onClick: function () {
                var row = $("#AlbumTreeGrid").treegrid("getSelected");
                //是子节点
                if (row == null) {
                    alert("请先选择行");
                } else {
                    if (row.album_id != null) {
                        var RealUrl = "${pageContext.request.contextPath}/cc/DownLoad?url=" + row.url;
                        location.href = RealUrl;
                    } else {
                        alert("您选择的不是章节");
                    }
                }
            }
        });
        $("#ExportFileBtn").linkbutton({
            iconCls: 'icon-remove',
            text: "导出",
            onClick: function () {
                $.post("${pageContext.request.contextPath}/fc/ExceptFile",
                    null,
                    function (result) {
                        if (result == "ok") {
                            $.messager.show({
                                title: "Tips",
                                msg: "导出成功"
                            })
                        }
                    }
                )
            }
        });
        $("#ImportFileBtn").linkbutton({
            iconCls: 'icon-remove',
            text: "导入",
            onClick: function () {
                $("#ImportFileDig").dialog("open");
            }
        });
        $("#ImportFileDig").dialog({
            title: "导入文件",
            width: 600,
            height: 300,
            href: "${pageContext.request.contextPath}/Album/ImportAlbumFile.jsp",
            closed: true,
            modal: true,
            cache: false,
        });
    })
</script>
<div id="AlbumTaskBar">
    <a id="AlbumDetailBtn"></a>
    <a id="AddAlbumBtn"></a>
    <a id="AddChapterBtn"></a>
    <a id="DownLoadChapterBtn"></a>
    <a id="ImportFileBtn"></a>
    <a id="ExportFileBtn"></a>
</div>

<div id="AlbumDetailDig"></div>
<div id="AddAlbumDig"></div>
<div id="AddChapterDig"></div>
<table id="AlbumTreeGrid"></table>
<div id="ImportFileDig"></div>