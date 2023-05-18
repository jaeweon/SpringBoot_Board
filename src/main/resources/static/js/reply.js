let replyService = (function (){

    function add(reply, callback){
        console.log("add reply..........");
        console.log(reply);
        $.ajax({
            url: "/reply/new",
            type: "post",
            data: JSON.stringify(reply),
            contentType: "application/json",
            success: function (result){
                if(callback){
                    callback(result);
                }
            }
        });
    }

    return {add : add};
})();