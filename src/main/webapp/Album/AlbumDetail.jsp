<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        $("#AlbumDateDetailForm").form("load", "${pageContext.request.contextPath}/act/QueryOneAlbum?id=" + AlbumId);
        $("#AlbumDateDetailForm").form(
            {
                onLoadSuccess: function (data) {
                    $("#cover_img").prop("src", "${pageContext.request.contextPath }/img/" + data.cover_img);
                }
            }
        );
    })
</script>
<form id="AlbumDateDetailForm" method="post">
    <table>
        <tr>
            <td>id<input id="tid" name="id" readonly></td>
        </tr>
        <tr>
            <td>name<input id="title" name="title" readonly></td>
        </tr>
        <tr>
            <td>email<input id="count" name="count" readonly></td>
        </tr>
        <tr>
            <td>picture<img id="cover_img" src=""></td>
        </tr>
        <tr>
            <td>score<input id="score" name="score" readonly></td>
        </tr>
        <tr>
            <td>author<input id="author" name="author" readonly></td>
        </tr>
        <tr>
            <td>broadcast<input id="broadcast" name="broadcast" readonly></td>
        </tr>
        <tr>
            <td>brief<input id="brief" name="brief" readonly></td>
        </tr>
        <tr>
            <td>pub_date<input id="pub_date" name="pub_date" readonly></td>
        </tr>
    </table>
</form>