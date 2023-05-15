gblMaskInput=false;
gblMaskInput2=false;
gblMaskInput3=false;
gblOpcionFirma=1;
gblOpcionCombo=false;
gblOpcionInputExceda=false;

jQuery(function($){
    
    $.mask.definitions['h']='[0-2]';
    $.mask.definitions['m']='[0-5]';   
    
	//inicializarDialogo();
    if (gblOpcionInputExceda==false)
    {
        deshabilitaInputExceda();
       // verificaValidez();
        gblOpcionInputExceda=true;
    }   
});
    

function inicializarDialogo(){

//// inicializando  el dialogo
    vinput=document.getElementById('dlg_cambiarFirma');	
    $(vinput).dialog(
	{
	   autoOpen: false,
	   height: 250,
	   width: 550,
	   modal: true,
	   buttons: 
	   {
			  'Salir': function() 
			  {
			   
				$(this).dialog('close');
			  } ,
			  'Cambiar': function() 
			  {              
                          
                          var lista=document.getElementById('cmbFirmas');
                          var indice=lista.selectedIndex;
                          
                          if (indice>=0)
                          {
                          
                          var vval = lista.options[indice].value;
                          
                          if (vval!="ERR")
                          { 
                    
                              if (gblOpcionFirma==1)
                              {
                              
                                  var vInputfj=document.getElementById('_id5:hd_fj');
                                  vInputfj.value=vval;
                                  $(document.getElementById('_id5:txtFirma1')).html(vInputfj.value.replace("|","<br>"));
                                  
                               }else if (gblOpcionFirma==2){
                                  
                                  var vInputfj=document.getElementById('_id5:hd_tp');
                                  vInputfj.value=vval;
                                  $(document.getElementById('_id5:txtFirma2')).html(vInputfj.value.replace("|","<br>"));
                                  
                                  
                               }else if (gblOpcionFirma==3){
                                  
                                  var vInputfj=document.getElementById('_id5:hd_ts');
                                  vInputfj.value=vval;
                                  $(document.getElementById('_id5:txtFirma3')).html(vInputfj.value.replace("|","<br>"));
                                                                                    
                                }
                                  
                                  
                                $(this).dialog('close');
                                  
                              }
                          }                                                            
   		    }			
		},
		close: function()
		{
		  
		}
	});


}	
	
//---- para llamar al dialogo para que muestre las opciones	
function CambiarFirma(opcion){

 gblOpcionFirma=opcion;
  
 if ($('#dlg_cambiarFirma').dialog( "option", "modal" )!=true){
   inicializarDialogo();
   gblOpcionCombo=false;
 }
 
  if (opcion==1){
     $('#dlg_cambiarFirma').dialog("option", "title", 'Firma contrato' );
	}  
  else if (opcion==2){
     $('#dlg_cambiarFirma').dialog("option", "title", 'Firma toma posesión' );
   }  
  else if (opcion==3){ 
  
     $('#dlg_cambiarFirma').dialog("option", "title", 'Firma tramite de sueldo' );
	 
  }
 
  
 
  if (gblOpcionCombo==false) {
      $.getJSON("/Nomina/faces/consuljson?codop=1&var1="+opcion+"&var2="+new Date().getMilliseconds(), function(json){
           
      if (json!=null)
      {  
       if (json.length>0) 
       {
       
        
        
         for(var i=0; i < json.length; i++) 
         { 	           
             var newOption = new Option(json[i].nombre,json[i].firma);
             var lst = document.getElementById("cmbFirmas");
             if (lst) lst.options[lst.options.length] = newOption;
    
         }
         
       }else{
       
             var newOption = new Option("No se encontrarón firmas, por favor verifique.","ER");
             var lst = document.getElementById("cmbFirmas");
             if (lst) lst.options[lst.options.length] = newOption;
    
       }
       
         
       }else {
            
             
              }
        });
  gblOpcionCombo=true;       
  }
  
  $('#dlg_cambiarFirma').dialog('open');
  
  
  
return false;
}
	
	
function createHorarioAction(){
gblMaskInput=false;
gblMaskInput2=false;
return false;
}
	
function setMask(vInput){    

if (gblMaskInput==false) 
{
	
     $(vInput).mask("h9:m9");
     gblMaskInput=true;

}
return false;
}

function setMask2(vInput){    

if (gblMaskInput2==false) 
{
	
     $(vInput).mask("h9:m9");
     gblMaskInput2=true;

}
return false;
}


function setMaskHoraPos(){
     if (gblMaskInput3==false) {
	var vInput=document.getElementById('_id5:inptHoraPose');
        $(vInput).mask("h9:m9");
        gblMaskInput3=true;
    }
}



function check_rule(pcheck){

  if (pcheck.checked!=null && pcheck.checked==true){
    
     var vControl=document.getElementById('_id5:chk_paga_bono__xc_');     
     var vControl2=document.getElementById('_id5:chk_paga_bono');
     vControl2.disabled=false;     
     $(vControl).show(); 
  }
  else if (pcheck.checked!=null && pcheck.checked==false){
     var vControl=document.getElementById('_id5:chk_paga_bono__xc_');
     $(vControl).hide(); 
     
  }
}

function verificaValidez(){
var vList = document.getElementById("_id5:cmbValidezC");
var vIndice;
var vOpcion;

vIndice=vList.selectedIndex;
vOpcion = vList.options[vIndice].value;

var vInput = document.getElementById("_id5:inptNoExceda");
var vCmbIndef = document.getElementById("_id5:cmb_tipoIndef");

if (vOpcion=="G" || vOpcion=="J" ||vOpcion=="A" ||vOpcion=="P" || vOpcion=="T") {

   vInput.disabled=false;
   vCmbIndef.disabled=true;
   vCmbIndef.value=0;
   
}else if (vOpcion=="N"){

  vCmbIndef.disabled=true;
  vCmbIndef.value=0;

}else{

   vInput.disabled=true;
   vCmbIndef.disabled=false;
   
    if (vCmbIndef.value==0 || vCmbIndef.value==""||vCmbIndef.value==null){
      vCmbIndef.value=1;
    }
}

}


function deshabilitaInputExceda(){

 try
 {
 
      var vInput = document.getElementById("_id5:inptNoExceda");
      var vCmbIndef = document.getElementById("_id5:cmb_tipoIndef");
      
      if (vInput.value==null || vInput.value=="") {
        vInput.disabled=true;  
      }
      
      if (vCmbIndef.value==null || vCmbIndef.value=="" ||vCmbIndef.value==0) {
      
        vCmbIndef.disabled=true;
      }

 }catch(excep){
 
 }

}
