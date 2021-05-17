console.log("add orchard mind js");

$(document).ready(function () {
  console.log("added orchard mind page loaded....");

  // SUBMIT FORM
  $("#newOrchardMindForm").submit(function (event) {
    // Prevent the form from submitting via the browser.
    console.log("new orchard mind btn clicked");

    // $("#newOrchardMindForm").validate({
    //   rules: {
    //     mindName:{ required: true },
    //     mindEmail: {
    //       required: true,
    //       email: true,
    //     },
    //     mindPhone: { required: true, phone: true },
    //   },
    // });

    console.log("new orchardMind form submitted");
    event.preventDefault();
    ajaxPost();
    function ajaxPost() {
      // PREPARE FORM DATA
      var formData = {
        mindName: $("#mindName").val(),
        email: $("#mindEmail").val(),
        phone: $("#mindPhone").val(),
        enggStream: $("#mindEnggStream").val(),
        track: $("#mindTrack").val(),
      };
      console.log(formData)
      var reqUrl = `/orchardmind/`;
      // DO POST
      $.ajax({
        type: "POST",
        contentType: "application/json",
        url: reqUrl,
        data: JSON.stringify(formData),
        dataType: "json",
        success: function (result) {
          if (result.status == "success") {
            console.log("orchardMind Details saved to database");
          } else {
            console.log("orchardMind Details Not saved to database");
          }
          console.log(result);
        },
        error: function (e) {
          alert("Error!");
          console.log("ERROR: ", e);
        },
      });
    }
  });
});


