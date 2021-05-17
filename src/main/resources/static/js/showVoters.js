console.log("show all orchard minds loaded!");

$(document).ready(function () {
  console.log("show Orchard Minds Ajax Clicked");
  console.log("called ajax Function");
  ajaxGet();

  // DO GET
  function ajaxGet() {
    $.ajax({
      type: "GET",
      url: "/orchardmind/",
      success: function (result) {
        if (result.status == "success") {
          console.log("Get method successfully executed");
          console.log("App_Result: ", result);
          var orchardMinds = result.data;
          $.each(orchardMinds, function (index, orchardMind) {
            console.log(orchardMind);
            $("#showOrchardMindsBox").append(
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
          });
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
});
