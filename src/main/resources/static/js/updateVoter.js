$(document).ready(function () {
  $("#updateOrchardMindForm").submit(function (event) {
    // Prevent the form from submitting via the browser.
    event.preventDefault();
    ajaxUpdate();
  });

  // DO PUT
  function ajaxUpdate() {
    // PREPARE FORM DATA
    var orchardMind = {
	  mindId:$("#mindId").val(),
      mindName: $("#mindName").val(),
      email: $("#mindEmail").val(),
      phone: $("#mindPhone").val(),
      enggStream: $("#mindEnggStream").val(),
      track: $("#mindTrack").val(),
    };
    console.log(orchardMind);
    var reqUrl = `/orchardmind/${orchardMind.mindId}`;
    console.log(reqUrl);

    $.ajax({
      type: "PUT",
      url: reqUrl,
      contentType: "application/json",
      data: JSON.stringify(orchardMind),
      dataType: "json",
      success: function (result) {
        //$("#promptBox").text("OrchardMind Data Update!");
		console.log(result);
		alert("Orchard Mind Updated")
        if (result == "UPDATED") {
          alert("Orchard Mind Updated!");
          console.log("update  method successfully executed");
          console.log("App_Result: ", result);
        } else {
          console.log("Update Method Failed");
          console.log("App_Fail: ", result);
        }
      },
      error: function (e) {
        console.log("ERROR: ", e);
      },
    });
  }
});
