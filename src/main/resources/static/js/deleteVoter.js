console.log("delete orchardmind");


function deleteOrchardMindMethod(mindIdStr){
  let mindId=parseInt(mindIdStr);
  console.log("delete Orchard Mind Ajax Clicked");
  ajaxDelete(mindId);
}


// DO Delete
function ajaxDelete(mindId) {

  var reqUrl = `/orchardmind/${mindId}`;
	console.log(reqUrl);

  $.ajax({
    type: "DELETE",
    url: reqUrl,
    success: function (result) {
     
      if (result== "DELETED") {
        alert("MindId Deleted!");
        // $("#promptBox").html(`<h2 style="color:red" > Employee Deleted!<h2>`);
        console.log("Delete method successfully executed");
        console.log("App_Result: ", result);
      } else {
        console.log("Delete Method Failed");
        console.log("App_Fail: ", result);
      }
    },
    error: function (e) {
      console.log("ERROR: ", e);
    },
  });
}
