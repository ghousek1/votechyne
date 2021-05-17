$(document).ready(function () {
    // SUBMIT FORM
    $("#leadMindAllotmentForm").submit(function (event) {
      // Prevent the form from submitting via the browser.
      console.log("Lead Mind Allocation form submitted");
      event.preventDefault();
      ajaxPost();
    });
  
    function ajaxPost() {
          // PREPARE FORM DATA
      var leadIdStr= $("#leadId").val();
      var mindIdStr= $("#mindId").val();
      var formData = {
        leadId: parseInt(leadIdStr),
        mindId: parseInt(mindIdStr)
        
      };
      console.log(formData)
  
      // DO POST
      $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "orchardallotment/leadmindallotment/",
        data: JSON.stringify(formData),
        dataType: "json",
        success: function (result) {
          
         console.log("leadmindallotment Details saved to database");
          console.log(result);
          alert("leadmindallotment");
        },
        error: function (e) {
         
          console.log("ERROR: ", e);
        },
      });
    }
  });
  