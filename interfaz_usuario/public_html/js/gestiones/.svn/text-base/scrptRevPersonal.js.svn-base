var t;
var timer_is_on=0;

$(function(){
	$.idleTimeout('#msgPendIdle', '#msgPendIdle a', {
		idleAfter: 300,
                warningLength: 300,
		onIdle: function(){
               
                $(this).slideDown();
                checkPendientes();
		 
				
		},
                onTimeout: function(){
               
                   checkPendientes();
                   
		},
		onActive: function(){			

                  clearPendientes();
                  $(this).slideUp();
                  submitForm('form1',1,{source:'form1:page1:cmdRefresT'});
					
		}
	});
});


      
function checkPendientes()      
{      
      
     // $("#msgPend").html("inactivo");
      
      $.getJSON("/Nomina/faces/consuljson?codop=3&var2="+new Date(), function(json){
           
      if (json!=null)
      {  
       if (json.length>0) 
       {

          $("#msgPendIdle").html(json[0].msg);
         
       }else{
       
       }
       
         
       }else {
            
             
              }
        });

}


function clearPendientes(){
         
  $("#msgPendIdle").html("");

}



function TimerBody()
{
checkPendientes();
t=setTimeout("TimerBody()",1000);
}

function doTimer()
{
if (!timer_is_on)
  {
  timer_is_on=1;
  TimerBody();
  }
}

function stopTimer()
{
clearTimeout(t);
timer_is_on=0;
}