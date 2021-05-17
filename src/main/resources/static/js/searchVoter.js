console.log("search orchardmind");
$(document).ready(function () {
  // GET REQUEST
  $("#searchOrchardMindForm").submit(function (event) {
    console.log("search employee Js triggered");
    event.preventDefault();
    ajaxGet();
  });
});

function ajaxGet() {
  var formData = {
    mindId: $("#mindId").val(),
  };
  console.log(formData.mindId);
  var reqUrl = `/orchardmind/${formData.mindId}`;

  $.ajax({
    type: "GET",
    url: reqUrl,
    success: function (result) {
      if (result.status == "success") {
        console.log("Get method successfully executed");
        console.log("App_Result: ", result);
        var orchardMind = result.data;

        $("#showOrchardMindBox").append(
          `
          <div style="color:white" class="card bg-primary">
          <div class="card-header">Mind Id: ${orchardMind.mindId}</div>
         <div class="card-body">

             <div class="container">
                  <div class="row">

                      <div class="col">
                         <div> Mind Name </div>
                         <div> ${orchardMind.mindName} </div>
                      </div>

                     <div class="col">
                     <div> Email </div>
                     <div> ${orchardMind.email} </div>
                     </div>

                    <div class="col">
                     <div> Phone </div>
                     <div> ${orchardMind.phone} </div>
                     </div>

                    <div class="col">
                    <div> Engg Stream </div>
                    <div> ${orchardMind.enggStream} </div>
                    </div>

                   <div class="col">
                   <div> Track </div>
                   <div> ${orchardMind.track} </div>
                   </div>

                  <div class="col">
                      <div>
                        <a href="/updateorchardmindmenu">
                        <input style="color:green" id="updateBtn" type="button" 
                       value="Update">
                        </a>
                      </div>

                      <div>
                       <input style="color:red" id="deleteBtn" type="button" 
                       value="Delete" onClick="deleteOrchardMindMethod(
                       ${orchardMind.mindId})">
                      </div>
                  </div>
                  
                  

                  </div>
             </div>


         </div>
         <div class="card-footer">
            Leads Assigned
         </div>

       </div>
       </br>
  
            
           
        
         `
        );




      
      } else {
        console.log("Get Method Failed");
        console.log("App_Fail: ", result);
      }
    },
    error: function (e) {
      console.log("ERROR: ", e);
    },
  });
}
