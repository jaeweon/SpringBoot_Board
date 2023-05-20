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

        /* 2개 이상의 data 받을 때 param 사용 */
        function getList(param, callback){
            let boardNumber = param.boardNumber;
            let page = param.page || 1;
            console.log("param..........");
            console.log(boardNumber + page);
            $.getJSON("/reply/list/" + boardNumber + "/" + page, function (list){
                if(callback){
                    callback(list);
                }
            });
        }

        /* GET 방식 $.get 으로도 가능 */
        function read(replyNumber, callback){
            $.get("/reply/" + replyNumber, function (reply){
                if (callback){
                    callback(reply);
                }
            });
        }

    function remove(replyNumber , callback){
        console.log("remove reply..........");
        console.log(replyNumber);
        $.ajax({
            url: "/reply/" + replyNumber,
            type: "delete",
            success: function (reply){
                if(callback){
                    callback(reply);
                }
            }
        });
    }

    function modify(reply, callback){
        $.ajax({
            url: "/reply/" + reply.replyNumber,
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


    return {add : add, getList : getList, read : read, remove : remove, modify : modify};
})();