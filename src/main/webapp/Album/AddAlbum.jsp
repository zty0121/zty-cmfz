<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        $("#title").validatebox({
            validType: true,
            required: true
        });
        $("#count").validatebox({
            validType: true,
            required: true
        });
        $("#score").validatebox({
            validType: true,
            required: true
        });

        $("#author").validatebox({
            validType: true,
            required: true
        });
        $("#broadcast").validatebox({
            validType: true,
            required: true
        });
        $("#brief").validatebox({
            validType: true,
            required: true
        });
        $("#pub_date").datebox({
            validType: true,
            required: true
        });
        $("#AddAlbumSubmitBtn").linkbutton({
            text: "submit",
            onClick: function () {          //提交表单
                $("#AddAlbumForm").form("submit", {
                    url: "${pageContext.request.contextPath}/act/AddOneAlbum",
                    onSubmit: function () {
                        return $("#AddAlbumForm").form("validate");                 //当表单全部验证为true 时提交表单
                    },
                    success: function () {
                        $("#AddAlbumDig").dialog("close");
                        $("#AlbumTreeGrid").treegrid("reload");
                        $.messager.show({
                            title: "Tips",
                            msg: "success"
                        });
                    }
                });
            }
        })
    });
</script>
<form method="post" id="AddAlbumForm" enctype="multipart/form-data">
    <table>
        <tr>
            <td> title:</td>
            <td><input id="title" name="title"></td>
        </tr>
        <tr>
            <td> count:</td>
            <td><input id="count" name="count"></td>
        </tr>
        <tr>
            <td> picture:</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td> score:</td>
            <td><input id="score" name="score"></td>
        </tr>
        <tr>
            <td> author:</td>
            <td><input id="author" name="author"></td>
        </tr>
        <tr>
            <td> broadcast:</td>
            <td><input id="broadcast" name="broadcast"></td>
        </tr>
        <tr>
            <td> brief:</td>
            <td><input id="brief" name="brief"></td>
        </tr>
        <tr>
            <td> pub_date:</td>
            <td><input id="pub_date" name="pub_date"></td>
        </tr>
    </table>
    <a id="AddAlbumSubmitBtn"></a>
</form>