<%@page pageEncoding="UTF-8" %>
<script type="text/javascript" src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
<script type="text/javascript">
    $(function () {
        var goEasy = new GoEasy({
            appkey: "BC-a36c38bc99ab4be39f74d7840201943e"
        });
    })

    function Click() {
        var message = $("#CharText").val();
        goEasy.publish({
            channel: "140",
            onMessage: function (message) {
                alert("Channel:" + message.channel + " content:" + message.content);
            }
        });
    }
</script>
<input id="CharText" onClick="Click">
