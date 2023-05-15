$(function() {
        iniUsuario();         
	});

function setHandler1(){
var vinputAuto=document.getElementById('form1:inptDesti');
   if ($(vinputAuto).attr("autocomplete")==null)
   {
      iniUsuario();
   }else{
   cachePE = {};
   }
return false;
}


function verificaInput(){
try{
var vinputAuto=document.getElementById('form1:inptDesti');
if (vinpuAuto==null||(vinpuAuto!=null&&vinpuAuto.value==""))
{
cachePE = {};
//alert("uno");
}
}catch(excep){
cachePE = {};
//alert("dos");
}

return false;
}

function iniUsuario(){
 cachePE = {};
  var vinputAuto=document.getElementById('form1:inptDesti');	
				
		$(vinputAuto).autocomplete({
			source: function(request, response) {
				if (cachePE.term == request.term && cachePE.content) {
                                        response(cachePE.content);
					return;
				}
				if (new RegExp(cachePE.term).test(request.term) && cachePE.content && cachePE.content.length < 25) {
                                        response($.ui.autocomplete.filter(cachePE.content, request.term));
					return;
				}
				$.ajax({
					url: "/Nomina/faces/consuljson?codop=5&var2="+new Date().getMilliseconds(),
					dataType: "json",
					data: request,
					success: function(data) {
						cachePE.term = request.term;
						cachePE.content = data;
						response(data);
					}
				});
			},
			minLength: 0,
                        select: function(event, ui) {     
                         cachePE = {};
                        /*                        
                          $('#lblPartidaE').html(ui.item.NomPartida);
                          $('#lblPartidaE').show();
                        
                          var vinput3=document.getElementById('forma1:page1:valPE');	
                          vinput3.value=ui.item.codigo;
                        
                          var vinput4=document.getElementById('forma1:page1:valPEN');	
                          vinput4.value=ui.item.NomPartida;
                        */
                        
                        }

		});
return false;
}

