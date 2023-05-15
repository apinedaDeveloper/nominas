gblMaskInput=false;
gblMaskInput2=false;

jQuery(function($){
    $.mask.definitions['y']='[0-9]?';       
    
    $("a[rel^='prettyPhoto']").prettyPhoto({
			animationSpeed: 'normal', /* fast/slow/normal */
			opacity: 0.80, /* Value between 0 and 1 */
			showTitle: true, /* true/false */
                        modal: true,
                        social_tools:false,
                        default_width: 750,
			default_height: 600
		});       
});


   
function verDialog(empl)
{

$.prettyPhoto.open('../verreportepdf?id='+empl+'&rep=EMPLCHANGES?iframe=true','DETALLE DE CAMBIOS',null);

return false;
}
        

function setMaskFechaIng(){

    if (gblMaskInput==false) 
    {
     var vInputF=document.getElementById('_id4:paginaEmpl:inpt_fechaI');  
     $(vInputF).mask("99/99/yyyy",{placeholder:""});  
     
     gblMaskInput=true;
    }
    
return false;
}

function setMaskFechaNac(){

    if (gblMaskInput2==false)
    {
     var vInputF=document.getElementById('_id4:paginaEmpl:inpt_fechaN');    
     $(vInputF).mask("99/99/yyyy",{placeholder:""});     
     
     gblMaskInput2=true;
     
    }
    
return false;
}

function verificarCambioNom(){
  var vVerifica=document.getElementById('_id4:paginaEmpl:validaNombre');
  
   if (vVerifica.value!=null && (vVerifica.value==true ||vVerifica.value=="true"))  //preguntar por el cambio de nombre
   {   

    var vCmbNombre=document.getElementById('_id4:paginaEmpl:valorCmbNom');
            
       if (vCmbNombre.value==null || vCmbNombre.value=="") 
       {        
            $(function() {
            
		$( "#dialog:ui-dialog" ).dialog( "destroy" );
	
		$( "#dialog-confirm" ).dialog({
			resizable: false,
			height:260,
                        width:350,
			modal: true,
			buttons: {
                        
				"SI": function() {
                                
                                var vChkCambioNom=document.getElementById('_id4:paginaEmpl:chk_cambioNombre');
                                vChkCambioNom.checked = true;
                                
                                var vFlag=document.getElementById('_id4:paginaEmpl:valorCmbNom');
                                vFlag.value="1";
                                
				$( this ).dialog( "close" );
                                                                            
				},
				"NO": function() {
                                
                                         var vFlag=document.getElementById('_id4:paginaEmpl:valorCmbNom');
                                         vFlag.value="1";
                                                             
					$( this ).dialog( "close" );
				}
			}
		});
	});
        
        $('#dialog:ui-dialog').dialog('open');

       }

   }
            
}