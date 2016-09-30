/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function ()
{
    var arr = [];
    arr.push("When you're eighteen your emotions are violent, but they're not durable.");
    arr.push("The thing about chameleoning your way through life is that it gets to where nothing is real.");
    arr.push("Writing is the only profession where no one considers you ridiculous if you earn no money.");
    arr.push("Toil to make yourself remarkable by some talent or other.");
    arr.push("No matter how old you are, there's always something good to look forward to.");
    arr.push("There are no stupid questions. Only stupid people.");
    
    

    $("#quote").each(function ()
                {
                    var max = arr.length;
                    var min = 1;
                    var id = Math.floor(min + (Math.random() * ((max - min) + 1)));
                   $("#quote").html("\"" + arr[id]+"\""); 
                   
                });
                
    $("#btn").click(function ()
                {
                    var max = arr.length;
                    var min = 1;
                    var id = Math.floor(min + (Math.random() * ((max - min) + 1)));
                   $("#quote").html("\"" + arr[id]+"\""); 
                   
                });
    
    $("#add").click(function ()
    {
        alert("You added a new quote to the random quote collection!");
        addQuote();
    });
    
    $("#edit").click(function ()
    {
        alert("You edited a quote.");
        editQuote();
    });
    
    function addQuote()
    {

        var quote = '{"quote":"' + $("#newQuote").val() + '"}';
        
        arr.push($("#newQuote").val());
        $.ajax({
            url: "http://localhost:8080/RESTexercise/api/quote",
            type: "POST",
            data: quote,
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            success: function () {}
        });

    }
    
    function editQuote()
    {

        var quote = '{"quote":"' + $("#editQuote").val() + '"}';
        
        arr.push($("#editQuote").val());
        $.ajax({
            url: "http://localhost:8080/RESTexercise/api/quote",
            type: "PUT",
            data: quote,
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            success: function () {}
        });

    }
 


});
